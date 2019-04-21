package com.syabon.tagpad

import android.graphics.Typeface
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.jetbrains.anko.*

class MemoAdapter(val list: ArrayList<String> = ArrayList<String>()) : BaseAdapter() {
    override fun getView(i: Int, v: View?, parent: ViewGroup?): View {
        return with(parent!!.context) {
            var taskNum: Int = i + 1

            linearLayout {
                id = R.id.listItemContainer
                padding = dip(10)

                textView{
                    id = R.id.taskNum
                    text=taskNum.toString()
                    textSize = 16f
                    typeface = Typeface.MONOSPACE
                    padding = dip(5)
                }

                //Task Name
                textView{
                    id = R.id.taskName
                    text = list.get(i)
                    textSize = 16f
                    typeface = Typeface.DEFAULT_BOLD
                    padding = dip(5)
                }
            }
        }
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        //can be used to return the item's ID column of table
        return 0L
    }

    //function to add an item to the list
    fun add(text: String){
        list.add(list.size, text)
        notifyDataSetChanged()
    }

    //function to delete an item from list
    fun delete(i:Int){
        list.removeAt(i)
        notifyDataSetChanged()
    }
}