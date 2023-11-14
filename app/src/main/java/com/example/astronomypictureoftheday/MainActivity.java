package com.example.astronomypictureoftheday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private ImageView image;
    private TextView copyright;
    private TextView explanation;
    private DatePicker datePicker;
    private Button fetchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        copyright = findViewById(R.id.copyright);
        explanation = findViewById(R.id.explanation);
        datePicker = findViewById(R.id.date_picker);
        fetchButton = findViewById(R.id.fetch_button);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });

        fetchData();
    }

    private void fetchData() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dateString = dateFormat.format(calendar.getTime());

        APODService service = ApiClient.getClient().create(APODService.class);
        Call<APOD> call = service.getAPODData("DEMO_KEY", dateString);
        call.enqueue(new Callback<APOD>() {
            @Override
            public void onResponse(Call<APOD> call, Response<APOD> response) {
                if (response.isSuccessful()) {
                    APOD apodData = response.body();
                    if (apodData != null) {
                        title.setText(apodData.getTitle());
                        Picasso.get().load(apodData.getImageUrl()).into(image);
                        copyright.setText(apodData.getCopyright());
                        explanation.setText(apodData.getExplanation());
                    }
                }
            }

            @Override
            public void onFailure(Call<APOD> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
