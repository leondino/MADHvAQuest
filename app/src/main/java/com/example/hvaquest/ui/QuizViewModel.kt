package com.example.hvaquest.ui

import androidx.lifecycle.ViewModel
import com.example.hvaquest.data.QuestRepository
import com.example.hvaquest.model.Question

class QuizViewModel: ViewModel() {

    var quizNumber: Int = 1
    val questRepository = QuestRepository()

    fun getQuestion() : Question{
        return questRepository.getHvaQuest()[quizNumber-1]
    }

    fun isAnswerCorrect(answer: String) : Boolean{
        return answer == getQuestion().correctAnswer
    }

    fun isQuestDone() : Boolean{
        return if (quizNumber == 10)
            true
        else {
            quizNumber++
            false
        }
    }
}