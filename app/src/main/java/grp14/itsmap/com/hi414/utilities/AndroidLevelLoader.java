package grp14.itsmap.com.hi414.utilities;

import java.util.ArrayList;

import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.models.AndroidLevel;

public class AndroidLevelLoader {

    public ArrayList<AndroidLevel> getAndroidLevels() {
        ArrayList<AndroidLevel> list = new ArrayList<AndroidLevel>();
        list.add(new AndroidLevel("Cupcake",            "3",            "1.5",          "This is Cupcake ...",              R.drawable.cupcake));
        list.add(new AndroidLevel("Donut",              "4",            "1.6",          "This is Donut ...",                R.drawable.donut));
        list.add(new AndroidLevel("Eclair",             "5, 6, 7",      "2.0 - 2.1",    "This is Eclair ...",               R.drawable.eclair));
        list.add(new AndroidLevel("Froyo",              "8",            "2.2",          "This is Froyo ...",                R.drawable.froyo));
        list.add(new AndroidLevel("Gingerbread",        "9, 10",        "2.3",          "This is Gingerbread ...",          R.drawable.gingerbread));
        list.add(new AndroidLevel("Honeycomb",          "11, 12, 13",   "3.0 - 3.2",    "This is Honeycomb ...",            R.drawable.honeycomb));
        list.add(new AndroidLevel("Ice Cream Sandwich", "14, 15",       "4.0",          "This is Ice Cream Sandwich ...",   R.drawable.icecreamsandwich));
        list.add(new AndroidLevel("Jelly Bean",         "16, 17, 18",   "4.1 - 4.3",    "This is Jelly Bean ...",           R.drawable.jellybean));
        list.add(new AndroidLevel("KitKat",             "19, 20",       "4.4",          "This is KitKat ...",               R.drawable.kitkat));
        list.add(new AndroidLevel("Lollipop",           "21, 22",       "5.0 - 5.1",    "This is Lollipop ...",             R.drawable.lollipop));

        return list;
    }
}