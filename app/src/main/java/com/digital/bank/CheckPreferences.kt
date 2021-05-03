package com.digital.bank

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val PREFERENCES = "com.digital.bank.PREFERENCE_FILE_KEY"

class CheckPreferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_preferences)
        isIntroSliderFinished()
    }

    private fun isIntroSliderFinished() {
        val sharedPref = this.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val defaultValue = false
        val isButtonDonePressed = sharedPref.getBoolean(getString(R.string.preferencekey_onDonePressed_intro), defaultValue)

        if (isButtonDonePressed) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, Introduction::class.java))
            finish()
        }
    }
}