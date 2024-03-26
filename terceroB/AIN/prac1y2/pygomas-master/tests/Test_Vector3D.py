import unittest
from jgomas.Vector3D import Vector3D


class TestVector3D(unittest.TestCase):

    vector = Vector3D(x=3, y=4, z=12)

    def test_length(self):

        res = self.vector.__len__()

        self.assertEqual(
            res,
            13
        )

    def test_add(self):

        vector = Vector3D(x=1, y=2, z=3)
        vector.add(self.vector)

        self.assertEqual(
            vector.x,
            4
        )

        self.assertEqual(
            vector.y,
            6
        )

        self.assertEqual(
            vector.z,
            15
        )

    def test_sub(self):

        vector = Vector3D(x=1, y=3, z=3)
        vector.sub(self.vector)

        self.assertEqual(
            vector.x,
            -2
        )

        self.assertEqual(
            vector.y,
            -1
        )

        self.assertEqual(
            vector.z,
            -9
        )

    def test_dot(self):

        vector = Vector3D(x=2, y=3, z=0.5)
        reply = vector.dot(self.vector)

        self.assertEqual(
            reply,
            24
        )

    def test_normalize(self):

        vector = Vector3D(self.vector)
        leng = vector.length()
        vector.normalize()

        self.assertEqual(
            vector.x,
            self.vector.x/leng
        )

        self.assertEqual(
            vector.y,
            self.vector.y / leng
        )

        self.assertEqual(
            vector.z,
            self.vector.z / leng
        )

    def test_cross(self):

        vector_x = Vector3D(x=1)
        vector_y = Vector3D(y=1)

        vector_z = vector_x.cross(vector_y)

        self.assertEqual(
            vector_z.x,
            0
        )

        self.assertEqual(
            vector_z.y,
            0
        )

        self.assertEqual(
            vector_z.z,
            1
        )

    def test_str(self):

        res = str(self.vector)

        self.assertEqual(
            res,
            '<3,4,12>'
        )
