package com.example.connectorfour.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.connectorfour.databinding.MainFragmentBinding
import com.example.connectorfour.ui.adapter.ConnectorFourAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    val adapter by lazy {
        ConnectorFourAdapter(viewModel, viewModel.items)
    }

    private fun manageState(it: Int) {
        adapter.canInsert(it)
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
            it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))

            //Since we have 2 itemdecoration below getItemOffsets() is called twice,
            // once with top = 10 and second time with right = 10, based on the position,
            // the outRect is set
//            //skip first 7 which is the first row, add 10px space to every row there after vertically
//            it.addItemDecoration(SpaceItemDecoration.create(top = 10, skipTop = 7))
//            //Dont skip any, add 10px space from first item horizontally to the right
//            it.addItemDecoration(SpaceItemDecoration.create(left=5, right = 5))
            it.adapter = adapter
        }
        viewModel.positionToUpdate.observe(this, Observer{ manageState(it) })
        return binding.root
    }
}
