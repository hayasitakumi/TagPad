package com.syabon.tagpad

import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.verticalLayout

class SplitActivityUI(text: String) : AnkoComponent<SplitActivity> {
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

    override fun createView(ui: AnkoContext<SplitActivity>): View = with(ui) {

        verticalLayout {
            val but = button(text) {}
        }
    }
}