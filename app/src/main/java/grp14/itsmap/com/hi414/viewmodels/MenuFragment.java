package grp14.itsmap.com.hi414.viewmodels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import grp14.itsmap.com.hi414.R;
import grp14.itsmap.com.hi414.adapters.ListViewAdapter;
import grp14.itsmap.com.hi414.interfaces.AndroidLevelSelectorInterface;
import grp14.itsmap.com.hi414.models.AndroidLevel;

@SuppressWarnings("FieldCanBeLocal")
public class MenuFragment extends Fragment {

    //region Variables
    private ArrayList<AndroidLevel> list = new ArrayList<AndroidLevel>();
    private ListViewAdapter adapter;

    private AndroidLevelSelectorInterface androidLevelSelectorInterface;
    private BaseFragmentActivity mainActivity;
    //endregion

    //region Injects
    @InjectView(R.id.fragment_listview) ListView listView;

    @OnItemClick(R.id.fragment_listview)
    public void listViewItemClick(AdapterView<?> parent, View view, int position, long id) {
        androidLevelSelectorInterface.onAndroidLevelSelected(position);
    }
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        androidLevelSelectorInterface = (AndroidLevelSelectorInterface) getActivity();
        mainActivity = (BaseFragmentActivity) getActivity();
        list = mainActivity.getAndroidLevelList();

        adapter = new ListViewAdapter(getActivity(), R.layout.listview_item, list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        ButterKnife.inject(this, rootView);

        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.reset(this);
    }
}