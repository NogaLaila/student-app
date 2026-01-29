package com.example.studentsapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentsapp.R
import com.example.studentsapp.data.StudentsRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentsListActivity : AppCompatActivity() {

    private lateinit var adapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvStudents)
        val fabAddStudent = findViewById<FloatingActionButton>(R.id.fabAddStudent)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentsAdapter(
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

        recyclerView.adapter = adapter

        fabAddStudent.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
