package com.traversal.aboutme.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.traversal.aboutme.databinding.ActivityFileBinding
import android.os.StatFs
import java.io.File
import java.lang.Exception


class FileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnStorage.setOnClickListener {
            val deviceStorage = getExternalStorageAvailableData(this)
        }

    }

    private fun getExternalStorageAvailableData(context: Context): ArrayList<HashMap<String, Any>> {
        val appsDir: Array<File> = context.getExternalFilesDirs(null)
        val extRootPaths: ArrayList<HashMap<String, Any>> = ArrayList()
        for (file in appsDir) {
            val path: String = file.absolutePath
            val statFs = StatFs(path)
            val availableBytes = statFs.availableBlocksLong * statFs.blockSizeLong
            val totalBytes = statFs.blockCountLong * statFs.blockSizeLong
            val storageData: HashMap<String, Any> = HashMap()
            try {
                val rootPath = file.parentFile.parentFile.parentFile.parentFile.absolutePath
                storageData["rootPath"] = rootPath
            } catch (e: Exception) {
            }
            storageData["path"] = path
            storageData["availableBytes"] = availableBytes
            storageData["totalBytes"] = totalBytes
            extRootPaths.add(storageData)
        }
        return extRootPaths
    }
}