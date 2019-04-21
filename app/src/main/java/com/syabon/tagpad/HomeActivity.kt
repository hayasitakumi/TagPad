package com.syabon.tagpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.setContentView

class HomeActivity : AppCompatActivity() {
    val task_list = ArrayList<String>() //list consisting of tasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            val arrayList = savedInstanceState.get("MemoList")
            task_list.addAll(arrayList as List<String>)
        }
        var adapter = MemoAdapter(task_list)  //define adapter
        var ui = HomeActivityUI(adapter)            //define Anko UI Layout to be used
        ui.setContentView(this)             //Set Anko UI to this Activity
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putStringArrayList("MemoList", task_list)
        super.onSaveInstanceState(outState)

    }
}
