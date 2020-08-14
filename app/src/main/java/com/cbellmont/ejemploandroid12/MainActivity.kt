package com.cbellmont.ejemploandroid12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*



interface Clickable {
    fun itemClicked(text: String)
}

class MainActivity : AppCompatActivity(), Clickable {


    private lateinit var adapter : StringAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = MutableList(100) { pos -> "Elemento $pos"}
        createRecyclerView(list)
        buttonRandom.setOnClickListener { adapter.updateData(list.apply { shuffle() }) }
    }

    private fun createRecyclerView(values: List<String>) {


        adapter = StringAdapter(values, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun itemClicked(text: String) {
        textView2.text = text
    }
}