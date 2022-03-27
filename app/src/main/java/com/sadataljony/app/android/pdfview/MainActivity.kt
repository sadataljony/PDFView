package com.sadataljony.app.android.pdfview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.pdfview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, PdfViewInWebViewActivity::class.java))
        }
        binding.btnAssets.setOnClickListener {
            startActivity(Intent(this, PdfViewFromAssetsActivity::class.java))
        }
        binding.btnStorage.setOnClickListener {
            startActivity(Intent(this, PdfViewFromStorageActivity::class.java))
        }
        binding.btnInternet.setOnClickListener {
            startActivity(Intent(this, PdfViewFromInternetActivity::class.java))
        }
    }
}
