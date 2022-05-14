package com.example.intanfadila.emergencycovid19.view.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.example.intanfadila.emergencycovid19.R;
import com.example.intanfadila.emergencycovid19.utils.Constant;
import com.example.intanfadila.emergencycovid19.view.adapter.HospitalsPagerAdapter;
import java.android.synthetic.main.activity_hospitals.*;

/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class HospitalsActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        setSupportActionBar(toolbar);
        assert(supportActionBar != null);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowTitleEnabled(false);

        tvTitle.setText(Constant.kotaName);

        viewPager.setAdapter(HospitalsPagerAdapter(supportFragmentManager));
        viewPager.setOffscreenPageLimit(2);
        tabsLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onOptionsItemSelected(MenuItem item) Boolean {
        if (item.itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
