package com.reynaldiwijaya.nbsweatherprediction.ui.detail;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.reynaldiwijaya.nbsweatherprediction.R;
import com.reynaldiwijaya.nbsweatherprediction.model.Item;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailWeatherActivity extends AppCompatActivity
        implements DetailWeatherContract {

    public static final String OBJ = "obj";
    @BindView(R.id.imgCity)
    ImageView imgCity;
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_main)
    TextView tvMain;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private Item item;
    private String city;
    private int imageCity;
    private DetailWeatherPresenter detailWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather);
        ButterKnife.bind(this);

        item = getIntent().getParcelableExtra(OBJ);

        setTitle(item.getCity());
        city = item.getCity();
        imageCity = item.getImage();
        Glide.with(this)
                .load(imageCity)
                .into(imgCity);

        detailWeatherPresenter = new DetailWeatherPresenter(this);
        detailWeatherPresenter.getWeather(city);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                detailWeatherPresenter.getWeather(city);
            }
        });

    }

    @Override
    public void showProgress() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefresh.setRefreshing(false);

    }

    @Override
    public void showData(double temp, String desc, String main) {
        String temprature = new DecimalFormat("##.##").format(temp);

        tvDesc.setText(desc);
        tvMain.setText(main);
        tvTemp.setText(temprature);
    }

    @Override
    public void showFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
