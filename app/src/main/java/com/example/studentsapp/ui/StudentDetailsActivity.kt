package com.example.studentsapp.ui

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.data.StudentsRepository
import com.squareup.picasso.Picasso

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentId = intent.getStringExtra("STUDENT_ID") ?: return
        val student = StudentsRepository.getById(studentId) ?: return

        val img = findViewById<ImageView>(R.id.imgStudent)
        val name = findViewById<TextView>(R.id.tvName)
        val id = findViewById<TextView>(R.id.tvId)
        val address = findViewById<TextView>(R.id.tvAddress)
        val phone = findViewById<TextView>(R.id.tvPhone)
        val chk = findViewById<CheckBox>(R.id.chk)

        name.text = student.name
        id.text = student.id
        address.text = student.address
        phone.text = student.phone
        chk.isChecked = student.isChecked

        img.setImageResource(R.drawable.avatar)
    }
}
