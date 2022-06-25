package com.example.androidquiz.ui.finishquizfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.androidquiz.R
import com.example.androidquiz.ui.quizefragment.QuizFragment

class FinishedQuizFragment : Fragment() {

    private lateinit var score: TextView
    private lateinit var restartButton: Button

    companion object {
        fun newInstance() = FinishedQuizFragment()
    }

    private lateinit var viewModel: FinishedQuizViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_finished_quiz, container, false)
        restartButton = view.findViewById(R.id.btn_restart)
        score = view.findViewById(R.id.txt_score)

        restartButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main_fragment, QuizFragment()).commit()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = this.arguments
        viewModel = ViewModelProvider(this, FinishedQuizViewModelProvider(args!!.getString("score").toString())).get(FinishedQuizViewModel::class.java)
        score.text = viewModel.score
    }

}