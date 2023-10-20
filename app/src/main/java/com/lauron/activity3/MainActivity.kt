package com.lauron.activity3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lauron.activity3.adapters.EmailAdapter
import com.lauron.activity3.databinding.ActivityMainBinding
import com.lauron.activity3.models.Email

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailList = createSampleEmails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.emailRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(this, emailList)
    }

    private fun createSampleEmails(): List<Email> {
        val emails = mutableListOf<Email>()
        // Add at least 20 sample emails
        for (i in 1..20) {
            emails.add(Email("Sender $i", "Subject $i", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        }
        return emails
    }
}