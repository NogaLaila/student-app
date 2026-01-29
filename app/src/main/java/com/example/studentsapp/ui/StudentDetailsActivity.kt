package com.example.studentsapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.data.StudentsRepository

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
        val btnEdit = findViewById<Button>(R.id.btnEdit)

        name.text = student.name
        id.text = student.id
        address.text = student.address
        phone.text = student.phone
        chk.isChecked = student.isChecked

        img.setImageResource(R.drawable.avatar)

        btnEdit.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_ID", studentId)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val studentId = intent.getStringExtra("STUDENT_ID") ?: return
        val student = StudentsRepository.getById(studentId) ?: return

        val name = findViewById<TextView>(R.id.tvName)
        val address = findViewById<TextView>(R.id.tvAddress)
        val phone = findViewById<TextView>(R.id.tvPhone)

        name.text = student.name
        address.text = student.address
        phone.text = student.phone
    }
}
