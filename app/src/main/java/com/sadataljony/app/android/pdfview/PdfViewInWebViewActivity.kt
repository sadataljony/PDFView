package com.sadataljony.app.android.pdfview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.pdfview.databinding.ActivityWebViewBinding

class PdfViewInWebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadPdfInWebView()
    }

    private fun loadPdfInWebView() {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.setSupportZoom(true)
        binding.webView.settings.javaScriptEnabled = true
        val url =
            "https://mindorks.s3.ap-south-1.amazonaws.com/courses/MindOrks_Android_Online_Professional_Course-Syllabus.pdf"
        binding.webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
    }
}
