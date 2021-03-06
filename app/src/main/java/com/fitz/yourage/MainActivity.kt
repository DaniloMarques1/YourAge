package com.fitz.yourage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalculate: Button
    private lateinit var edtName: EditText
    private lateinit var edtYear: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate = findViewById(R.id.main_btn_calculate)
        edtName = findViewById(R.id.main_edt_name)
        edtYear = findViewById(R.id.main_edt_year)

        btnCalculate.setOnClickListener {
            calculate(it)
        }
    }

    private fun calculate(view: View) {
        val calendar = Calendar.getInstance()
        val currenYear = calendar.get(Calendar.YEAR)
        val name = edtName.text.toString()
        val year = edtYear.text.toString().toInt()
        val person = Person(name, year, currenYear - year)

        launchShowActivity(person)
    }

    private fun launchShowActivity(person: Person) {
        val intent = Intent(this, ShowAgeActivity::class.java)
        intent.putExtra(PERSON_KEY, person)
        startActivity(intent)
    }

    companion object {
        const val PERSON_KEY = "PERSON_KEY"
    }

}