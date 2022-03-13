package com.example.kotlin1homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.kotlin1homework3.databinding.ActivitySecondBinding
class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getImages()
    }

    private fun getImages() {
        val list = intent.getStringArrayListExtra(MainActivity.KEY)
        binding.recycler.adapter = list?.let { imagesList ->
            Adapter(imagesList) }

        binding.arrowBackIv.setOnClickListener {
            finish()
        }
    }
}
