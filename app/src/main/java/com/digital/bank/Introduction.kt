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
                title = "Bem vindo(a) ao Digital Bank!",
                description = "Seu banco digital gratuito. 1º banco exclusivo para crianças e adolescentes",
                backgroundColor = Color.GREEN,
                imageDrawable = R.drawable.welcome
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = "Exclusivo",
                description = "Disponível no celular ou no computador",
                backgroundColor = Color.GRAY,
                imageDrawable = R.drawable.yes
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = "Vamos começar",
                description = "Todas as funções de um banco na palma da sua mão. Aproveite!",
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
        editor.putBoolean("finishButton", true)
        editor.apply()
        editor.commit()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}