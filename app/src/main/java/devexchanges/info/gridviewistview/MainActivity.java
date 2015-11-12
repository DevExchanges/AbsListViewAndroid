package devexchanges.info.gridviewistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AbsListView absListView;
    private ArrayAdapter<AsiaCountry> adapter;
    private ArrayList<AsiaCountry> countryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        absListView = (AbsListView)findViewById(R.id.list_item);
        settingData();

        adapter = new AbsListViewAdapter(this, R.layout.item_abslistview, countryArrayList);
        absListView.setAdapter(adapter);
    }

    private void settingData() {
        countryArrayList = new ArrayList<>();

        countryArrayList.add(new AsiaCountry(R.mipmap.vietnam, "Vietnam", "Việt "));
        countryArrayList.add(new AsiaCountry(R.mipmap.afghanistan, "Afghanistan", "Áp-ga-nix-tan"));
        countryArrayList.add(new AsiaCountry(R.mipmap.brunei, "Brunei", "Bru-nây"));
        countryArrayList.add(new AsiaCountry(R.mipmap.cambodia, "Cambodia", "Cam-pu-chia"));
        countryArrayList.add(new AsiaCountry(R.mipmap.china, "China", "Trung Quốc"));
        countryArrayList.add(new AsiaCountry(R.mipmap.india, "India", "Ấn Độ"));
        countryArrayList.add(new AsiaCountry(R.mipmap.indonesia, "Indonesia", "In-đô-nê-xi-a"));
        countryArrayList.add(new AsiaCountry(R.mipmap.iran, "Iran", "I-ran"));
        countryArrayList.add(new AsiaCountry(R.mipmap.japan, "Japan", "Nhật Bản"));
        countryArrayList.add(new AsiaCountry(R.mipmap.laos, "Laos", "Lào"));
        countryArrayList.add(new AsiaCountry(R.mipmap.north_korea, "North Korea", "Triều Tiên"));
        countryArrayList.add(new AsiaCountry(R.mipmap.singapore, "Singapore", "Singapore"));
        countryArrayList.add(new AsiaCountry(R.mipmap.south_korea, "South Korea", "Hàn Quốc"));
        countryArrayList.add(new AsiaCountry(R.mipmap.taiwan, "Taiwan", "Đài Loan"));
        countryArrayList.add(new AsiaCountry(R.mipmap.thailand, "Thailand", "Thái Lan"));
    }
}
