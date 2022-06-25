package com.example.androidquiz.ui.quizefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidquiz.dataclass.Quiz
import com.example.quizapp.util.DemoList


class QuizViewModel : ViewModel() {
    val demoList: List<Quiz> = DemoList.getDemoList()
    val quizLength: Int = demoList.size
    private var _quizNumber = MutableLiveData<Int>(0)
    val quizNumber: LiveData<Int> get() = _quizNumber
    val _quiz = MutableLiveData<Quiz>()
    val quiz: LiveData<Quiz> get() = _quiz
    var selectedAnswer = ""
    var score = 0
    val finishGame = MutableLiveData(false)

    init {
        startGame()
    }

    private fun startGame() {
        nextQuiz()
    }

    fun nextQuiz() {
        updateScore()
        if(quizNumber.value!! < quizLength){
            showNextQuiz()
            _quizNumber.value = quizNumber.value!!+1
            selectedAnswer=""
        } else{
            finishGame.value = true
        }
    }

    private fun updateScore() {
        if(selectedAnswer!=""){
            if(selectedAnswer==quiz.value!!.answer) score++
        }
    }

    private fun showNextQuiz() {
    _quiz.value = demoList[quizNumber.value!!]
    }

    fun selectedAnswer(value: String) {
        selectedAnswer = value
    }
}