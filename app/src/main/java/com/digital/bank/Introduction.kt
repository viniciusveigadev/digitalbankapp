package com.digital.bank

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

class Introduction : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isColorTransitionsEnabled = true
        setTransformer(AppIntroPageTransformerType.Flow)
        isVibrate = true
        vibrateDuration = 150L
        isWizardMode = true

        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.title_intro_1),
                description = getString(R.string.description_intro_1),
                backgroundColor = Color.GREEN,
                imageDrawable = R.drawable.welcome
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.title_intro_2),
                description = getString(R.string.description_intro_2),
                backgroundColor = Color.GRAY,
                imageDrawable = R.drawable.yes
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.title_intro_3),
                description = getString(R.string.description_intro_3),
                backgroundColor = Color.BLUE,
                imageDrawable = R.drawable.launch
            )
        )
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

        val sharedPref = this.getSharedPreferences(PREFERENCES, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(getString(R.string.preferencekey_onDonePressed_intro), true)
        editor.apply()
        editor.commit()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}