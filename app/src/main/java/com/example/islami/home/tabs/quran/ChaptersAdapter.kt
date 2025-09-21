package com.example.islami.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterBinding
import com.example.islami.model.Chapter

class ChaptersAdapter(val chapters: List<Chapter>) :
    RecyclerView.Adapter<ChaptersAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding: ItemChapterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemBinding = ItemChapterBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )

        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.itemBinding.englishtitleTv.text = chapter.titleEn
        holder.itemBinding.arabictitleTv.text = chapter.titleAr
        holder.itemBinding.versesNumberTv.text = chapter.versesNumber
        holder.itemBinding.chapterNumber.text = "${chapter.index + 1}"
    }
}