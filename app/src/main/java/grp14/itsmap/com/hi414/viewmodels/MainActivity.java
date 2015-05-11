package grp14.itsmap.com.hi414.viewmodels;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.interfaces.AndroidLevelSelectorInterface;
import grp14.itsmap.com.hi414.models.AndroidLevel;
import grp14.itsmap.com.hi414.utilities.AndroidLevelLoader;

public class MainActivity extends FragmentActivity implements AndroidLevelSelectorInterface {

    public enum PhoneMode {
        PORTRAIT,
        LANDSCAPE
    }

    public static String chosenLevelIndexTag = "chosen_level_index_tag";

    private final String selectedIndexTag = "selected_index";
    private final String showDetailsTag = "show_details";

    private ArrayList<AndroidLevel> androidLevelList;

    private AndroidLevelLoader androidLevelLoader = new AndroidLevelLoader();

    private int selectedALindex = 0;
    private boolean showDetails = false;

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;

    private PhoneMode phoneMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        androidLevelList = androidLevelLoader.getAndroidLevels();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            phoneMode = PhoneMode.PORTRAIT;
        } else {
            phoneMode = PhoneMode.LANDSCAPE;
        }

        MenuFragment fragment = new MenuFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_linear_layout, fragment).commit();

        //getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(selectedIndexTag, selectedALindex);
        outState.putBoolean(showDetailsTag, showDetails);
        super.onSaveInstanceState(outState);
    }

    private void showAndroidLevelDetails() {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(chosenLevelIndexTag, selectedALindex);
        startActivity(intent);
    }

    //region AndroidLevelSelectorInterface implementation
    @Override
    public void onAndroidLevelSelected(int position) {
        selectedALindex = position;

        showAndroidLevelDetails();
    }

    @Override
    public ArrayList<AndroidLevel> getAndroidLevelList() {
        return androidLevelList;
    }

    @Override
    public AndroidLevel getCurrentSelectedAndroidLevel() {
        return androidLevelList.get(selectedALindex);
    }
    //endregion
}