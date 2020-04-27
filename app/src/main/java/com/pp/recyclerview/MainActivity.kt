package com.pp.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = ListAdapter(items)

        buttonAdd.setOnClickListener {
            addItem()
        }

        buttonRemove.setOnClickListener {
            removeItem()
        }
    }

    private fun addItem() {
        items.add("Item")
        recyclerView.adapter?.notifyItemInserted(items.lastIndex)
    }

    private fun removeItem() {
        if (items.isNotEmpty()) {
            items.removeAt(items.lastIndex)
            recyclerView.adapter?.notifyItemRemoved(items.size)
        }
    }

}
