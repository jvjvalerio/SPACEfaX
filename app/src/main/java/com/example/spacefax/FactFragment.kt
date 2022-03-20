package com.example.spacefax

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FactFragment : Fragment(), Contract.View {

    // Initialization of imageView and fact variables
    var imageView: ImageView?=null
    var fact: TextView?=null

    // Initialization of presenter variable
    private var presenter: Presenter?=null

    // Override onCreateView method to inflate the layout for this fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fact, container, false)
    }

    // Override onViewCreated method to implement intro photo and welcome string onto the created view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(this)
        imageView = view.findViewById(R.id.elonsayshello)
        fact = view.findViewById(R.id.randomFactTextbox2)
    }

    // Companion object to return the updated instance of the fragment
    companion object
    {
        fun newInstance() : FactFragment
        {
            return FactFragment()
        }
    }

    // Method to update the view on click
    fun onButtonClick(){
        presenter?.onButtonClick()
    }

    // Method to update activity appearance
    override fun changeAppearance(image: Int, randomFact: String) {
        imageView?.setImageResource(image)
        fact?.text = randomFact
    }

    // Method to destroy the view
    override fun onDestroyView() {
        super.onDestroyView()
        presenter?.onDestroy()
        presenter = null
    }

    // Method to obtain view context
    override fun getViewContext(): Context {
        return requireContext()
    }
}
