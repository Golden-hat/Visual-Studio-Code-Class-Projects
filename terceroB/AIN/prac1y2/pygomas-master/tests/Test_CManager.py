import unittest
from jgomas.CManager import CManager

class TestCManager(unittest.TestCase):

    def test_start(self):
        agent = CManager("agent@localhost", "agent", 0)
        agent.start()
        agent.stop()
