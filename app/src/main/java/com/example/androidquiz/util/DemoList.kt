package com.example.quizapp.util

import com.example.androidquiz.dataclass.Option
import com.example.androidquiz.dataclass.Quiz

object DemoList {
    fun getDemoList(): List<Quiz>{
        val list = mutableListOf<Quiz>()

        val option1 = Option("Yes, a user can save all database updates in onStop()",
            "No, a user can save in onSavedInstance()",
            "No, a user can save in a Bundle()",
            "No, In some situations, a user can't reach onStop()"
        )
        val quiz1 = Quiz(
            "Can a user save all database updates in onStop ()?",
            option1,
            "No, In some situations, a user can't reach onStop()"
        )

        val option2 = Option("onCreate()−>onStartCommand()−>onDestory()",
            "onRecieve()",
            "final()",
            "Service life cycle is same as activity life cycle."
        )

        val quiz2 = Quiz("What is the life cycle of services in android?", option2, "onCreate()−>onStartCommand()−>onDestory()")

        val option3 = Option("We can store the data in a common database and access the data on services as well as in Activity",
            "We can't pass data from activity to services.",
            "Using putExtra() method in intent, we can pass the data using setResult()",
            "A & C"
        )

        val quiz3 = Quiz("How to pass the data from activity to services in android?", option3, "A & C")


        val option4 = Option("10 sec",
            "15 sec",
            "5 sec",
            "1 hour"
        )

        val quiz4 = Quiz("What is the time limit of broadcast receiver in android?", option4, "10 sec")

        val option5 = Option("Interface class",
            "A class that does not have a name but have functionalities in it",
            "Java class",
            "Manifest file"
        )
        val quiz5 = Quiz("What is an anonymous class in android?", option5, "A class that does not have a name but have functionalities in it")


        val option6 = Option(
            "Android packages",
            "Android pack",
            "Android packaging kit",
            "None of the above"
        )

        val quiz6 = Quiz( "What is APK in android?", option6, "Android packaging kit")

        val option7 = Option("Http entity",
            "Http response",
            "Http result",
            "None of the above"
        )
        val quiz7 = Quiz("What does httpclient.execute() returns in android?", option7, "Http response")

        val option8 = Option("JSon Exception",
            "Json Not found exception",
            "Input not found exception",
            "None of the above"
        )
        val quiz8 = Quiz("What is the JSON exception in android?", option8, "JSon Exception")

        val option9 = Option("App level security and kernel level security",
            "Android level security",
            "Java level security",
            "None of the above"
        )
        val quiz9 = Quiz("How many levels of securities are there in android?", option9, "App level security and kernel level security")

        val option10 = Option("Same as list view",
            "provides the information on respective relative positions",
            "Same as relative layout",
            "None of the above"
        )
        val quiz10 = Quiz("What is anchor view?", option10, "provides the information on respective relative positions")

        list.add(quiz1)
        list.add(quiz2)
        list.add(quiz3)
        list.add(quiz4)
        list.add(quiz5)
        list.add(quiz6)
        list.add(quiz7)
        list.add(quiz8)
        list.add(quiz9)
        list.add(quiz10)

        return list
    }
}