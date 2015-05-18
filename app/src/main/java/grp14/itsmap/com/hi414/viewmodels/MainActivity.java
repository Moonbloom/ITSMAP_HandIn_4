package grp14.itsmap.com.hi414.viewmodels;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import butterknife.ButterKnife;
import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.interfaces.AndroidLevelSelectorInterface;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends BaseFragmentActivity implements AndroidLevelSelectorInterface {

    //region Variables
    private final String listLayoutTag = "list_layout_tag";
    private final String contentLayoutTag = "content_layout_tag";

    public static final String chosenIndexTag = "chosen_index";

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;

    private Orientation phoneMode;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.inject(this);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            phoneMode = Orientation.PORTRAIT;
        } else {
            phoneMode = Orientation.LANDSCAPE;
        }

        if(savedInstanceState == null) {
            chosenLevelIndex = 0;

            menuFragment = new MenuFragment();
            contentFragment = new ContentFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_activity_list_layout, menuFragment, listLayoutTag)
                    .add(R.id.main_activity_content_layout, contentFragment, contentLayoutTag)
                    .commit();
        } else {
            chosenLevelIndex = savedInstanceState.getInt(chosenIndexTag);

            menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentByTag(listLayoutTag);
            contentFragment = (ContentFragment) getSupportFragmentManager().findFragmentByTag(contentLayoutTag);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(chosenIndexTag, chosenLevelIndex);
        super.onSaveInstanceState(outState);
    }

    private void showAndroidLevelDetails() {
        if(phoneMode == Orientation.PORTRAIT) {
            Intent intent = new Intent(this, ContentActivity.class);
            intent.putExtra(chosenIndexTag, chosenLevelIndex);
            startActivity(intent);
        } else {
            contentFragment.setAndroidLevel(androidLevelList.get(chosenLevelIndex));
        }
    }

    //region AndroidLevelSelectorInterface implementation
    @Override
    public void onAndroidLevelSelected(int position) {
        chosenLevelIndex = position;

        showAndroidLevelDetails();
    }
    //endregion

    //region Orientation enum
    private enum Orientation {
        PORTRAIT,
        LANDSCAPE
    }
    //endregion
}