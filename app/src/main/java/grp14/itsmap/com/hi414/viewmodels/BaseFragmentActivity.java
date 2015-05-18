package grp14.itsmap.com.hi414.viewmodels;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

import grp14.itsmap.com.hi414.models.AndroidLevel;
import grp14.itsmap.com.hi414.utilities.AndroidLevelLoader;

public abstract class BaseFragmentActivity extends FragmentActivity {

    //region Variables
    protected AndroidLevelLoader androidLevelLoader = new AndroidLevelLoader();

    protected ArrayList<AndroidLevel> androidLevelList;

    protected int chosenLevelIndex = 0;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        androidLevelList = androidLevelLoader.getAndroidLevels();

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            if (getActionBar() != null) {
                getActionBar().setIcon(android.R.color.transparent);
            }
        }

        super.onCreate(savedInstanceState);
    }

    protected ArrayList<AndroidLevel> getAndroidLevelList() {
        return androidLevelList;
    }
}