package grp14.itsmap.com.hi414;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<AndroidLevel> {

    private List<AndroidLevel> values;
    private Context context;

    public ListViewAdapter(Context context, int resource, List<AndroidLevel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        TextView textView = (TextView)convertView.findViewById(R.id.listview_item_textview);
        AndroidLevel level = values.get(position);
        textView.setText(level.getName());

        return convertView;
    }
}