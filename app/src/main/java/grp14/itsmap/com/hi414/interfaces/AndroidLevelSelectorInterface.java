package grp14.itsmap.com.hi414.interfaces;

import java.util.ArrayList;

import grp14.itsmap.com.hi414.models.AndroidLevel;

public interface AndroidLevelSelectorInterface {

    void onAndroidLevelSelected(int position);
    ArrayList<AndroidLevel> getAndroidLevelList();
    AndroidLevel getCurrentSelectedAndroidLevel();
}