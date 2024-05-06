package com.example.florafauna;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void grantPermission() {
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand(
                "pm grant " + InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageName() +
                        " android.permission.INJECT_EVENTS");
    }
    @Test
    public void testValidCredentials() {
        // Type valid credentials and click login button
        Espresso.onView(ViewMatchers.withId(R.id.usernameEditText)).perform(ViewActions.typeText("admin"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText)).perform(ViewActions.typeText("admin123"));
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(closeSoftKeyboard());

        // You may add assertions here to verify the behavior after successful login
    }

    @Test
    public void testInvalidCredentials() {
        // Type invalid credentials and click login button
        Espresso.onView(ViewMatchers.withId(R.id.usernameEditText)).perform(ViewActions.typeText("user"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText)).perform(ViewActions.typeText("password"));
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(closeSoftKeyboard());

        // Check if the error message is displayed
        Espresso.onView(withText("Invalid username or password")).check(matches(isDisplayed()));
    }

}
