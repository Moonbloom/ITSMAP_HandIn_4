package grp14.itsmap.com.hi414.viewmodels;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.interfaces.AndroidLevelSelectorInterface;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends BaseFragmentActivity implements AndroidLevelSelectorInterface {

    private enum Orientation {
        PORTRAIT,
        LANDSCAPE
    }

    public static final String chosenLevelIndexTag = "chosen_level_index_tag";

    public static final String chosenIndexTag = "chosen_index";
    public static final String showDetailsTag = "show_details";

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;

    private Orientation phoneMode;

    @InjectView(R.id.main_activity_list_layout) LinearLayout listLayout;
    @InjectView(R.id.main_activity_content_layout) LinearLayout contentLayout;

    private final String listLayoutTag = "list_layout_tag";
    private final String contentLayoutTag = "content_layout_tag";

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
            intent.putExtra(chosenLevelIndexTag, chosenLevelIndex);
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
}