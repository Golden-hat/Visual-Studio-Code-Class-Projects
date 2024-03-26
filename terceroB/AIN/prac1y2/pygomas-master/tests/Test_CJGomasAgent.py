import unittest
from jgomas.CJGomasAgent import CJGomasAgent
from jgomas.CRegistry import CRegistry


class TestCJGomasAgent(unittest.TestCase):

    def test_add_service(self):
        agent = CJGomasAgent("agent@localhost", "agent", 0)
        agent.start()
        agent.stop()


