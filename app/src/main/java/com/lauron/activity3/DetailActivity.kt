package com.lauron.activity3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lauron.activity3.databinding.ActivityDetailBinding
import com.lauron.activity3.models.Email

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getSerializableExtra("email") as Email
        binding.name.text = email.senderName
        binding.subj.text = email.subject
        binding.cont.text = email.content
    }
}