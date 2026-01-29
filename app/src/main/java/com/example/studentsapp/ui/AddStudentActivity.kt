package com.example.studentsapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.data.StudentsRepository
import com.example.studentsapp.models.Student

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val etName = findViewById<EditText>(R.id.etName)
        val etId = findViewById<EditText>(R.id.etId)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val id = etId.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            // Validate input
            if (name.isEmpty() || id.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if ID already exists
            if (StudentsRepository.getById(id) != null) {
                Toast.makeText(this, "Student with this ID already exists", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create and add new student
            val newStudent = Student(
                id = id,
                name = name,
                isChecked = false,
                address = address,
                phone = phone
            )

            StudentsRepository.addStudent(newStudent)
            Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }
}
