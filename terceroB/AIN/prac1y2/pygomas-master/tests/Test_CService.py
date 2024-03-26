import unittest
from jgomas.CJGomasAgent import CJGomasAgent
from jgomas.CService import CService
from spade.message import Message
from spade.behaviour import OneShotBehaviour
import time


class TestCService(unittest.TestCase):
    def test_register_service(self):
        service = CService()
        service.start()
        service.register_service('Hello', 'sender@localhost')
        service.register_service('Hello', 'receiver@localhost')

        self.assertEqual(
            service.m_ServiceList,
            {'Hello': ['sender@localhost', 'receiver@localhost']}
        )

        service.stop()

    def test_deregister_service(self):
        service = CService()
        service.start()
        service.register_service('Hello', 'sender@localhost')
        service.deregister_service('Hello', 'sender@localhost')

        self.assertEqual(
            service.m_ServiceList,
            {'Hello': []}
        )

        service.stop()

    def test_get_service(self):
        service = CService()
        service.start()
        res1 = service.get_service('Hello')
        service.register_service('Hello', 'sender@localhost')
        res2 = service.get_service('Hello')

        self.assertEqual(
            res1,
            []
        )

        self.assertEqual(
            res2,
            ['sender@localhost']
        )

        service.stop()

    def test_behaviour(self):
        class TestBehaviour(OneShotBehaviour):
            async def run(self):
                msg = Message(to="cservice@localhost")  # Instantiate the message
                msg.set_metadata("performative", "register")  # Set the "inform" FIPA performative
                msg.body = "Hello"  # Set the message content
                await self.send(msg)

                msg = Message(to="cservice@localhost")
                msg.set_metadata("performative", "get")
                msg.body = "Hello"
                await self.send(msg)
                res = await self.receive(timeout=10000)

                msg = Message(to="cservice@localhost")
                msg.set_metadata("performative", "deregister_service")
                msg.body = "Hello"
                await self.send(msg)

        service = CService()
        service.start()

        agent = CJGomasAgent('sender@localhost')
        agent.start()

        behav = TestBehaviour()
        agent.add_behaviour(behav)
        
        while not behav.done():
            time.sleep(1)
        service.stop()
        agent.stop()

service = TestCService()
service.test_behaviour()