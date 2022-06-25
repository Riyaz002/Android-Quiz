package com.example.androidquiz.ui.quizefragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.get
import androidx.lifecycle.Observer
import com.example.androidquiz.R
import com.example.androidquiz.databinding.FragmentQuizBinding
import com.example.androidquiz.ui.finishquizfragment.FinishedQuizFragment

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding

    companion object {
        fun newInstance() = QuizFragment()
    }

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        viewModel.finishGame.observe(viewLifecycleOwner, Observer {
            if(it){
                val bundle = Bundle()
                bundle.putString("score", viewModel.score.toString())

                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main_fragment, FinishedQuizFragment().also { it.arguments = bundle }).commit()
            }
        })
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radio1 -> viewModel.selectedAnswer(viewModel.quiz.value!!.option.one)
                R.id.radio2 -> viewModel.selectedAnswer(viewModel.quiz.value!!.option.two)
                R.id.radio3 -> viewModel.selectedAnswer(viewModel.quiz.value!!.option.three)
                R.id.radio4 -> viewModel.selectedAnswer(viewModel.quiz.value!!.option.four)
            }
            binding.btnNext.isEnabled = true
        }
        binding.btnNext.setOnClickListener {
            binding.radioGroup.clearCheck()
            it.isEnabled = false
            viewModel.nextQuiz()
        }

        binding.progress.max = viewModel.quizLength

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.quizNumber.observe(viewLifecycleOwner, Observer {
            binding.progress.progress = it-1
        })

    }

}