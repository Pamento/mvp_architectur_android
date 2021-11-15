package com.pawel.mvp_architecture.model


import android.os.Handler
import com.pawel.mvp_architecture.contracts.Contract



class Model : Contract.Model {
    private var index = 0
    // array list of strings from which
    // random strings will be selected
    // to display in the activity
    private val arrayList =
        listOf(
            "Model–view–presenter (MVP) is a derivation of the model–view–controller (MVC) architectural pattern. ",
            "MVP is used mostly for building user interfaces.",
            "In MVP, the presenter assumes the functionality of the \"middle-man\".",
            "In MVP, all presentation logic is pushed to the presenter.",
            "MVP is a user interface architectural pattern engineered" +
                    " to facilitate automated unit testing and improve the separation of concerns in presentation logic:",
            "The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.",
            "The view is a passive interface that displays data (the model) " +
                    "and routes user commands (events) to the presenter to act upon that data.",
            "The presenter acts upon the model and the view. " +
                    "It retrieves data from repositories (the model), and formats it for display in the view.",
            "Normally, the view implementation instantiates the concrete presenter object, providing a reference to itself.",
            "Thank you for reading."
        )

    // this method will invoke when
    // user clicks on the button
    // and it will take a delay of
    // 1200 milliseconds to display next course detail
    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({ onFinishedListener!!.onFinished(getNextString) }, 800)
    }


    // method to select random
    // string from the list of strings
    private val getNextString: String
        get() {
            //val random = Random()
            //val index = random.nextInt(arrayList.size)
            val i = if (index == arrayList.size) 0 else index
            index++
            return arrayList[i]
        }
}