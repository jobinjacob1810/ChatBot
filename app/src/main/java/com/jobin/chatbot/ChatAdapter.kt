package com.jobin.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chats: List<String>, private val listener: Listener? = null) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_message, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setChatMessage(chats[position])
    }

    override fun getItemCount(): Int = chats.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvChat: TextView = itemView.findViewById(R.id.tv_chat)

        init {
            tvChat.setOnClickListener {
                if(adapterPosition < 0) return@setOnClickListener
                listener?.onChatItemClicked(adapterPosition, chats[adapterPosition])
            }
        }

        fun setChatMessage(message: String) {

            if(message.startsWith("BOT ->")) {
                tvChat.background.setTint(ContextCompat.getColor(tvChat.context, R.color.bot_chat_color))
            }else{
                tvChat.background.setTint(ContextCompat.getColor(tvChat.context, R.color.user_chat_color))
            }

            tvChat.text = message
        }
    }

    interface Listener {
        fun onChatItemClicked(position: Int, item: String)
    }
}