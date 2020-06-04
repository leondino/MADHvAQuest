package com.example.hvaquest.ui

import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {
    var answer: String = ""

    fun isAnswerCorrect(answer: String) : Boolean{
        return answer.toLowerCase() == this.answer.toLowerCase()
    }
}