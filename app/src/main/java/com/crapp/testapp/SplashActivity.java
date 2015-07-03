package com.crapp.testapp;

// Import Statements
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashActivity extends Activity {

    // Splash screen timer in milliseconds
    private static final int SPLASH_TIME_OUT = 1000;

    private TextView text;

    // Method called when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        text = (TextView) findViewById(R.id.splash);
        text.setText("Splash Screen");

        // Delaying the code
        new Handler().postDelayed(new Runnable() {
            // Showing splash screen with a timer. This will be useful when you want to show case your app logo / company
            @Override
            public void run() {
                // Accessing the SharedPreferences having user data named as USER and
                // making its access restricted to the application only
                SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
                // Accessing the value of alreadyLoggedIn
                // If the SharedPreferences is not found the set to false
                Boolean alreadyLoggedIn = sharedPreferences.getBoolean("REGISTERED",false);
                // Checking if the user has already logged in
                if (alreadyLoggedIn){
                    // If the User has already logged in then Dashboard Screen is shown
                    Intent i = new Intent(SplashActivity.this,DashboardActivity.class);
                    startActivity(i);
                    // Deleting the Splash Screen from Activity History
                    finish();
                } else {
                    // If the User hasn't logged in yet then Login with Google Screen is shown
                    Intent i = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(i);
                    // Deleting the Splash Screen from Activity History
                    finish();
                }

            }
        },SPLASH_TIME_OUT);


    }


}
