package com.example.spacefax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


class FactFragment : Fragment(), Contract.View
{
    var imageView: ImageView?=null
    var title: TextView?=null
    private var presenter: Presenter?=null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(this)
        imageView = view.findViewById(R.id.spacexphoto1)
        title = view.findViewById(R.id.randomFactTextbox2)
    }

    companion object
    {
        fun newInstance() : FactFragment
        {
            return FactFragment()
        }
    }

    fun onButtonClick(){
        presenter?.onButtonClick()
    }

    override fun changeAppearance(image: Int, randomFact: String) {
        imageView?.setImageResource(image)
        title?.text = randomFact
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter?.onDestroy()
        presenter = null
    }
}
