package com.syabon.tagpad

import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.verticalLayout

class TagsActivityUI(text: String) : AnkoComponent<TagsActivity> {
    val tags = arrayOf(
        "hoge",
        "fuga",
        "bar",
        "foo",
        "もげ",
        "daadae",
        "aadfefaea",
        "１２３４５６７８９０１２３４５６７８９０",
        "ちょっと長い",
        "１"
    )
    val text = text

    override fun createView(ui: AnkoContext<TagsActivity>): View = with(ui) {

        verticalLayout {
            val but = button(text) {}
        }
    }
}