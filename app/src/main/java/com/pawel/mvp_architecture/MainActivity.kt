package com.pawel.mvp_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pawel.mvp_architecture.contracts.Contract
import com.pawel.mvp_architecture.databinding.ActivityMainBinding
import com.pawel.mvp_architecture.model.Model
import com.pawel.mvp_architecture.presenter.Presenter

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = Presenter(this, Model())
        setOnButtonListener()
    }

    private fun setOnButtonListener() {
        binding.button.setOnClickListener { presenter.onButtonClick() }
    }

    /**
     * Implement 3 functions of View Interface
     */
    override fun showProgress() {
//        binding.progressBar.visibility = View.VISIBLE
        binding.textView.visibility = View.INVISIBLE
        binding.mainLottieAnim.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.mainLottieAnim.visibility = View.INVISIBLE
        binding.textView.visibility = View.VISIBLE
//        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun setString(string: String?) {
        binding.textView.text = string
    }

    // presenter
    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}