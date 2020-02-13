package com.example.databinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.example.databinding.R
import com.example.databinding.data.ObservableFieldProfile
import com.example.databinding.databinding.ObservableFieldProfileBinding

class ObservableFieldsActivity : AppCompatActivity() {
    private val observableField = ObservableFieldProfile(
        "Ada", "Lovalace", ObservableInt(0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ObservableFieldProfileBinding = DataBindingUtil.setContentView(this, R.layout.observable_field_profile)
    }
}