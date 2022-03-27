package com.sadataljony.app.android.pdfview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.pdfview.databinding.ActivityPdfViewBinding

class PdfViewFromAssetsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdfViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        showPdfFromAssets("MindOrks_Android_Online_Professional_Course-Syllabus.pdf")
    }

    private fun showPdfFromAssets(pdfName: String) {
        binding.pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .onPageError { page, _ ->
                Toast.makeText(
                    this@PdfViewFromAssetsActivity,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()
    }

}
