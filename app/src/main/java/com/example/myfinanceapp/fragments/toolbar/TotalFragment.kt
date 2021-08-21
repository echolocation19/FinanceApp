package com.example.myfinanceapp.fragments.toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.myfinanceapp.MainActivity
import com.example.myfinanceapp.R
import kotlinx.android.synthetic.main.fragment_diagrams.*
import kotlinx.android.synthetic.main.fragment_total.*

class TotalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_total, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setupActionBar(toolbar as Toolbar)
    }

}