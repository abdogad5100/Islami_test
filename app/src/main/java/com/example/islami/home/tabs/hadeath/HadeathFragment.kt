package com.example.islami.home.tabs.hadeath

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentHadeathBinding
import com.example.islami.model.Hadeth
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy


class HadeathFragment : Fragment() {
    lateinit var viewBinding: FragmentHadeathBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadeathBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    val hadethList: MutableList<Hadeth> = mutableListOf()

    lateinit var adapter: HadeathCarouselAdapter
    lateinit var layoutManager: CarouselLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadeathFile()
        initHadeathRecycler()

    }

    private fun initHadeathRecycler() {
        adapter = HadeathCarouselAdapter(hadethList)
        layoutManager = CarouselLayoutManager(
            FullScreenCarouselStrategy(),
            CarouselLayoutManager.HORIZONTAL,
        )
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        viewBinding.hadethRecyclerView.adapter = adapter
        viewBinding.hadethRecyclerView.layoutManager = layoutManager
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(viewBinding.hadethRecyclerView)
    }


    fun readAhadeathFile() {
        val fileContent = activity?.assets?.open("hadeath/ahadeth.txt")
            ?.bufferedReader().use { it?.readText() }
        if (fileContent == null) return
        val hadeathLinesList = fileContent.trim()
            .split("#")
        hadeathLinesList.forEach { singleHadeth ->
            val lines = singleHadeth.trim()
                .split("\n")
            val title = lines[0]
            val content = lines.takeLast(lines.size - 1).joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)

        }


//        for (i in 0 .. hadeathList.size){
//            val singleHadeth = hadeathList[i]
//        }


    }


}