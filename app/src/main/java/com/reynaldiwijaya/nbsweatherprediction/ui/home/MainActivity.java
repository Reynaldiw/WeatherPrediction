package com.reynaldiwijaya.nbsweatherprediction.ui.home;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reynaldiwijaya.nbsweatherprediction.R;
import com.reynaldiwijaya.nbsweatherprediction.adapter.WeatherAdapter;
import com.reynaldiwijaya.nbsweatherprediction.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String[] city = getResources().getStringArray(R.array.country);
        TypedArray image = getResources().obtainTypedArray(R.array.image);

        for (int i = 0; i < city.length; i++) {
            items.add(new Item(city[i], image.getResourceId(i, 0)));
        }

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(new WeatherAdapter(this, items));
        rvMain.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
}
