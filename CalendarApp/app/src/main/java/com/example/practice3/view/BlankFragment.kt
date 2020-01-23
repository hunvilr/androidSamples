package com.example.practice3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practice3.R

class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_blank, container, false)

        binding.findViewById<Button>(R.id.buttonId1).setOnClickListener { findNavController().navigate(
            R.id.next_action1
        ) }

        binding.findViewById<Button>(R.id.buttonId2).setOnClickListener { findNavController().navigate(
            R.id.next_action2
        ) }
        return binding.rootView
    }
}