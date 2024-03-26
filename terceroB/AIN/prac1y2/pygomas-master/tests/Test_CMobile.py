import unittest
import math
from jgomas.CMobile import CMobile
from jgomas.Vector3D import Vector3D


class TestCMobile(unittest.TestCase):

    def test_set_size(self):
        max_x = 5
        max_z = 10
        mobile = CMobile()
        mobile.SetSize(max_x, max_z)

        self.assertEqual(
            mobile.m_MinX,
            8
        )

        self.assertEqual(
            mobile.m_MinZ,
            8
        )

        self.assertEqual(
            mobile.m_MaxX,
            (max_x * 8) - 8
        )

        self.assertEqual(
            mobile.m_MaxZ,
            (max_z * 8) - 8
        )

    def test_calculate_position(self):
        dt = 0.001
        mobile = CMobile()
        mobile.m_Velocity = Vector3D(x=10, y=20, z=30)
        mobile.CalculatePosition(dt)

        self.assertEqual(
            mobile.m_Position.x,
            mobile.m_Velocity.x * dt
        )

        self.assertEqual(
            mobile.m_Position.y,
            0
        )

        self.assertEqual(
            mobile.m_Position.z,
            mobile.m_Velocity.z * dt
        )

    def test_calculate_new_orientation(self):
        mobile = CMobile()
        x = 10
        y = 20
        z = 30
        mobile.m_Destination = Vector3D(x=x, y=y, z=z)
        mobile.CalculateNewOrientation()
        leng = math.sqrt((x * x + y * y + z * z))

        self.assertEqual(
            mobile.m_Heading.x,
            x / leng
        )

        self.assertEqual(
            mobile.m_Heading.y,
            y / leng
        )

        self.assertEqual(
            mobile.m_Heading.z,
            z / leng
        )

    def test_calculate_new_destination(self):
        mobile = CMobile()
        radio_x = 10
        radio_y = 20
        max_x = 5
        max_z = 10
        mobile.SetSize(max_x, max_z)
        mobile.CalculateNewDestination(radio_x, radio_y)

        self.assertNotEqual(
            mobile.m_Destination.x,
            0
        )

        self.assertEqual(
            mobile.m_Destination.y,
            0
        )

        self.assertNotEqual(
            mobile.m_Destination.z,
            0
        )

    def test_getters(self):
        mobile = CMobile()

        destination = mobile.getDestination()
        position = mobile.getPosition()
        angle = mobile.getdAngle()
        radius = mobile.getdViewRadius()
        heading = mobile.getHeading()
        velocity = mobile.getVelocity()

        self.assertIsInstance(
            destination,
            Vector3D
        )

        self.assertIsInstance(
            position,
            Vector3D
        )

        self.assertEqual(
            angle,
            1
        )

        self.assertEqual(
            radius,
            50
        )

        self.assertIsInstance(
            heading,
            Vector3D
        )

        self.assertIsInstance(
            velocity,
            Vector3D
        )

    def test_setters(self):
        mobile = CMobile()
        vector = Vector3D(x=1, y=2, z=3)
        mobile.setDestination(vector)

        self.assertEqual(
            mobile.m_Destination.x,
            vector.x
        )

        self.assertEqual(
            mobile.m_Destination.y,
            vector.y
        )

        self.assertEqual(
            mobile.m_Destination.z,
            vector.z
        )
