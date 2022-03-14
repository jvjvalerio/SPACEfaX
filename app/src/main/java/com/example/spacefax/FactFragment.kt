package com.example.spacefax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class FactFragment : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fact, container, false)
    }

    companion object
    {
        fun newInstance() : Fragment
        {
            return Fragment()
        }
    }
}