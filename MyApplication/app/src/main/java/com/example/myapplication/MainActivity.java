import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.JokeApiService;
import com.example.myapplication.JokeModel;
import com.example.myapplication.R;
import com.example.myapplication.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeTextView = findViewById(R.id.jokeTextView);

        // Fetch a joke when the activity is created
        fetchJoke();
    }

    private void fetchJoke() {
        JokeApiService jokeApiService = RetrofitInstance.getJokeApiService();
        Call<JokeModel> call = jokeApiService.getRandomJoke("Programming");

        call.enqueue(new Callback<JokeResponse>() {
            @Override
            public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
                if (response.isSuccessful()) {
                    JokeResponse joke = response.body();
                    displayJoke(joke);
                } else {
                    jokeTextView.setText("Failed to fetch joke");
                }
            }

            @Override
            public void onFailure(Call<JokeResponse> call, Throwable t) {
                jokeTextView.setText("Network error");
            }
        });
    }

    private void displayJoke(JokeResponse joke) {
        if (joke != null) {
            if (!joke.isError()) {
                String jokeText;
                if ("twopart".equals(joke.getType())) {
                    jokeText = String.format("%s\n%s", joke.getSetup(), joke.getDelivery());
                } else {
                    jokeText = joke.getSetup();
                }
                jokeTextView.setText(jokeText);
            } else {
                jokeTextView.setText("Error fetching joke");
            }
        } else {
            jokeTextView.setText("No joke available");
        }
    }
}
