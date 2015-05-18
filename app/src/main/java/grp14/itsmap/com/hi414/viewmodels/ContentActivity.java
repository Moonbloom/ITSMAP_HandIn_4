package grp14.itsmap.com.hi414.viewmodels;

import android.os.Bundle;

import grp14.itsmap.com.hi414.R;

@SuppressWarnings("FieldCanBeLocal")
public class ContentActivity extends BaseFragmentActivity {

    //region Variables
    private ContentFragment contentFragment;

    private final String contentFragmentTag = "content_fragment_tag";
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);

        if(savedInstanceState == null) {
            chosenLevelIndex = getIntent().getIntExtra(MainActivity.chosenIndexTag, 0);

            contentFragment = new ContentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.content_activity_linear_layout, contentFragment, contentFragmentTag).commit();
        } else {
            chosenLevelIndex = savedInstanceState.getInt(MainActivity.chosenIndexTag);

            contentFragment = (ContentFragment)getSupportFragmentManager().findFragmentByTag(contentFragmentTag);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(MainActivity.chosenIndexTag, chosenLevelIndex);
        super.onSaveInstanceState(outState);
    }
}