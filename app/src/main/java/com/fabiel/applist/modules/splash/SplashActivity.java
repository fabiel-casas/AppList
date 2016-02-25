package com.fabiel.applist.modules.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.fabiel.applist.R;
import com.fabiel.applist.modules.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

  // Set the duration of the splash screen
  private static final long SPLASH_SCREEN_DELAY = 3000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_splash);

    TimerTask task = new TimerTask() {
      @Override
      public void run() {

        // Start the next activity
        Intent mainIntent = new Intent().setClass(
            SplashActivity.this, MainActivity.class);
        startActivity(mainIntent);

        // Close the activity so the user won't able to go back this
        // activity pressing Back button
        finish();
      }
    };

    // Simulate a long loading process on application startup.
    Timer timer = new Timer();
    timer.schedule(task, SPLASH_SCREEN_DELAY);
  }
}
