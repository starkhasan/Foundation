package com.ali.sampleandroid.view

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.ali.sampleandroid.BuildConfig
import com.ali.sampleandroid.databinding.ActivityImageCaptureBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ImageCaptureActivity : AppCompatActivity() {

    lateinit var currentPhotoPath: String
    private lateinit var activityImageCaptureBinding: ActivityImageCaptureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityImageCaptureBinding = ActivityImageCaptureBinding.inflate(LayoutInflater.from(this))
        setContentView(activityImageCaptureBinding.root)
        supportActionBar!!.title = "Image Capture"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        activityImageCaptureBinding.btnCapture.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Choose Image")
                .setMessage("Choose Source of the Image")
                .setNegativeButton("Camera"){_,_ ->
                    val photoFile: File? = try {
                        createImageFile()
                    } catch (ex: IOException) {
                        null
                    }
                    photoFile?.also {
                        val photoURI: Uri = FileProvider.getUriForFile(
                            this,
                            "${BuildConfig.APPLICATION_ID}.fileprovider",
                            it
                        )
                        imageFromCamera.launch(photoURI)
                    }
                }
                .setPositiveButton("Gallery"){ dialog,_ -> imageFromGallery.launch("image/*")}
                .show()
        }
    }

    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            currentPhotoPath = absolutePath
        }
    }


    private val imageFromCamera = registerForActivityResult(ImageContracts()) { bitmap ->
        activityImageCaptureBinding.ivCaptureImage.setImageBitmap(bitmap)
    }

    private val imageFromGallery = registerForActivityResult(ActivityResultContracts.GetContent()) { imageUri ->
        print(imageUri)
        activityImageCaptureBinding.ivCaptureImage.setImageURI(imageUri)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    inner class ImageContracts : ActivityResultContract<Uri, Bitmap?>(){
        override fun createIntent(context: Context, input: Uri?): Intent {
            return Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, input)
        }
        override fun parseResult(resultCode: Int, intent: Intent?): Bitmap? {
            if (intent == null || resultCode != Activity.RESULT_OK) {
                return BitmapFactory.decodeFile(currentPhotoPath)
            }else
                return intent.getParcelableExtra("data")
        }
    }

}