package com.syabon.tagpad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.atilika.kuromoji.TokenizerBase
import com.atilika.kuromoji.ipadic.Tokenizer

class TagButtons : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag_buttons)

        var tags = hashSetOf<String>()

        val tokenizer = Tokenizer.Builder().mode(TokenizerBase.Mode.NORMAL).build()
        val tokens = tokenizer.tokenize("吾輩はアキラである。名前はまだない。")

        var surfaces = ArrayList<String>()

        tokens.forEach {

            if (it.partOfSpeechLevel1 == "名詞") {
                Log.d("Kuromoji", it.surface + "\t" + it.partOfSpeechLevel1)
                surfaces.add(it.surface)
            }
        }


        val listView = findViewById<ListView>(R.id.buttonList)

        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            surfaces
        )

        listView.adapter = arrayAdapter as ListAdapter?

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val tag = parent.getItemAtPosition(position)

            tags.add(tag.toString())

            var text = String()
            tags.forEach {
                text = text + it
            }
            Log.d("tags", text)

        }
    }
}
