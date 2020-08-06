package com.example.infoappv2.ui.institute

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infoappv2.R
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class InstituteAdapter : RecyclerView.Adapter<InstituteAdapter.ViewHolder> {

    private var Instituteitems = ArrayList<InstituteItem>();
    private var context:Context;

    constructor(Instituteitems:ArrayList<InstituteItem>, context:Context)
    {
        this.Instituteitems = Instituteitems;
        this.context = context;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstituteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parseitem, parent, false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return Instituteitems.size;
    }

    override fun onBindViewHolder(holder: InstituteAdapter.ViewHolder, position: Int) {
        var instituteItem:InstituteItem = Instituteitems.get(position)
        holder.textView.setText(instituteItem.title)
        Picasso.get().load(instituteItem.imgURL).into(holder.imageView)
    }

    class ViewHolder : RecyclerView.ViewHolder{
        var imageView:ImageView;
        var textView:TextView;

        constructor(itemView:View) : super(itemView) {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
        }
    }
}