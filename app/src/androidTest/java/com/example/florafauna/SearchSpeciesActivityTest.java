package com.example.florafauna;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertTrue;

public class SearchSpeciesActivityTest {

    private ActivityScenario<SearchSpeciesActivity> scenario;

    @Before
    public void setUp() {
        // Start the activity before each test
        scenario = ActivityScenario.launch(SearchSpeciesActivity.class);
    }

    @Test
    public void testDisplaySpeciesInformation() {
        // Check if the initial species information is displayed correctly
        Espresso.onView(withId(R.id.speciesNameTextView))
                .check(matches(withText("Tiger")));
        Espresso.onView(withId(R.id.habitatTextView))
                .check(matches(withText("Habitat: Dense forests")));
        Espresso.onView(withId(R.id.behaviorTextView))
                .check(matches(withText("Behavior: Solitary and territorial")));
        Espresso.onView(withId(R.id.conservationTextView))
                .check(matches(withText("Conservation Status: Endangered")));
    }

    @Test
    public void testSubmitButton() {
        // Enter correct answer and submit
        Espresso.onView(withId(R.id.userAnswerEditText))
                .perform(ViewActions.typeText("tiger"))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.submitButton)).perform(ViewActions.click());

        // Check if the result text is displayed correctly
        Espresso.onView(withId(R.id.resultTextView))
                .check(matches(withText("Correct! Well done.")));
    }

    @Test
    public void testNextButton() {
        // Click on next button
        Espresso.onView(withId(R.id.nextButton)).perform(ViewActions.click());

        // Check if the species information has changed
        Espresso.onView(withId(R.id.speciesNameTextView))
                .check(matches(withText("Polar Bear")));
    }

    @Test
    public void testBackButton() {
        // Click on back button
        Espresso.onView(withId(R.id.backButton)).perform(ViewActions.click());

        // Check if the activity is finished
        scenario.onActivity(activity -> {
            assertTrue(activity.isFinishing());
        });
    }
}

