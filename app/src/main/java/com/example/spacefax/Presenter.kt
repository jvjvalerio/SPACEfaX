package com.example.spacefax

class Presenter(var view: Contract.View?): Contract.Presenter{
    private val model = Model()
    override fun onButtonClick() {
        view?.changeAppearance(model.getRandomImageID(), model.getRandomFact())
    }

    override fun onDestroy() {
        view = null
    }
}