package com.sunnyweather.android.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        getActivity()?.getWindow()?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getActivity()?.getWindow()?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        super.onCreate(savedInstanceState)
    }
    //
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//        View root = inflater . inflate (R.layout.fragment_home, container, false);
//        val textView: TextView = root.findViewById<TextView>(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//    }

}