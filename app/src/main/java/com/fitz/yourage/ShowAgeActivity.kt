package com.fitz.yourage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowAgeActivity : AppCompatActivity() {
    private lateinit var txtShowAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_age)

        txtShowAge = findViewById(R.id.show_title)
        val person = intent.getParcelableExtra<Person>(MainActivity.PERSON_KEY)
        person?.let {
            txtShowAge.text = getString(R.string.show_age, it.name, it.age)
        }
    }
}