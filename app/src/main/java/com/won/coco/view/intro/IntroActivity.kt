package com.won.coco.view.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.won.coco.R
import timber.log.Timber

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen() // splash screen 생성 setContentView() 보다 위에서 호출해야하네. 밑에서 호출하면 앱 죽음
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Timber.d("oncreate")
    }
}