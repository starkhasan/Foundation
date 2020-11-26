package com.ali.mlkit

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.health.PackageHealthStats
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    var bitmap_input:Bitmap?=null
    private var output: File? = null
    var currentPhotoPath: String? = null
    private val REQUEST_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var input_text = ""

        bitmap_input = BitmapFactory.decodeResource(
            applicationContext.resources,
            R.drawable.input_img
        )
        ivImageInput.setImageBitmap(bitmap_input)

        btnStart.setOnClickListener {
            val drawable = ivImageInput.getDrawable()
            val bitmap = drawable.toBitmap()
            val image = InputImage.fromBitmap(bitmap, 0) //Create Input Image From Bitmap object
            val recognizer = TextRecognition.getClient()
            val result = recognizer.process(image)
                    .addOnSuccessListener { visionText ->
                        val resultText = visionText.text
                        input_text = visionText.text
                        for (block in visionText.textBlocks) {
                            val blockText = block.text
                            val blockCornerPoints = block.cornerPoints
                            val blockFrame = block.boundingBox
                            for (line in block.lines) {
                                val lineText = line.text
                                val lineCornerPoints = line.cornerPoints
                                val lineFrame = line.boundingBox
                                for (element in line.elements) {
                                    val elementText = element.text
                                    val elementCornerPoints = element.cornerPoints
                                    val elementFrame = element.boundingBox
                                }
                            }
                        }
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
            if(input_text!="")
                tvTextInput.text = input_text
            else
                Toast.makeText(applicationContext, "Text Not Found Try again!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_icon, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.menuImage) {
            if((ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED))
                getIMage()
            else
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE),REQUEST_PERMISSION_CODE)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_PERMISSION_CODE){
            if(grantResults.size > 0){
                getIMage()
            }else{
                Toast.makeText(applicationContext,"Please Grant Permission",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getIMage(){
        AlertDialog.Builder(this, R.style.AlertDialog)
            .setTitle("Get Image")
            .setPositiveButton("Camera"){ dialog: DialogInterface, int: Int ->
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 1)
                dialog.dismiss()
            }
            .setNegativeButton("Gallery"){ dialog: DialogInterface, int: Int ->
                val intent = Intent()
                intent.setType("image/*")
                intent.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(intent, 2)
                dialog.dismiss()
            }
            .show()
    }

    @Throws(IOException::class)
    private fun createImageFile(): File? {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",  /* suffix */
            storageDir /* directory */
        )

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.absolutePath
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode!== Activity.RESULT_OK){
            return
        }
        if(requestCode === 1){
            val bitmap = data!!.extras!!.get("data") as Bitmap
            //bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            bitmap_input = bitmap
            ivImageInput.setImageBitmap(bitmap)
        }
        if(requestCode === 2){
            val imageUri = data!!.data
            ivImageInput.setImageURI(imageUri)
        }
    }
}