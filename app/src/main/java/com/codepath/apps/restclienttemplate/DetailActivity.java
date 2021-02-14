package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImageDetail;
    TextView tvNameDetail;
    TextView tvScreenNameDetail;
    TextView tvCreatedAtDetail;
    TextView tvBodyDetail;
//
//    Tweet tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfileImageDetail = findViewById(R.id.ivProfileImageDetail);
        tvNameDetail = findViewById(R.id.tvNameDetail);
        tvScreenNameDetail = findViewById(R.id.tvScreenNameDetail);
        tvCreatedAtDetail = findViewById(R.id.tvCreatedAtDetail);
        tvBodyDetail = findViewById(R.id.tvBodyDetail);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        Log.i("DetailActivity", "success get in to the detail page");

        tvBodyDetail.setText(tweet.getBody());
        tvNameDetail.setText(tweet.user.getName());
        tvScreenNameDetail.setText(tweet.user.getScreenName());
        tvCreatedAtDetail.setText(tweet.getFormattedTimestamp());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(80)).placeholder(R.drawable.ic_launcher);
        //Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileImageDetail);
        Glide.with(this).load(tweet.user.getProfileImageUrl()).apply(requestOptions).into(ivProfileImageDetail);
    }
}