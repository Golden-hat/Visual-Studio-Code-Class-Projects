import unittest
from jgomas.CSight import CSight
from jgomas.Vector3D import Vector3D


class TestCSight(unittest.TestCase):

    sight = CSight()

    def test_getters(self):

        angle = self.sight.getAngle()
        distance = self.sight.getDistance()
        team = self.sight.getTeam()
        type = self.sight.getType()
        health = self.sight.getHealth()
        position = self.sight.getPosition()

        self.assertEqual(
            angle,
            0
        )

        self.assertEqual(
            distance,
            0
        )

        self.assertEqual(
            team,
            0
        )

        self.assertEqual(
            type,
            0
        )

        self.assertEqual(
            health,
            0
        )

        self.assertIsInstance(
            position,
            Vector3D
        )
