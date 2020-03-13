package com.example.robinhoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.text.TextWatcher
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.robinhoodapp.databinding.ActivityMainBinding
import java.util.*
import java.util.regex.Pattern

/**
public abstract class View {
    public abstract int getId();
    public abstract int getChildCount();
    public abstract View getChildAt(int index);

    public View findViewById(int id) {
        if(this.getId() == id) {
            return this;
        }
        LinkedList<View> root = new LinkedList<View>();
        root.add(this);

        while (!root.isEmpty()) {
            View node = root.pollLast();

            for(int i = 0; i < node.getChildCount(); i++) {
                View view = node.getChildAt(i);
                if(view.getId() == id) {
                    retun view;
                }
                root.addfirst(view);
            }
        }
        return null;
    }
}
View parent = new View();
parent.getId();                     // returns 100
parent.getChildCount();             // returns 1
View child = parent.getChildAt(0);
child.getId();                      // returns 200
child.getChildCount();              // returns 0

parent.findViewById(100);           // returns parent
parent.findViewById(200);           // returns child
parent.findViewById(300);           // returns null
**/
/**
 *
 *
 * Create an Android application that consists of two screens.

First screen, show an input field and a button. The user can type in a URL in the input field, and upon clicking the button,
the app goes to the second screen.

Second screen, two panes (top and bottom).
The top pane displays the raw static HTML from loading the user specified URL,
and the bottom pane displays the webpage rendered by the HTML.

Can use https://example.org as the page source is pretty straightforward.
 */
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val contentView =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        contentView.buttonId.setOnClickListener {
            val text = contentView.editTextId.text
            if(text == null || !text.startsWith("https://")) {
                // show alert dialog
            } else {
                val intent = Intent(this, NextActivity::class.java)
                intent.putExtra("URL", text.toString())

                Log.d("MainActivity", "$text")
                //bundle.putString("URL", text.toString())
                startActivity(intent)
            }
        }
    }


}


