package com.example.florafauna;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SearchSpeciesActivityWhiteBoxTest {

    @Rule
    public ActivityScenarioRule<SearchSpeciesActivity> activityScenarioRule =
            new ActivityScenarioRule<>(SearchSpeciesActivity.class);

    @Test
    public void testSubmitButton_IncorrectAnswer() {
        // Enter an incorrect answer in the EditText field
        onView(withId(R.id.userAnswerEditText)).perform(typeText("lion"));

        // Click the submit button
        onView(withId(R.id.submitButton)).perform(click());

        // Check if the result text is displayed correctly
        onView(withId(R.id.resultTextView)).check(matches(withText("Incorrect. Please try again.")));
    }

    // Add more test cases as needed...
}
