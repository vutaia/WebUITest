package com.hipmunk.tai.webui;

import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.web.assertion.WebViewAssertions.webContent;
import static android.support.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static android.support.test.espresso.web.matcher.DomMatchers.hasElementWithId;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webKeys;

/**
 * Created by tai on 1/23/17.
 */

@RunWith(AndroidJUnit4.class)
public class WebViewTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class, false, true) {
        @Override
        protected void afterActivityLaunched() {
            onWebView().forceJavascriptEnabled();
        }
    };

    @Test
    public void googleSearchViewTest() {
        onWebView()
                .withElement(findElement(Locator.ID, "lst-ib"))
                .perform(webKeys("abc"))
                .withElement(findElement(Locator.ID, "tsbb"))
                .perform(webClick());

        onWebView()
                .check(webContent(hasElementWithId("lst-ib")))
                .check(webContent(hasElementWithId("tsbb")));

        /*
        onWebView()
                .withElement(findElement(Locator.ID, "hplogo"))
                .perform(webClick());
        System.out.println("clicked");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
        */
    }


}
