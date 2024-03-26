import unittest
from pygomas.CConfig import CConfig


class TestCConfig(unittest.TestCase):

    def test_set_data_path(self):
        config = CConfig()

        self.assertEqual(
            config.m_dataPath,
            "../../../../data/maps/"
        )

        config.setDataPath("./data")

        self.assertEqual(
            config.m_dataPath,
            "./data/"
        )
