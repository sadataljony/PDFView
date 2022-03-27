package com.sadataljony.app.android.pdfview

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.pdfview.databinding.ActivityPdfViewBinding
import kotlinx.android.synthetic.main.activity_pdf_view.*

class PdfViewFromStorageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdfViewBinding

    companion object {
        private const val PDF_SELECTION_CODE = 99
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        selectPdfFromStorage()
    }

    private fun selectPdfFromStorage() {
        Toast.makeText(this, "selectPDF", Toast.LENGTH_LONG).show()
        val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
        browseStorage.type = "application/pdf"
        browseStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(
            Intent.createChooser(browseStorage, "Select PDF"), PDF_SELECTION_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PDF_SELECTION_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedPdfFromStorage = data.data
            showPdfFromUri(selectedPdfFromStorage)
        }
    }

    private fun showPdfFromUri(uri: Uri?) {
        binding.pdfView.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

}
