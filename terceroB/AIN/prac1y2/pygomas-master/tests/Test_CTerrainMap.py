import unittest
from jgomas.CTerrainMap import CBase, CTerrain, CTerrainMap
from jgomas.CConfig import CConfig


class TestCBase(unittest.TestCase):

    base = CBase()

    def test_getters(self):

        init_x = self.base.GetInitX()
        init_y = self.base.GetInitY()
        init_z = self.base.GetInitZ()
        end_x = self.base.GetEndX()
        end_y = self.base.GetEndY()
        end_z = self.base.GetEndZ()

        self.assertEqual(
            init_x,
            0
        )

        self.assertEqual(
            init_y,
            0
        )

        self.assertEqual(
            init_z,
            0
        )

        self.assertEqual(
            end_x,
            0
        )

        self.assertEqual(
            end_y,
            0
        )

        self.assertEqual(
            end_z,
            0
        )


class TestCTerrain(unittest.TestCase):

    def test_repr(self):
        terrain = CTerrain()

        self.assertEqual(
            terrain.__repr__(),
            "*"
        )

        terrain.m_bCanWalk = True

        self.assertEqual(
            terrain.__repr__(),
            "_"
        )


class TestCTerrainMap(unittest.TestCase):

    def test_getters(self):
        terrain_map = CTerrainMap()

        size_x = terrain_map.GetSizeX()
        size_z = terrain_map.GetSizeZ()
        target_x = terrain_map.GetTargetX()
        target_y = terrain_map.GetTargetY()
        target_z = terrain_map.GetTargetZ()

        self.assertEqual(
            size_x,
            0
        )

        self.assertEqual(
            size_z,
            0
        )

        self.assertEqual(
            target_x,
            0
        )

        self.assertEqual(
            target_y,
            0
        )

        self.assertEqual(
            target_z,
            0
        )

    def test_can_walk(self):

        terrain_map = CTerrainMap()
        x = 0
        z = 0

        can_walk = terrain_map.CanWalk(x, z)

        self.assertFalse(
            can_walk
        )

        terrain_map.m_iSizeX = 1
        terrain_map.m_iSizeZ = 1
        terrain_map.m_Terrain = []
        terrain_map.m_Terrain.append([])
        terrain = CTerrain()
        terrain.m_bCanWalk = True
        terrain_map.m_Terrain[0].append(terrain)

        can_walk = terrain_map.CanWalk(x, z)

        self.assertTrue(
            can_walk
        )

    def test_get_cost(self):

        terrain_map = CTerrainMap()
        x = 0
        z = 0

        cost = terrain_map.GetCost(x, z)

        self.assertEqual(
            cost,
            20000
        )

        terrain_map.m_iSizeX = 1
        terrain_map.m_iSizeZ = 1
        terrain_map.m_Terrain = []
        terrain_map.m_Terrain.append([])
        terrain = CTerrain()
        terrain.m_iCost = 10
        terrain_map.m_Terrain[0].append(terrain)

        cost = terrain_map.GetCost(x, z)

        self.assertEqual(
            cost,
            10
        )

    def test_load_map(self):

        terrain_map = CTerrainMap()
        config = CConfig()
        config.setDataPath("./tests/test_maps")
        file = "map_01"

        terrain_map.LoadMap(file, config)

        self.assertGreater(
            len(terrain_map.m_Terrain),
            0
        )

        self.assertGreater(
            len(terrain_map.m_Terrain[0]),
            0
        )

    def test_load_map_failed(self):

        terrain_map = CTerrainMap()
        config = CConfig()
        config.setDataPath("./tests/test_maps")
        file = "map_00"

        terrain_map.LoadMap(file, config)

        self.assertEqual(
            terrain_map.m_iSizeX,
            0
        )

        self.assertEqual(
            terrain_map.m_iSizeZ,
            0
        )

    def test_str(self):
        terrain_map = CTerrainMap()
        config = CConfig()
        config.setDataPath("./tests/test_maps")
        file = "map_01"

        terrain_map.LoadMap(file, config)
        res = str(terrain_map)

        self.assertIsInstance(
            res,
            str
        )
