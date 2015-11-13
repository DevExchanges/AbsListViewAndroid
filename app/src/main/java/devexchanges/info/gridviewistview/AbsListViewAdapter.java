package devexchanges.info.gridviewistview;

import android.app.Activity;
import android.app.Dialog;
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

        convertView.setOnClickListener(onClickListener(getItem(position), String.valueOf(position + 1)));

        return convertView;
    }

    private View.OnClickListener onClickListener(final AsiaCountry country, String position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.layout_dialog);
                dialog.setTitle("Selected Country");

                TextView name = (TextView) dialog.findViewById(R.id.country_name);
                TextView position = (TextView) dialog.findViewById(R.id.pos);
                TextView viName = (TextView) dialog.findViewById(R.id.vi_name);
                ImageView image = (ImageView) dialog.findViewById(R.id.image);

                name.setText(country.getName());
                viName.setText(country.getVietnameseName());
                position.setText((CharSequence) position);

                image.setImageResource(country.getFlagResource());


                dialog.show();
            }
        };
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
