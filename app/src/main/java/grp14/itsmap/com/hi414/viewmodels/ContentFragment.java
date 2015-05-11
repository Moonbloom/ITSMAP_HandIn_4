package grp14.itsmap.com.hi414.viewmodels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.models.AndroidLevel;

public class ContentFragment extends Fragment {

    private AndroidLevel androidLevel;

    @InjectView(R.id.content_fragment_name_textview) TextView nameTextView;
    @InjectView(R.id.content_fragment_api_level_textview) TextView apiTextView;
    @InjectView(R.id.content_fragment_version_number_textview) TextView versionTextView;
    @InjectView(R.id.content_fragment_description_textview) TextView descriptionTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_fragment, container, false);

        ButterKnife.inject(this, rootView);

        nameTextView.setText(androidLevel.getName());
        apiTextView.setText(androidLevel.getApiLevel());
        versionTextView.setText(androidLevel.getVersionNumber());
        descriptionTextView.setText(androidLevel.getDescription());

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.reset(this);
    }

    public void setAndroidLevel(AndroidLevel level) {
        this.androidLevel = level;
    }
}