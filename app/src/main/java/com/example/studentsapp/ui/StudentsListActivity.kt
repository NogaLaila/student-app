package com.example.studentsapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentsapp.R
import com.example.studentsapp.data.StudentsRepository

class StudentsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvStudents)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = StudentsAdapter(
            StudentsRepository.getAll(),
            onStudentClick = { student ->
                val intent = Intent(this, StudentDetailsActivity::class.java)
                intent.putExtra("STUDENT_ID", student.id)
                startActivity(intent)
            },
            onCheckClick = { student ->
                StudentsRepository.toggleChecked(student.id)
            }
        )
    }
}
