package com.example.ktmmoe.themovieapp.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.activities.MainActivity
import com.example.ktmmoe.themovieapp.views.viewholders.MovieViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ktmmoe on 31, July, 2020
 **/
@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnMovie_navigateToMovieDetails() {
        onView (withId(R.id.rvPopularMovies)).perform(RecyclerViewActions.actionOnItemAtPosition<MovieViewHolder>(0, click()))

        onView(withId(R.id.tvStoryLine)).check(matches(isDisplayed()))
    }
}