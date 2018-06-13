package com.mine.countryinfo

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_nation_detail.view.*

/**
 * Created by nairs77 on 2018. 4. 27..
 */
data class NationData (var resId: Int, var name: String, var capital: String)

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val img_flag: ImageView = view.findViewById<ImageView>(R.id.img_flag)
    val txt_name: TextView = view.findViewById<TextView>(R.id.text_name)
    val txt_captial: TextView = view.findViewById<TextView>(R.id.capital)
}

class NationAdapter (var context: Context, val items: List<NationData>): RecyclerView.Adapter<ViewHolder>() {
    private var onItemClick: View.OnClickListener? = null
    private val mInflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val mainView = mInflater.inflate(R.layout.layout_nation_list_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        return ViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_flag.setImageResource(items[position].resId)
        holder.txt_name.text = items[position].name
        holder.txt_captial.text = items[position].capital
        holder.txt_name.tag = position
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

}