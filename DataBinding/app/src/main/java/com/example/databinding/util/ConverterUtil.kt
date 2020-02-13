package com.example.databinding.util

import android.view.View
import androidx.databinding.BindingConversion

/**
 * In order to show a View only when it has more than 0 likes, we pass this expression to its
 * visibilty property:
 *
 * `android:visibility="@{ConverterUtil.isZero(viewmodel.likes)}"`
 *
 * This converts "likes" (an Int) into a Boolean. See [BindingConverters] for the conversion
 * from Boolean to a visibility integer.
 */
object ConverterUtil {
    @JvmStatic fun isZero(number: Int): Boolean {
        return number == 0
    }
}

object BindingConverters{

    @BindingConversion
    @JvmStatic fun booleanToVisibility(isNotVisible: Boolean): Int {
        return if (isNotVisible) View.GONE else View.VISIBLE
    }
}

//Without binding conversion @BindingConversion
//object ConverterUtil {
//    @JvmStatic fun isZero(number: Int): Int {
//        return if(number == 0){
//            View.GONE
//        } else {
//            View.VISIBLE
//        }
//    }
//}
