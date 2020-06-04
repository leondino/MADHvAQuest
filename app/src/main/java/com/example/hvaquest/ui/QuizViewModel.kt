package com.example.hvaquest.ui

import androidx.lifecycle.ViewModel
import com.example.hvaquest.data.QuestRepository
import com.example.hvaquest.model.Question

class QuizViewModel: ViewModel() {

    var quizNumber: Int = 1
    val questRepository = QuestRepository()

    fun getQuest() : Question{
        return questRepository.getHvaQuest()[quizNumber]
    }

    fun isAnswerCorrect(answer: String) : Boolean{
        return answer == getQuest().correctAnswer
    }
}