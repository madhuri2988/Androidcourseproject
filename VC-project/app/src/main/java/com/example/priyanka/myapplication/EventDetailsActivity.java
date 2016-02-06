package com.example.priyanka.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EventDetailsActivity extends AppCompatActivity {


    ImageView detailImage;
    TextView tvCalendar;
    TextView tvLink;
    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        EventItem event = (EventItem)getIntent().getSerializableExtra("event");
        detailImage=(ImageView)findViewById(R.id.detailImage);
        tvLink=(TextView)findViewById(R.id.tvLink);
        tvDetails=(TextView)findViewById(R.id.tvDetails);
        tvCalendar=(TextView)findViewById(R.id.tvCalendar);

        tvLink.setText(event.getDesc());
        int image=event.getImage();
        detailImage.setImageResource(image);
        tvDetails.setText(event.getDesc());
        tvLink.setText(event.getLink());

        DateFormat df = new SimpleDateFormat("MM/dd HH:mm");
        tvCalendar.setText( df.format(event.getDate()));
       /* String imageName=event.getImage();
        String eventName=event.getName();
        String eventDesc=event.getDesc();
        InputStream inputStream = null;
        try {
            inputStream = getApplicationContext().getAssets().open(imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Drawable drawable = Drawable.createFromStream(inputStream, null);
        detailImage.setImageDrawable(drawable);
        //detailImage.setScaleType(ImageView.ScaleType.CENTER_CROP);*/
        final View coordinatorLayout = findViewById(R.id.snackbarPossition);
        SpannableStringBuilder snackBarText = new SpannableStringBuilder();

        int bold = snackBarText.length();
        snackBarText.append("Add ");
        snackBarText.append("this event");



        Snackbar.make(coordinatorLayout, snackBarText, Snackbar.LENGTH_INDEFINITE)
                .setAction("Add" , clickListener)
                .show();
    }
    final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
