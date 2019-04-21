package com.syabon.tagpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.*

class SplitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = intent.getStringExtra("edittext")
        Log.d("MYTAG", "aiueo")
        SplitActivityUI("aiueo").setContentView(this)
    }
}
