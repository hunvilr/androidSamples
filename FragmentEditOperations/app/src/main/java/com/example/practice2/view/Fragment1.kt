package com.example.practice2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.practice2.R

class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = LayoutInflater.from(context).inflate(R.layout.fragment1, container, false)
        val findViewById = binding.findViewById<TextView>(R.id.fragment_1)
        findViewById.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_id, Fragment2())
                    .addToBackStack(null)
                    .commit()
            }
        }
        return binding.rootView
    }
}