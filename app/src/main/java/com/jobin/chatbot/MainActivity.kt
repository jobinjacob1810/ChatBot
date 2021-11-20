package com.jobin.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jobin.chatbot.utils.ChatHandler

class MainActivity : AppCompatActivity() {

    private val chats: ArrayList<String> = arrayListOf()
    private lateinit var rvChat: RecyclerView
    private lateinit var etChat: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etChat = findViewById(R.id.et_chat_input)

        // handle submit button click
        findViewById<ImageButton>(R.id.b_submit).setOnClickListener {
            processChatMessage(etChat.text.trim().toString())
        }

        // setup chat list
        rvChat = findViewById(R.id.chat_messages_list)
        rvChat.layoutManager = LinearLayoutManager(this)
        rvChat.adapter = ChatAdapter(chats)
    }

    private fun processChatMessage(message: String) {
        // show user message
        addChatMessage("YOU -> $message")

        // get bot reply
        val botReply = ChatHandler.handleMessage(message.lowercase())

        // show bot reply with some delay
        Handler(Looper.getMainLooper()).postDelayed({
            addChatMessage("BOT -> $botReply")
        }, 1000)

        // clear input for next message
        etChat.setText("")
    }

    private fun addChatMessage(message: String) {

        // don't do anything if activity is finished
        if(isDestroyed || isFinishing) return

        // add chat item to the list
        chats.add(message)
        rvChat.adapter?.notifyItemInserted(chats.size - 1)
    }
}