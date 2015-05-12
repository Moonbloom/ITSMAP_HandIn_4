package grp14.itsmap.com.hi414.viewmodels;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

import grp14.itsmap.com.hi414.models.AndroidLevel;
import grp14.itsmap.com.hi414.utilities.AndroidLevelLoader;

public abstract class BaseFragmentActivity extends FragmentActivity {

    protected AndroidLevelLoader androidLevelLoader = new AndroidLevelLoader();

    protected ArrayList<AndroidLevel> androidLevelList;

    protected int chosenLevelIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        androidLevelList = androidLevelLoader.getAndroidLevels();

        super.onCreate(savedInstanceState);
    }

    public ArrayList<AndroidLevel> getAndroidLevelList() {
        return androidLevelList;
    }

    public AndroidLevel getCurrentSelectedAndroidLevel() {
        return androidLevelList.get(chosenLevelIndex);
    }
}