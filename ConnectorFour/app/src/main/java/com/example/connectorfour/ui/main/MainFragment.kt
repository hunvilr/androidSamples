package com.example.connectorfour.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connectorfour.R
import com.example.connectorfour.databinding.MainFragmentBinding
import com.example.connectorfour.ui.adapter.ConnectorFourAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    val adapter by lazy {
        ConnectorFourAdapter(viewModel.NUMBER_OF_ROWS, viewModel.NUMBER_OF_COLUMNS, viewModel.items, context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val binding = MainFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.recyclerView.let {
            val gridLayoutManager : GridLayoutManager? = GridLayoutManager(context, viewModel.NUMBER_OF_COLUMNS)
            //gridLayoutManager?.spanSizeLookup = adapter.spanSizeLookup
            it.layoutManager = gridLayoutManager
            it.adapter = adapter
            it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        return binding.root
    }
}
