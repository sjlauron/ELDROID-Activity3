package com.lauron.activity3.adapters

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lauron.activity3.DetailActivity
import com.lauron.activity3.databinding.EmailItemBinding
import com.lauron.activity3.models.Email
import java.io.Serializable

class EmailAdapter(private val context: Context, private val emailList: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(private val binding: EmailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val email = emailList[position]
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("email", email)
                    context.startActivity(intent)
                }
            }
            // Set a maximum of 1 line for content text view
            binding.content.maxLines = 1
            binding.content.ellipsize = TextUtils.TruncateAt.END
        }

        fun bind(email: Email) {
            binding.senderName.text = email.senderName
            binding.subject.text = email.subject
            binding.content.text = email.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val binding = EmailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emailList[position])
    }

    override fun getItemCount(): Int {
        return emailList.size
    }
}