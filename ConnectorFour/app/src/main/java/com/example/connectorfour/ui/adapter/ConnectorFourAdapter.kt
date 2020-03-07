package com.example.connectorfour.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.connectorfour.R
import com.example.connectorfour.databinding.LayoutRowColumnItemBinding
import com.example.connectorfour.ui.main.MainViewModel
import com.example.connectorfour.ui.model.Piece
import com.example.connectorfour.BR
import kotlinx.android.synthetic.main.layout_row_column_item.view.*


/**
 * Provide views to RecyclerView with data from dataSet.
 *
 * Initialize the dataset of the Adapter.
 *
 * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
 */
class ConnectorFourAdapter(private val viewModel: MainViewModel,
                           private val dataSet: Array<Piece>) :
    RecyclerView.Adapter<ConnectorFourAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(val binding : LayoutRowColumnItemBinding, val dataSet: Array<Piece>) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: MainViewModel, position: Int) {
            Log.d(TAG, " ViewHolder bind  $position ")
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.setVariable(BR.piece, dataSet[position])
            binding.executePendingBindings();
        }
    }

    fun canInsert(applyPosition: Int) {
        if(applyPosition != -1) {
            notifyItemChanged(applyPosition);
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : LayoutRowColumnItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.layout_row_column_item, viewGroup, false
            )
        return ViewHolder(binding, dataSet)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        viewHolder.binding.button.setOnClickListener {
//            Log.d(TAG, "onBindViewHolder item position clicked $position")
//            viewModel.navigateToBottom(position)
//        }
        if(position < viewModel.NUMBER_OF_COLUMNS) {
            viewHolder.itemView.button.text = ""
            viewHolder.itemView.button.setOnClickListener {
                Log.d(TAG, "onBindViewHolder item position clicked $position")
                viewModel.navigateToBottom(position)
            }
        } else {
            viewHolder.itemView.button.text = "0"
            viewHolder.itemView.button.isClickable = false
        }
        viewHolder.bind(viewModel, position)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    companion object {
        private val TAG = "CustomAdapter"
    }
}

//class ConnectorFourAdapter(
//    private val numsOfRows : Int,
//    private val numsOfCols : Int,
//    val items : Array<Piece>,
//    val context: Context?
//) : RecyclerView.Adapter<ConnectorFourAdapter.RowColumnViewHolder>() {
//
//// Below is not needed, since we have equal number of cols per row
////    val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
////        override fun getSpanSize(position: Int): Int {
////            return numsOfCols
////        }
////    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectorFourAdapter.RowColumnViewHolder {
//        //return RowColumnViewHolder(parent)
//        //    inner class RowColumnViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
//        //        LayoutInflater.from(parent.context).inflate(R.layout.layout_row_column_item, parent, false)
//        //    )
//
////        val inflater = LayoutInflater.from(parent.context)
////        val view = inflater.inflate(R.layout.layout_row_column_item, parent, false)
//        val view : LayoutRowColumnItemBinding = DataBindingUtil.inflate(
//                LayoutInflater.from(parent.context),
//                R.layout.layout_row_column_item, parent, false
//            )
//        return RowColumnViewHolder(view)
//    }
//
//    class RowColumnViewHolder(binding: LayoutRowColumnItemBinding) : RecyclerView.ViewHolder(binding.root){
//        val button: Button
//
//        init {
//            // Define click listener for the ViewHolder's View.
//            itemView.setOnClickListener {
//                Log.d("RowColumnViewHolder", "Element $adapterPosition clicked.")
//            }
//            button = binding.button
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
////    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
////        holder as RowColumnViewHolder
////        val piece: Piece = items.get(position)
////
////        Log.d("ConnectorFourAdapter", "${piece.x} ${piece.y}")
//////        holder.layout.setOnClickListener {
//////            Toast.makeText(context, piece.x, Toast.LENGTH_LONG).show()
//////        }
////
////        Log.d("RowColumnViewHolder", "Element $position set.")
////
////    }
//
//    override fun onBindViewHolder(holder: RowColumnViewHolder, position: Int) {
//        Log.d("RowColumnViewHolder", "Element $position set.")
//    }
//
//}
//
//
