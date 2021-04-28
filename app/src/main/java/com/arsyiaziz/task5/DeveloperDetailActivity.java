package com.arsyiaziz.task5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DeveloperDetailActivity extends AppCompatActivity {
    public final static String details = "DEVELOPER_DETAILS";


    private ImageView ivDeveloperLogo;
    private TextView tvDeveloperName;
    private TextView tvDeveloperHQ;
    private TextView tvDeveloperSummary;
    private DeveloperModel developerDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDeveloperLogo = findViewById(R.id.iv_developer_logo);
        tvDeveloperName = findViewById(R.id.tv_developer_name);
        tvDeveloperHQ = findViewById(R.id.tv_developer_hq);
        tvDeveloperSummary = findViewById(R.id.tv_developer_summary);
    }

    @Override
    protected void onStart() {
        super.onStart();
        developerDetails = getIntent().getParcelableExtra(details);
        ivDeveloperLogo.setImageResource(developerDetails.getLogo());
        tvDeveloperName.setText(developerDetails.getName());
        tvDeveloperHQ.setText(developerDetails.getHQ());
        tvDeveloperSummary.setText(developerDetails.getSummary());
        getSupportActionBar().setTitle(developerDetails.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}