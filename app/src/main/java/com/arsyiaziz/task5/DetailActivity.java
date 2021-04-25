package com.arsyiaziz.task5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public final static String details = "COMPUTER_Details";


    private ImageView ivComputerPhoto;
    private TextView tvComputerName;
    private TextView tvComputerReleaseDate;
    private TextView tvComputerSummary;
    private TextView tvComputerDeveloper;
    private TextView tvComputerIntroductoryPrice;
    private ComputerModel computerDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivComputerPhoto = findViewById(R.id.iv_computer_photo);
        tvComputerName = findViewById(R.id.tv_computer_name);
        tvComputerReleaseDate = findViewById(R.id.tv_computer_release_date);
        tvComputerSummary = findViewById(R.id.tv_computer_summary);
        tvComputerDeveloper = findViewById(R.id.tv_computer_developer);
        tvComputerIntroductoryPrice = findViewById(R.id.tv_computer_introductory_price);
    }

    @Override
    protected void onStart() {
        super.onStart();
        computerDetails = getIntent().getParcelableExtra(details);
        ivComputerPhoto.setImageResource(computerDetails.getPhoto());
        tvComputerName.setText(computerDetails.getName());
        tvComputerReleaseDate.setText(computerDetails.getReleaseDate());
        tvComputerSummary.setText(computerDetails.getSummary());
        tvComputerDeveloper.setText(computerDetails.getDeveloper());
        tvComputerIntroductoryPrice.setText(computerDetails.getIntroductoryPrice());
        getSupportActionBar().setTitle(computerDetails.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}