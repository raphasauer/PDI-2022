package com.site_valley.loginappexamplekotlin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    var userIndex = -1
    var passwords = arrayOf(
        "878404",
        "1234",
        "000"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userText = findViewById<AutoCompleteTextView>(R.id.edtUserName)

        val users = arrayOf(
            "101 - SETADIGITAL",
            "1018 - DANILO SOUZA",
            "1019 - RAPHAEL SAUER"
        )

        val adapter = ArrayAdapter(
            this,
            R.layout.drop_down_tile,
            users
        )

        userText.threshold = 3
        userText.setAdapter(adapter)
        userText.setTextColor(Color.GRAY)
        userText.setBackgroundColor(Color.WHITE)
        userText.onItemClickListener = OnItemClickListener { adpt, _, position, _ ->
            userIndex = position
        }
    }

    fun onclick(view: View) {
        login(
            findViewById<TextInputEditText>(R.id.edtPassword).text.toString()
        )
    }

    private fun login(password: String) {

        if(password == passwords[userIndex]) {
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
    }
}