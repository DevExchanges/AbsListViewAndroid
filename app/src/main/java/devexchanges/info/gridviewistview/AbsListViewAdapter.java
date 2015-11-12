package devexchanges.info.gridviewistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AbsListViewAdapter extends ArrayAdapter<AsiaCountry> {

    private Activity activity;
    private List<AsiaCountry> countries;

    public AbsListViewAdapter(Activity context, int resource, List<AsiaCountry> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.countries = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_abslistview, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.flag.setImageResource(getItem(position).getFlagResource());
        holder.countryName.setText(getItem(position).getName());

        return convertView;
    }

    private static class ViewHolder {
        private ImageView flag;
        private TextView countryName;

        public ViewHolder(View v) {
            flag = (ImageView) v.findViewById(R.id.flag);
            countryName = (TextView) v.findViewById(R.id.country_name);
        }
    }
}
