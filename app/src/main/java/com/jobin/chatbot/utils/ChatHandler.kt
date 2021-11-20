package com.jobin.chatbot.utils

object ChatHandler {

    private val answersMap = HashMap<String, String>().apply {
        put(QuesAns.Questions.HELLO, QuesAns.Answers.QUES_HELLO)
        put(QuesAns.Questions.HI, QuesAns.Answers.QUES_HI)
    }

    fun handleMessage(message: String): String {
        return answersMap[message.lowercase()] ?: QuesAns.Answers.DEFAULT
    }
}