package com.example.pokeactivity

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PokeAdapter(val context : Context, val data : ArrayList<PokeVO>)
    : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    var cnt : Int = 0
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {



        val view = LayoutInflater.from(context)
            .inflate(R.layout.poke_list, parent, false)



        val viewHolder = ViewHolder(view)



        viewHolder.tvName.setText(data.get(position).name)
        viewHolder.tvLevel.setText(data.get(position).level)

        return view
    }

    inner class ViewHolder(view : View){
        val tvName : TextView
        val tvLevel : TextView

        init {
            tvName = view.findViewById(R.id.tvName)
            tvLevel = view.findViewById(R.id.tvLevel)

            cnt++
            Log.d("호출횟수", cnt.toString())
        }

    }
}