package com.example.storageapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val filename = "myfile_storageapp"
        val fileContents = "Hello world!\n I am second line"

//        val file = File(filesDir, filename)
//        val fileOutputStream = FileOutputStream(file)
//        fileOutputStream.use {
//            it.write(fileContents.toByteArray())
//        }

        openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())
        }

        openFileInput(filename).bufferedReader().useLines { lines ->
            lines.fold("") { some, text ->
                "$some\n$text"
            }
        }

        val absolutePath = Environment.getExternalStorageDirectory().absolutePath
        val file = File(absolutePath)
        file.listFiles()

    }
}
