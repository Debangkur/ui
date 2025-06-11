 package com.example.homepage


import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class TopicActivity : AppCompatActivity() {

    data class Topic(
        val title: String,
        val progress: String,
        val category: String,
        val iconResId: Int,
        val tagColor: Int,
        val tagBg: Int
    )

    private lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        gridLayout = findViewById(R.id.gridLayout)

        val topics = listOf(
            Topic("Megnatic Field", "5/8 models", "Science", R.drawable.ic_megnet, R.color.purple_700, R.color.light_purple),
            Topic("Elctromegnatic Field", "2/6 models", "Biology", R.drawable.ic_electromegnet, R.color.blue_700, R.color.light_blue),
        )

        for (topic in topics) {
            addTopicCard(topic)
        }
    }

    private fun addTopicCard(topic: Topic) {
        val card = CardView(this).apply {
            layoutParams = GridLayout.LayoutParams().apply {
                width = 0
                height = ViewGroup.LayoutParams.WRAP_CONTENT
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                setMargins(8, 8, 8, 8)
            }
            radius = 24f
            cardElevation = 8f
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
        }

        val icon = ImageView(this).apply {
            setImageResource(topic.iconResId)
            layoutParams = LinearLayout.LayoutParams(64, 64)
        }

        val title = TextView(this).apply {
            text = topic.title
            setTextColor(ContextCompat.getColor(this@TopicActivity, android.R.color.black))
            textSize = 16f
            setPadding(0, 12, 0, 4)
            setTypeface(null, android.graphics.Typeface.BOLD)
        }

        val progress = TextView(this).apply {
            text = topic.progress
            setTextColor(ContextCompat.getColor(this@TopicActivity, android.R.color.darker_gray))
            textSize = 14f
        }

        val category = TextView(this).apply {
            text = topic.category
            setTextColor(ContextCompat.getColor(this@TopicActivity, topic.tagColor))
            textSize = 12f
            setPadding(16, 8, 16, 8)
            background = ContextCompat.getDrawable(this@TopicActivity, R.drawable.category_tag)
            backgroundTintList = ContextCompat.getColorStateList(this@TopicActivity, topic.tagBg)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = 8
                gravity = Gravity.START
            }
        }

        layout.apply {
            addView(icon)
            addView(title)
            addView(progress)
            addView(category)
        }

        card.addView(layout)
        gridLayout.addView(card)
    }
}
