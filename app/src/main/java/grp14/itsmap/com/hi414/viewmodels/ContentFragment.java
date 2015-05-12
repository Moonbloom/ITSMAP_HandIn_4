package grp14.itsmap.com.hi414.viewmodels;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.models.AndroidLevel;
import grp14.itsmap.com.hi414.utilities.AndroidLevelLoader;

@SuppressWarnings("FieldCanBeLocal")
public class ContentFragment extends Fragment {

    private AndroidLevelLoader androidLevelLoader = new AndroidLevelLoader();

    private BaseFragmentActivity baseFragmentActivity;
    private AndroidLevel androidLevel;

    @InjectView(R.id.content_fragment_logo_imageview) ImageView logoImageView;
    @InjectView(R.id.content_fragment_name_textview) TextView nameTextView;
    @InjectView(R.id.content_fragment_api_level_textview) TextView apiTextView;
    @InjectView(R.id.content_fragment_version_number_textview) TextView versionTextView;
    @InjectView(R.id.content_fragment_description_textview) TextView descriptionTextView;
    @InjectView(R.id.content_fragment_current_version_textview) TextView currentVersionTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_fragment, container, false);

        ButterKnife.inject(this, rootView);

        baseFragmentActivity = (BaseFragmentActivity) getActivity();
        androidLevel = androidLevelLoader.getAndroidLevels().get(baseFragmentActivity.chosenLevelIndex);

        updateView();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.reset(this);
    }

    public void setAndroidLevel(AndroidLevel androidLevel) {
        this.androidLevel = androidLevel;
        updateView();
    }

    private void updateView() {
        logoImageView.setImageResource(androidLevel.getImageResource());
        nameTextView.setText(androidLevel.getName());
        apiTextView.setText(androidLevel.getApiLevel());
        versionTextView.setText(androidLevel.getVersionNumber());
        descriptionTextView.setText(androidLevel.getDescription());

        setCurrentVersionTextView();
    }

    private void setCurrentVersionTextView() {
        int currentVersion = Build.VERSION.SDK_INT;
        boolean match = false;
        String formatted = androidLevel.getApiLevel().replace(" ", "");
        String[] versions = formatted.split(",");
        for (String version : versions) {
            if (Integer.valueOf(version) == currentVersion) {
                match = true;
            }
        }

        if(match) {
            currentVersionTextView.setText(R.string.content_fragment_using_current_version_text);
            currentVersionTextView.setTextColor(getActivity().getResources().getColor(R.color.MaterialGreen));
        } else {
            currentVersionTextView.setText(R.string.content_fragment_not_current_version_text);
            currentVersionTextView.setTextColor(getActivity().getResources().getColor(R.color.MaterialRed));
        }
    }
}