package com.example.hvaquest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.hvaquest.R
import kotlinx.android.synthetic.main.fragment_finish.*

/**
 * A simple [Fragment] subclass.
 */
class FinishFragment : Fragment() {

    lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as AppCompatActivity).get(QuizViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFinish.setOnClickListener {
            //reset quiz
            viewModel.quizNumber = 1
            findNavController().navigate(R.id.action_finishFragment_to_homeFragment)
        }
    }

}
