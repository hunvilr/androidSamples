package com.example.practice3.view

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3.adapter.CalendarAdapter
import com.example.practice3.databinding.FragmentCalendarVerticalBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CalendarVerticalFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CalendarVerticalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarVerticalFragment : Fragment() {
    private val NUMBER_OF_COLUMNS: Int = 7
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    val adapter by lazy { CalendarAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCalendarVerticalBinding.inflate(inflater)
        binding.recyclerView?.let {
            // [] [] [] [] [] [] []  NUMBER_OF_COLUMNS (span count) = 7 and orientation vertical
            // Span count indicates how many columns or rows you have divided, for vertical columns
            // For the 0th item how many spans you need, we need the entire match parent, so set it same as NUMBER_OF_COLUMNS span count
            //        override fun getSpanSize(position: Int): Int {
            //            var spanSize = 0
            //            when(position) {
            //                0 -> spanSize = 7
            //                else -> spanSize = 1
            //            }
            //            return spanSize
            //        }
            val gridLayoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS, RecyclerView.VERTICAL, false)
            gridLayoutManager.spanSizeLookup = adapter.spanSizeLookup
            it.layoutManager = gridLayoutManager
            it.adapter = adapter
        }
        return binding.root
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarVerticalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarVerticalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
