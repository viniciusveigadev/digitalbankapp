package com.digital.bank

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

const val PREFERENCES = "com.digital.bank.PREFERENCE_FILE_KEY"

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            isIntroSliderFinished()
        }, 1000)
    }

    private fun isIntroSliderFinished() {
        val sharedPref = this.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val defaultValue = false
        val isButtonDonePressed = sharedPref.getBoolean(
            getString(R.string.preferencekey_onDonePressed_intro),
            defaultValue
        )

        if (isButtonDonePressed) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, Introduction::class.java))
            finish()
        }
    }
}