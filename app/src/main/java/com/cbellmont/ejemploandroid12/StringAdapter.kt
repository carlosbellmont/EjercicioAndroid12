package com.cbellmont.ejemploandroid12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StringAdapter(var stringList : List<String>, var listener : Clickable) : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    class StringViewHolder(var root: View, var textView: TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        return StringViewHolder(view, twTextView)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.textView.text = stringList[position]
        holder.root.setOnClickListener {
            Toast.makeText(holder.textView.context, "Has pulsado el ${stringList[position]}", Toast.LENGTH_LONG).show()
            listener.itemClicked("Has pulsado el elemento ${stringList[position]}")
        }
    }

    fun updateData(newData : List<String>){
        stringList = newData
        notifyDataSetChanged()
    }
}

