package com.example.florafauna;
import static org.junit.Assert.*;
import org.junit.Test;

public class IdentifySpeciesWhiteBoxTest {

    @Test
    public void testDisplaySpeciesInformation() {
        IdentifySpecies identifySpecies = new IdentifySpecies();
        identifySpecies.setCurrentSpeciesIndex(0); // Set the current species index to 0 (Rose)

        // Call the method under test
        identifySpecies.displaySpeciesInformation(0);

        // Check if each statement is executed
        assertNotNull(identifySpecies.speciesImageView);
        assertNotNull(identifySpecies.habitatTextView);
        assertNotNull(identifySpecies.behaviorTextView);
        assertNotNull(identifySpecies.conservationTextView);
        assertNotNull(identifySpecies.userAnswerEditText);
        assertNotNull(identifySpecies.submitButton);
        assertNotNull(identifySpecies.nextButton);
        assertNotNull(identifySpecies.backButton);
        assertNotNull(identifySpecies.resultTextView);

        // Check if each branch is covered
        assertEquals("Rose", identifySpecies.speciesNameTextView.getText().toString());
        assertEquals("Habitat: Garden", identifySpecies.habitatTextView.getText().toString());
        assertEquals("Behavior: Deciduous", identifySpecies.behaviorTextView.getText().toString());
        assertEquals("Conservation Status: Least Concern", identifySpecies.conservationTextView.getText().toString());
        assertEquals("", identifySpecies.userAnswerEditText.getText().toString());
    }
}

