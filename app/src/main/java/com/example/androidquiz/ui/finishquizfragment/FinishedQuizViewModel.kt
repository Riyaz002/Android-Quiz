package com.example.androidquiz.ui.finishquizfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FinishedQuizViewModel(val score: String): ViewModel() {

}

class FinishedQuizViewModelProvider(val score: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FinishedQuizViewModel::class.java)){
            return FinishedQuizViewModel(score) as T
        } else throw IllegalArgumentException("Provider VieModel Class is not assignable")
    }

}