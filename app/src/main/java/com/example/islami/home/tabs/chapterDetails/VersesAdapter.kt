package com.example.islami.home.tabs.chapterDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemVerseBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(viewBinding)


    }

    override fun getItemCount(): Int = verses.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val verseText = verses[position]
        holder.viewBinding.content.text = verseText


        if (verseText.isBlank()) {
            holder.viewBinding.divider.visibility = View.GONE
        } else {
            holder.viewBinding.divider.visibility = View.VISIBLE
        }
    }
}


