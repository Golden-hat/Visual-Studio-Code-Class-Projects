import unittest
from jgomas.CThreshold import CThreshold


class TestCThreshold(unittest.TestCase):

    def test_getters(self):

        thresh = CThreshold()

        health = thresh.GetHealth()
        ammo = thresh.GetAmmo()
        aim = thresh.GetAim()
        shot = thresh.GetShot()
        look = thresh.GetLook()

        self.assertEqual(
            health,
            50
        )

        self.assertEqual(
            ammo,
            50
        )

        self.assertEqual(
            aim,
            1
        )

        self.assertEqual(
            shot,
            1
        )

        self.assertEqual(
            look,
            1
        )

    def test_upper_setters(self):

        thresh = CThreshold()

        health = 110
        ammo = 120
        aim = 30
        shot = 40
        look = 130

        thresh.SetHealth(health)
        thresh.SetAmmo(ammo)
        thresh.SetAim(aim)
        thresh.SetShot(shot)
        thresh.SetLook(look)

        self.assertEqual(
            thresh.m_iHealth,
            100
        )

        self.assertEqual(
            thresh.m_iAmmo,
            100
        )

        self.assertEqual(
            thresh.m_iAim,
            20
        )

        self.assertEqual(
            thresh.m_iShot,
            20
        )

        self.assertEqual(
            thresh.m_iLook,
            100
        )

    def test_lower_setters(self):

        thresh = CThreshold()

        health = -10
        ammo = -20
        aim = 0
        shot = -1
        look = -2

        thresh.SetHealth(health)
        thresh.SetAmmo(ammo)
        thresh.SetAim(aim)
        thresh.SetShot(shot)
        thresh.SetLook(look)

        self.assertEqual(
            thresh.m_iHealth,
            0
        )

        self.assertEqual(
            thresh.m_iAmmo,
            0
        )

        self.assertEqual(
            thresh.m_iAim,
            1
        )

        self.assertEqual(
            thresh.m_iShot,
            1
        )

        self.assertEqual(
            thresh.m_iLook,
            0
        )
