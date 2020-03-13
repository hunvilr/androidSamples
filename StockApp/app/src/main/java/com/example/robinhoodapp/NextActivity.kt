package com.example.robinhoodapp

import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.robinhoodapp.databinding.NextPageBinding
import java.io.*
import java.net.MalformedURLException
import java.net.URL


class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contentView =
            DataBindingUtil.setContentView<NextPageBinding>(this, R.layout.next_page)

        val text = intent.extras?.getString("URL")
        Log.d("NextActivity","$text")

        contentView.textId.text = getContents(text.toString())


        contentView.webviewId.loadUrl(text)
    }

    fun getContents(url: String): String {
        var contents = ""

        try {
            val conn = URL(url).openConnection()

            val `in` = conn.getInputStream()
            contents = convertStreamToString(`in`)
        } catch (e: MalformedURLException) {
            Log.v("NextActivity","MALFORMED URL EXCEPTION")
        } catch (e: IOException) {
            Log.e("NextActivity", e.message, e)
        }

        return contents
    }


    @Throws(UnsupportedEncodingException::class)
    fun convertStreamToString(inputStream: InputStream ) : String {

        val reader=  BufferedReader(
                InputStreamReader(inputStream, "UTF-8")
        )
        val sb: StringBuilder = StringBuilder()
        try {
            reader?.forEachLine {
                sb.append(it + "n");
            }
        } catch (e: IOException) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (e: IOException) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
