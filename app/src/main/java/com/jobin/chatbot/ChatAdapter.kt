package com.jobin.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chats: List<String>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_message, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setChatMessage(chats[position])
    }

    override fun getItemCount(): Int = chats.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvChat: TextView = itemView.findViewById(R.id.tv_chat)

        fun setChatMessage(message: String) {
            tvChat.text = message
        }
    }
}