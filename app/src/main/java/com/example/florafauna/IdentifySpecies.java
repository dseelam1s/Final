package com.example.florafauna;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.florafauna.PlantSpeciesInfo;
import com.example.florafauna.R;

public class IdentifySpecies extends AppCompatActivity {
    ImageView speciesImageView;
    TextView speciesNameTextView;
    TextView habitatTextView;
    TextView behaviorTextView;
    TextView conservationTextView;
    TextView resultTextView;
    EditText userAnswerEditText;
    Button submitButton;
    Button nextButton;
    Button backButton;
    private PlantSpeciesInfo plantSpeciesInfo;

    private String[] speciesNames = {"Rose", "Sunflower", "Oak", "Cactus"};
    private String[] habitatInfo = {"Garden", "Fields", "Forests", "Deserts"};
    private String[] behaviorInfo = {"Deciduous", "Annual plant", "Deciduous", "Perennial"};
    private String[] conservationInfo = {"Least Concern", "Not Evaluated", "Least Concern", "Least Concern"};
    public int currentSpeciesIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_species);

        speciesImageView = findViewById(R.id.speciesImageView);
        habitatTextView = findViewById(R.id.habitatTextView);
        behaviorTextView = findViewById(R.id.behaviorTextView);
        conservationTextView = findViewById(R.id.conservationTextView);
        userAnswerEditText = findViewById(R.id.userAnswerEditText);
        submitButton = findViewById(R.id.submitButton);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

        resultTextView = findViewById(R.id.resultTextView);
        try {
            speciesNameTextView = findViewById(R.id.speciesNameTextView); // Initialize speciesNameTextView
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception, such as showing a toast message or logging an error
        }
        plantSpeciesInfo = new PlantSpeciesInfo();

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
                currentSpeciesIndex = (currentSpeciesIndex + 1) % speciesNames.length;
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
        String imageName = speciesNames[index].toLowerCase();
        int imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());
        speciesImageView.setImageResource(imageResource);


        speciesNameTextView.setText(speciesNames[index]);
        habitatTextView.setText("Habitat: " + habitatInfo[index]);
        behaviorTextView.setText("Behavior: " + behaviorInfo[index]);
        conservationTextView.setText("Conservation Status: " + conservationInfo[index]);
        userAnswerEditText.getText().clear();
    }

    private String getCorrectAnswer() {
        return speciesNames[currentSpeciesIndex].toLowerCase();
    }

    public void setCurrentSpeciesIndex(int i) {
    }
}
