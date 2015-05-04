package grp14.itsmap.com.hi414;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private ArrayList<AndroidLevel> list = new ArrayList<AndroidLevel>();
    private ListViewAdapter adapter;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list.add(new AndroidLevel("Cupcake",            "3",        "1.5",          "This is Cupcake ..."));
        list.add(new AndroidLevel("Donut",              "4",        "1.6",          "This is Donut ..."));
        list.add(new AndroidLevel("Éclair",             "5 - 7",    "2.0 - 2.1",    "This is Éclair ..."));
        list.add(new AndroidLevel("Froyo",              "8",        "2.2",          "This is Froyo ..."));
        list.add(new AndroidLevel("Gingerbread",        "9 - 10",   "2.3",          "This is Gingerbread ..."));
        list.add(new AndroidLevel("Honeycomb",          "11 - 13",  "3.0 - 3.2",    "This is Honeycomb ..."));
        list.add(new AndroidLevel("Icecream Sandwich",  "14 - 15",  "4.0",          "This is Icecream Sandwich ..."));
        list.add(new AndroidLevel("Jelly Bean",         "16 - 18",  "4.1 - 4.3",    "This is Jelly Bean ..."));
        list.add(new AndroidLevel("KitKat",             "19 - 20",  "4.4",          "This is KitKat ..."));
        list.add(new AndroidLevel("Lollipop",           "21 - 22",  "5.0 - 5.1",    "This is Lollipop ..."));

        adapter = new ListViewAdapter(getActivity(), R.layout.listview_item, list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        listView = (ListView)rootView.findViewById(R.id.fragment_listview);

        listView.setAdapter(adapter);

        return rootView;
    }
}