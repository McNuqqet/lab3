package com.example.myapplication;


import java.util.Arrays;
import java.util.List;

/**
 * Stores the list of possible structures. This has a static get() method for retrieving an
 * instance, rather than calling the constructor directly.
 *
 * The remaining methods -- get(int), size(), add(com.example.myapplication.Structure) and remove(int) -- provide
 * minimalistic list functionality.
 *
 * There is a static int array called DRAWABLES, which stores all the drawable integer references,
 * some of which are not actually used (yet) in a com.example.myapplication.Structure object.
 */
public class StructureData
{
    public static final int[] DRAWABLES = {
        0, // No structure
        R.drawable.ic_building1, R.drawable.ic_building2, R.drawable.ic_building3,
        R.drawable.ic_building4, R.drawable.ic_building5, R.drawable.ic_building6,
        R.drawable.ic_building7, R.drawable.ic_building8,
        R.drawable.ic_road_ns, R.drawable.ic_road_ew, R.drawable.ic_road_nsew,
        R.drawable.ic_road_ne, R.drawable.ic_road_nw, R.drawable.ic_road_se, R.drawable.ic_road_sw,
        R.drawable.ic_road_n, R.drawable.ic_road_e, R.drawable.ic_road_s, R.drawable.ic_road_w,
        R.drawable.ic_road_nse, R.drawable.ic_road_nsw, R.drawable.ic_road_new, R.drawable.ic_road_sew,
        R.drawable.ic_tree1, R.drawable.ic_tree2, R.drawable.ic_tree3, R.drawable.ic_tree4};

    private List<Structure> structureList = Arrays.asList(new Structure[] {
        new Structure(R.drawable.ic_building1, "House 1"),
        new Structure(R.drawable.ic_building2, "House 2"),
        new Structure(R.drawable.ic_building3, "House 3"),
        new Structure(R.drawable.ic_building4, "House 4"),
        new Structure(R.drawable.ic_building5, "House 5"),
        new Structure(R.drawable.ic_building6, "House 6"),
        new Structure(R.drawable.ic_building7, "House 7"),
        new Structure(R.drawable.ic_building8, "House 8"),
        new Structure(R.drawable.ic_road_ns, "Road 1"),
        new Structure(R.drawable.ic_road_ew, "Road 2"),
        new Structure(R.drawable.ic_road_nsew, "Road 3"),
        new Structure(R.drawable.ic_road_ne, "Road 4"),
        new Structure(R.drawable.ic_road_nw, "Road 5"),
        new Structure(R.drawable.ic_road_se, "Road 6"),
        new Structure(R.drawable.ic_road_sw, "Road 7"),
        new Structure(R.drawable.ic_road_n, "Road 8"),
        new Structure(R.drawable.ic_road_e, "Road 9"),
        new Structure(R.drawable.ic_road_s, "Road 10"),
        new Structure(R.drawable.ic_road_w, "Road 11"),
        new Structure(R.drawable.ic_road_nse, "Road 12"),
        new Structure(R.drawable.ic_road_nsw, "Road 13"),
        new Structure(R.drawable.ic_road_new, "Road 14"),
        new Structure(R.drawable.ic_road_sew, "Road 15"),
        new Structure(R.drawable.ic_tree1, "Tree 1"),
        new Structure(R.drawable.ic_tree2, "Tree 2"),
        new Structure(R.drawable.ic_tree3, "Tree 3"),
        new Structure(R.drawable.ic_tree4, "Tree 4"),
    });

    private static StructureData instance = null;

    public static StructureData get()
    {
        if(instance == null)
        {
            instance = new StructureData();
        }
        return instance;
    }

    protected StructureData() {}

    public Structure get(int i)
    {
        return structureList.get(i);
    }

    public int size()
    {
        return structureList.size();
    }

    public void add(Structure s)
    {
        structureList.add(0, s);
    }

    public void remove(int i)
    {
        structureList.remove(i);
    }
}
