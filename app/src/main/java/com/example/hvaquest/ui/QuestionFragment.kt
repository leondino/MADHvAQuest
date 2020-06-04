package com.example.hvaquest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.hvaquest.R
import com.example.hvaquest.model.Question
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    lateinit var viewModel: QuizViewModel
    lateinit var radioGroup: RadioGroup
    lateinit var question: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as AppCompatActivity).get(QuizViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Get question object
        question = viewModel.getQuest()

        // Get question
        tvQuestion.text = question.question

        // Setting up Radio Buttons with answers
        radioGroup = rgAnswers
        rbAnswer1.text = question.choices[0]
        rbAnswer2.text = question.choices[1]
        rbAnswer3.text = question.choices[2]

        // Setting question number
        tvNumber.text = getString(R.string.question_number, viewModel.quizNumber)

        btnConfirm.setOnClickListener {
            if (viewModel.isAnswerCorrect(getSelectedAnswer())){
                findNavController().navigate(R.id.action_questionFragment_to_clueFragment)
            }
            else{
                Toast.makeText(context, getString(R.string.wrong_answer), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getSelectedAnswer() : String{
        val radioId: Int = radioGroup.checkedRadioButtonId
        val radioButton: RadioButton = requireView().findViewById(radioId)
        return radioButton.text.toString()
    }

}
