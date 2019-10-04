package com.example.feed.reader.view.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.feed.reader.R
import org.hamcrest.core.AllOf

class MainRobot {

    fun checkImageDisplayed() = apply {
        onView(withId(R.id.imageItemImg))
            .check(matches(isDisplayed()))
    }

    fun checkTitleDisplayed() = apply {
        onView(withId(R.id.textViewItemTitle))
            .check(matches(isDisplayed()))
    }

    fun checkAuthorDisplayed() = apply {
        onView(withId(R.id.textViewItemAuthor))
            .check(matches(isDisplayed()))
    }

    fun checkDatePublishedDisplayed() = apply {
        onView(withId(R.id.textViewItemDatePublished))
            .check(matches(isDisplayed()))
    }

    fun checkViewMoreDisplayed() = apply {
        onView(withId(R.id.buttonItemViewMore))
            .check(matches(isDisplayed()))
    }
}