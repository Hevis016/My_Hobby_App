package com.selara.myhobbyapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

import com.selara.myhobbyapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var photoAdapter: PhotoAdapter
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable {
        override fun run() {
            val currentItem = binding.viewPager.currentItem
            val nextItem = (currentItem + 1) % photoAdapter.itemCount
            binding.viewPager.setCurrentItem(nextItem, true)
            handler.postDelayed(this, 4000) // Перемикає зображення кожні 4 секунди
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val lottieAnimation = findViewById<LottieAnimationView>(R.id.lottieAnimation)
        lottieAnimation.setAnimation("wave.json")
        lottieAnimation.repeatCount = LottieDrawable.INFINITE
        lottieAnimation.playAnimation()


        binding.progButton.setOnClickListener {
            val intent = Intent(this, ProgsPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.animeButton.setOnClickListener {
            val intent = Intent(this, AnimePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.vollyButton.setOnClickListener {
            val intent = Intent(this, VollyPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.ageButton.setOnClickListener {
            val intent = Intent(this, DidPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
         val photos = listOf(
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
             R.drawable.photo4,
             R.drawable.photo5,
            // Додайте інші ресурси фото
        )

        // Створення і налаштування адаптера
        photoAdapter = PhotoAdapter(photos)
        binding.viewPager.adapter = photoAdapter

        // Налаштування перегляду фото
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Запуск автоматичної прокрутки
        handler.postDelayed(runnable, 4000) // Запускаємо через 4 секунди
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable) // Зупиняємо автоматичну прокрутку при знищенні активності
    }
}

