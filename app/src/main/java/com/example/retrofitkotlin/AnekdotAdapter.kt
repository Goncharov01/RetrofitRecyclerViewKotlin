package com.example.retrofitkotlin

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AnekdotAdapter (var list:ArrayList<Anekdot>):RecyclerView.Adapter<AnekdotAdapter.ViewHolder>(){

//    var list : List<Anekdot> = listOf()
    fun setAnekdotList(list:ArrayList<Anekdot>){
    this.list=list
    notifyDataSetChanged()

}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view=LayoutInflater.from(parent?.context).inflate(R.layout.post_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return list.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, pozition: Int) {
        //Html.fromHtml(post.getElementPureHtml(), Html.FROM_HTML_MODE_LEGACY)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            viewHolder?.postitem_post.text=Html.fromHtml(list[pozition].elementPureHtml,Html.FROM_HTML_MODE_LEGACY)
        }
        else{
            viewHolder?.postitem_post.text=Html.fromHtml(list[pozition].elementPureHtml)
        }
        viewHolder?.postitem_site.text=list[pozition].site
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
    val postitem_post=view.findViewById<TextView>(R.id.postitem_post)
        val postitem_site=view.findViewById<TextView>(R.id.postitem_site)

    }



}
