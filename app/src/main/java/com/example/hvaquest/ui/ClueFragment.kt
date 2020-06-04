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
import com.example.hvaquest.model.Question
import kotlinx.android.synthetic.main.fragment_clue.*

/**
 * A simple [Fragment] subclass.
 */
class ClueFragment : Fragment() {

    lateinit var viewModel: QuizViewModel
    lateinit var  question: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as AppCompatActivity).get(QuizViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        question = viewModel.getQuestion()

        // Set clue image
        ivClue.setImageResource(question.clue)

        btnNext.setOnClickListener {
            if (viewModel.isQuestDone())
                findNavController().navigate(R.id.action_clueFragment_to_finishFragment)
            // NavigateUp is not used so the backtracking won't get messed up
            else findNavController().navigate(R.id.action_clueFragment_to_questionFragment)
        }
    }

}
