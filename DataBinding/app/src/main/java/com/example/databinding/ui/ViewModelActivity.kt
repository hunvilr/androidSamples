package com.example.databinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.data.ProfileLiveDataViewModel
import com.example.databinding.data.ProfileObservableViewModel
import com.example.databinding.databinding.ViewModelProfileBinding

class ViewModelActivity : AppCompatActivity() {

//    private val profileLiveDataViewModel: ProfileLiveDataViewModel by lazy {
//        ViewModelProvider(this@ViewModelActivity).get(ProfileLiveDataViewModel::class.java)
//    }

    private val profileObservableDataViewModel: ProfileObservableViewModel by lazy {
        ViewModelProvider(this@ViewModelActivity).get(ProfileObservableViewModel::class.java)
    }

//    private val quizViewModel: QuizViewModel by lazy {
//        ViewModelProvider(this@QuizActivity).get(QuizViewModel::class.java)
//    }
//    However, this will not suffice for more complex ViewModels that depend upon other resources.
//    For these situations, we will need to create our own Factory class. For this example, the factory would like follows.
//
//    // QuizViewModelFactory.kt
//    class QuizViewModelFactory : ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return modelClass.getConstructor().newInstance()
//        }
//    }
//    Now inside of QuizActivity, we get an instance of QuizViewModel by first creating the factory.
//
//    // QuizActivity.kt
//    private val quizViewModel: QuizViewModel by lazy {
//        val factory = QuizViewModelFactory()
//        ViewModelProvider(this@QuizActivity, factory).get(QuizViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtain binding
        val binding: ViewModelProfileBinding =
            DataBindingUtil.setContentView(this, R.layout.view_model_profile)

        // Bind layout with ViewModel
        //binding.viewmodel = profileLiveDataViewModel
        binding.viewmodel = profileObservableDataViewModel

        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this
    }
}