package com.example.hvaquest.model

import com.example.hvaquest.R

data class Question (
    var question: String,
    var choices: Array<String>,
    var correctAnswer: String,
    var clue: Int
)

