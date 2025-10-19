package com.example.islami.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentHadeathBinding

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


}