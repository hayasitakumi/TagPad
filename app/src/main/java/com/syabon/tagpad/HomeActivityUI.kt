package com.syabon.tagpad

import android.util.Log
import androidx.core.content.ContextCompat
import org.jetbrains.anko.sdk25.coroutines.onClick
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ListView
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.sdk25.coroutines.onItemLongClick

class HomeActivityUI(val memoAdapter: MemoAdapter) : AnkoComponent<HomeActivity> {
    override fun createView(ui: AnkoContext<HomeActivity>): View = with(ui) {
        return relativeLayout {
            var memoList: ListView? = null
//
            //layout to display ListView
            verticalLayout {
                memoList = listView {
                    adapter = memoAdapter
                    onItemLongClick { adapterView, view, i, l ->
                        val options = listOf("タグ変更", "削除")
                        selector("オプション", options) { dialogInterface, j ->
                            if (j == 1) {
                                var task = adapter.getItem(i)
                                memoAdapter?.delete(i)
                                longToast("メモ${task}は削除されました")
                            } else {
                                longToast("${adapter.getItem(i).toString()}の${options[j]}未実装")
                            }
                        }
                        true
                    }
                }
            }.lparams {
                margin = dip(5)
            }

            //Add task FloatingActionButton at bottom right
            floatingActionButton {
                imageResource = android.R.drawable.ic_input_add
                onClick {
                    val adapter = memoList?.adapter as MemoAdapter
                    startActivity<SplitActivity>("edittext" to "edit")
//
//                    alert {
//                        customView {
//                            verticalLayout {
//                                toolbar {
//                                    id = R.id.dialog_toolbar
//                                    lparams(width = matchParent, height = wrapContent)
//                                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
//                                    title = "メモ追加"
//                                    setTitleTextColor(ContextCompat.getColor(ctx, android.R.color.white))
//                                }
//                                val memo = editText {
//                                    hint = "テキスト入力"
//                                    padding = dip(20)
//                                }
//                                positiveButton("テキストを分解") {
//                                    if (memo.text.toString().isEmpty()) {
//                                        toast("文字が入力されていません！")
//                                    } else {
//                                        startActivity<SplitActivity>("edittext" to memo.text.toString())
//                                        adapter.add(memo.text.toString())
//                                    }
//                                }
//                            }
//                        }
//                    }.show()
                }
            }.lparams {
                //setting button to bottom right of the screen
                margin = dip(10)
                alignParentBottom()
                alignParentEnd()
                alignParentRight()
                gravity = Gravity.BOTTOM or Gravity.END
            }
        }.apply {
            layoutParams = FrameLayout.LayoutParams(matchParent, matchParent)
                .apply {
                    leftMargin = dip(5)
                    rightMargin = dip(5)
                }
        }

    }

    //function to get total number of items in list
    fun getTotalListItems(list: ListView?) = list?.adapter?.count ?: 0
}