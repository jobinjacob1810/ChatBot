package com.jobin.chatbot.utils

class QuesAns {

    object Questions {
        const val HELLO = "hello"
        const val HI = "hi"
    }

    object Answers {
        const val QUES_HELLO = "hi"
        const val QUES_HI = "hello"
        const val DEFAULT = "Please select from the available questions"
    }

    private val answersMap = HashMap<String, String>().apply {
        put(Questions.HELLO, Answers.QUES_HELLO)
        put(Questions.HI, Answers.QUES_HI)
    }

    fun getAnswer(question: String) = answersMap[question.lowercase()] ?: Answers.DEFAULT
}