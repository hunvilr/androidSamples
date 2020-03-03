package com.example.connectorfour.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.connectorfour.R
import com.example.connectorfour.ui.model.Piece


/**
 * Provide views to RecyclerView with data from dataSet.
 *
 * Initialize the dataset of the Adapter.
 *
 * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
 */
class CustomAdapter(private val context: Context?,
    private val dataSet: Array<Piece>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(v: View,  val context: Context?) : RecyclerView.ViewHolder(v) {
        val button: Button

        init {
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener {
                Log.d(TAG, "ViewHolder Element $adapterPosition clicked.")
                Log.d(TAG, " ViewHolder info  set. ")
                navigateToBottom(adapterPosition, it)
            }
            button = v.findViewById(R.id.button)
        }

        private fun navigateToBottom(adapterPosition: Int, view: View) {
            val colIndex = adapterPosition % 7      //between 0 to SPAN_COUNT
            val rowIndex = adapterPosition / 7     // total elements
            Log.d(TAG, "ViewHolder Element $rowIndex $colIndex clicked.")

            context?.let{view.setBackgroundColor(ContextCompat.getColor(context, R.color.green_color))}
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_row_column_item, viewGroup, false)

        return ViewHolder(v, context)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set. ")

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        val piece = dataSet[position]
        val info = piece.x.toString() + " " + piece.y.toString()
        Log.d(TAG, "info $info set. ")
        viewHolder.button.text = piece.x.toString() + " " + piece.y.toString()

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
