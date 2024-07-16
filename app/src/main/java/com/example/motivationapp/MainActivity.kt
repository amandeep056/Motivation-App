package com.example.motivationapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var categorySpinner: Spinner
    private lateinit var getQuoteButton: Button
    private lateinit var quoteTextView: TextView

    private val quotes = mapOf(
        "Inspiration" to listOf(
            "The best way to get started is to quit talking and begin doing.",
            "The pessimist sees difficulty in every opportunity. The optimist sees opportunity in every difficulty."
        ),
        "Motivation" to listOf(
            "Don’t let yesterday take up too much of today.",
            "You learn more from failure than from success. Don’t let it stop you. Failure builds character."
        ),
        "Happiness" to listOf(
            "Happiness is not by chance, but by choice.",
            "Happiness is when what you think, what you say, and what you do are in harmony."
        )
    )

    private var selectedCategory: String = "Inspiration"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categorySpinner = findViewById(R.id.categorySpinner)
        getQuoteButton = findViewById(R.id.getQuoteButton)
        quoteTextView = findViewById(R.id.quoteTextView)

        val categories = quotes.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedCategory = categories[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        getQuoteButton.setOnClickListener {
            val quotesList = quotes[selectedCategory] ?: listOf("Stay positive!")
            val randomQuote = quotesList.random()
            quoteTextView.text = randomQuote
        }
    }
}
