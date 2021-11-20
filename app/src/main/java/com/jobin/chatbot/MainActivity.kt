package com.jobin.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val chats: ArrayList<String> = arrayListOf()
    lateinit var rvChat: RecyclerView
    lateinit var etChat: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etChat = findViewById(R.id.et_chat_input)

        findViewById<ImageButton>(R.id.b_submit).setOnClickListener {
            addChatMessage(etChat.text.trim().toString())
            etChat.setText("")
        }

        rvChat = findViewById(R.id.chat_messages_list)
        rvChat.layoutManager = LinearLayoutManager(this)
        rvChat.adapter = ChatAdapter(chats)
    }

    private fun addChatMessage(message: String) {
        chats.add(message)
        rvChat.adapter?.notifyItemInserted(chats.size - 1)
    }
}