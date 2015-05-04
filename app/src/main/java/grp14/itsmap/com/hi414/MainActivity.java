package grp14.itsmap.com.hi414;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        MainFragment fragment1 = new MainFragment();
        //MainFragment fragment2 = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_linear_layout, fragment1).commit();
        //getSupportFragmentManager().beginTransaction().add(R.id.main_activity_linear_layout, fragment2).commit();

        //getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
    }
}