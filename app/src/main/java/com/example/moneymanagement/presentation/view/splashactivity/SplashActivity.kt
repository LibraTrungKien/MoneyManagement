package com.example.moneymanagement.presentation.view.splashactivity

import android.content.Intent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.bumptech.glide.Glide
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.ActivitySplashBinding
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.example.moneymanagement.presentation.view.homeactivity.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {


    override fun bindView() {

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        Glide.with(this).load(R.drawable.img_title).into(binding.imgLogo)
        Glide.with(this).load(R.drawable.img_start).into(binding.imgLogoSmall)
        CoroutineScope(Dispatchers.IO).launch {
            sleep(3000)
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
        }


    }

}