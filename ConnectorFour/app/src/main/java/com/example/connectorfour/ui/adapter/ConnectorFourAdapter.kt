package com.example.connectorfour.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connectorfour.R
import com.example.connectorfour.ui.model.Piece

class ConnectorFourAdapter(
    private val numsOfRows : Int,
    private val numsOfCols : Int,
    val items : Array<Array<Piece>>,
    //val items : Array<Piece>,
    val context: Context?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

// Below is not needed, since we have equal number of cols per row
//    val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//        override fun getSpanSize(position: Int): Int {
//            return numsOfCols
//        }
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //return RowColumnViewHolder(parent)
        //    inner class RowColumnViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        //        LayoutInflater.from(parent.context).inflate(R.layout.layout_row_column_item, parent, false)
        //    )

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_row_column_item, parent, false)
        return RowColumnViewHolder(view)
    }

    inner class RowColumnViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return numsOfRows * numsOfCols
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as RowColumnViewHolder

    }

}
