package com.example.islami.home.tabs.hadeath

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadeathBinding
import com.example.islami.model.Hadeth

class HadeathCarouselAdapter(val hadeathList: List<Hadeth>) :
    RecyclerView.Adapter<HadeathCarouselAdapter.ViewHolder>() {


    class ViewHolder(val viewBinding: ItemHadeathBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemHadeathBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = hadeathList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadeathList[position]
        holder.viewBinding.title.text = hadeth.title
        holder.viewBinding.content.text = hadeth.content
    }
}