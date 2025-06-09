package com.example.homepage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.arapp.TopicActivity
import com.example.yourapp.SubjectActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoHome: Button = findViewById(R.id.btnGoHome)
        val subjectButton = findViewById<Button>(R.id.button_subject)
        val topicButton = findViewById<Button>(R.id.button_topic)
        btnGoHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            subjectButton.setOnClickListener {
                val intent = Intent(this, SubjectActivity::class.java)
                startActivity(intent)
            }

            topicButton.setOnClickListener {
                val intent = Intent(this, TopicActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
