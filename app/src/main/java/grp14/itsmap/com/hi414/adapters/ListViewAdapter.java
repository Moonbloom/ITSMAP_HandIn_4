package grp14.itsmap.com.hi414.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import grp14.itsmap.com.hi414.models.AndroidLevel;
import grp14.itsmap.com.hi414.R;

public class ListViewAdapter extends ArrayAdapter<AndroidLevel> {

    //region Variables
    private Context context;
    private int resource;
    private List<AndroidLevel> values;
    //endregion

    //region Injects
    @InjectView(R.id.listview_item_textview) TextView textView;
    //endregion

    //region Constructor
    public ListViewAdapter(Context context, int resource, List<AndroidLevel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.values = objects;
    }
    //endregion

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
        }

        ButterKnife.inject(this, convertView);

        AndroidLevel level = values.get(position);
        textView.setText(level.getName());

        return convertView;
    }
}