package com.example.feed.reader.view

import android.content.Context
import android.content.Intent
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.feed.reader.view.robot.MainRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var context: Context

    @Rule
    @JvmField
    var testRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setup() {
        testRule.launchActivity(Intent())
        context = testRule.activity.applicationContext
    }

    @Test
    fun valida_carregamento_feed_rss() {
        MainRobot()
            .checkImageDisplayed()
            .checkTitleDisplayed()
            .checkAuthorDisplayed()
            .checkDatePublishedDisplayed()
            .checkViewMoreDisplayed()
    }
}
