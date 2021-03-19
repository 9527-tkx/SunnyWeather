package com.sunnyweather.android.ui.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.android.R

class GalleryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)

    }

//    private lateinit var galleryViewModel: GalleryViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        galleryViewModel =
//            ViewModelProvider(this).get(GalleryViewModel::class.java)
//        View root = inflater.inflate (R.layout.fragment_gallery, container, false)
//        val textView: TextView = root.findViewById<TextView>(R.id.text_gallery)
//        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//    }

}