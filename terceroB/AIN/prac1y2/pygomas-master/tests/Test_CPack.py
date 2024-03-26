import unittest
from pygomas.CPack import CPack
from pygomas.CJGomasAgent import CJGomasAgent
from spade.behaviour import OneShotBehaviour
from spade.message import Message
from spade.template import Template
import time


class TestCPack(unittest.TestCase):

    def test_setup(self):
        class TestBehaviour(OneShotBehaviour):
            async def run(self):
                res = await self.receive(timeout=10000)
                msg = Message(to="pack1@localhost")
                msg.set_metadata("performative", "inform")
                msg.body = "Hello"
                await self.send(msg)

        agent = CJGomasAgent('cmanager@localhost')
        agent.start()

        behav = TestBehaviour()
        agent.add_behaviour(behav)

        pack = CPack("pack1@localhost")

        pack.start()

        while not behav.done():
            time.sleep(1)

        agent.stop()

        pack.stop()
