package com.example.androidquiz.ui.startquizfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidquiz.R
import com.example.androidquiz.ui.quizefragment.QuizFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartQuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartQuizFragment : Fragment() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_quiz, container, false)

        button = view.findViewById(R.id.btn_start_quiz)
        button.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main_fragment, QuizFragment()).commit()
        }
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = StartQuizFragment()
    }
}