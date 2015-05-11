package grp14.itsmap.com.hi414.viewmodels;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.utilities.AndroidLevelLoader;

public class ContentActivity extends FragmentActivity {

    private AndroidLevelLoader androidLevelLoader = new AndroidLevelLoader();

    private int chosenLevelIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);

        chosenLevelIndex = getIntent().getIntExtra(MainActivity.chosenLevelIndexTag, 0);

        ContentFragment fragment = new ContentFragment();
        fragment.setAndroidLevel(androidLevelLoader.getAndroidLevels().get(chosenLevelIndex));
        getSupportFragmentManager().beginTransaction().add(R.id.content_activity_linear_layout, fragment).commit();
    }
}