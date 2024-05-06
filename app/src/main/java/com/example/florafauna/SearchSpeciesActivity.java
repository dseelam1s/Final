package com.example.florafauna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchSpeciesActivity extends AppCompatActivity {
    private ImageView wildlifeImageView;
    TextView wildlifeNameTextView;
    TextView habitatTextView;
    TextView behaviorTextView;
    TextView conservationTextView;
    TextView resultTextView;
    EditText userAnswerEditText;
    Button submitButton;
    private Button nextButton;
    private Button backButton;
    private WildlifeInfo wildlifeInfo;

    private String[] wildlifeNames = {"Tiger", "Polar Bear", "Elephant", "Penguin"};
    private String[] habitatInfo = {"Dense forests", "islands", "Savannahs", "subantarctic islands"};
    private String[] behaviorInfo = {"Solitary and territorial", "excellent swimmers and hunters", "herbivores", "colonial breeders"};
    private String[] conservationInfo = {"Endangered", "Vulnerable", "Vulnerable to Endangered", "Least Concern to Vulnerable"};
    int currentSpeciesIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_species);
        wildlifeImageView = findViewById(R.id.speciesImageView);
        habitatTextView = findViewById(R.id.habitatTextView);
        behaviorTextView = findViewById(R.id.behaviorTextView);
        conservationTextView = findViewById(R.id.conservationTextView);
        userAnswerEditText = findViewById(R.id.userAnswerEditText);
        submitButton = findViewById(R.id.submitButton);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

        resultTextView = findViewById(R.id.resultTextView);
        try {
            wildlifeNameTextView = findViewById(R.id.speciesNameTextView); // Initialize speciesNameTextView
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception, such as showing a toast message or logging an error
        }
        wildlifeInfo = new WildlifeInfo();

        displaySpeciesInformation(currentSpeciesIndex);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = userAnswerEditText.getText().toString().trim();
                String correctAnswer = getCorrectAnswer();
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    resultTextView.setText("Correct! Well done.");
                } else {
                    resultTextView.setText("Incorrect. Please try again.");
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSpeciesIndex = (currentSpeciesIndex + 1) % wildlifeNames.length;
                displaySpeciesInformation(currentSpeciesIndex);
                resultTextView.setText(""); // Clear result text
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

        void displaySpeciesInformation(int index) {
            // Assuming you have images for each species in your drawable folder with names: rose, sunflower, oak, cactus
            String imageName = wildlifeNames[index].toLowerCase();
            int imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());
            wildlifeImageView.setImageResource(imageResource);


            wildlifeNameTextView.setText(wildlifeNames[index]);
            habitatTextView.setText("Habitat: " + habitatInfo[index]);
            behaviorTextView.setText("Behavior: " + behaviorInfo[index]);
            conservationTextView.setText("Conservation Status: " + conservationInfo[index]);
            userAnswerEditText.getText().clear();
        }

        private String getCorrectAnswer() {
            return wildlifeNames[currentSpeciesIndex].toLowerCase();
        }

    }
