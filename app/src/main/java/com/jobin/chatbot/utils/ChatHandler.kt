package com.jobin.chatbot.utils

object ChatHandler {

    private val answersMap = LinkedHashMap<String, String>().apply {
        put(QuesAns.Questions.HELLO, QuesAns.Answers.QUES_HELLO)
        put(QuesAns.Questions.HI, QuesAns.Answers.QUES_HI)
        put(QuesAns.Questions.COST,QuesAns.Answers.QUES_COST)
        put(QuesAns.Questions.DOCS,QuesAns.Answers.QUES_DOCS)
        put(QuesAns.Questions.SEATS,QuesAns.Answers.QUES_SEATS)
        put(QuesAns.Questions.PROCS,QuesAns.Answers.QUES_PROCS)
        put(QuesAns.Questions.ASS,QuesAns.Answers.QUES_ASS)
        put(QuesAns.Questions.OUT,QuesAns.Answers.QUES_OUT)
        put(QuesAns.Questions.FUR,QuesAns.Answers.QUES_FUR)
        put(QuesAns.Questions.PRO,QuesAns.Answers.QUES_PRO)
        put(QuesAns.Questions.BTECH,QuesAns.Answers.QUES_BTECH)
        put(QuesAns.Questions.MTECH,QuesAns.Answers.QUES_MTECH)
        put(QuesAns.Questions.PHD,QuesAns.Answers.QUES_PHD)
        put(QuesAns.Questions.CAN,QuesAns.Answers.QUES_CAN)
    }

    fun getQuestions() : List<String> {
        return answersMap.keys.toList()
    }

    fun handleMessage(message: String): String {
        return answersMap[message] ?: QuesAns.Answers.DEFAULT
    }
}