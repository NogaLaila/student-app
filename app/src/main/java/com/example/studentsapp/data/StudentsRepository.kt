package com.example.studentsapp.data

import com.example.studentsapp.models.Student

object StudentsRepository {

    private val students = arrayListOf(
        Student(
            id = "111111111",
            name = "Dana Levi",
            isChecked = false,
            address = "12 Herzl St, Tel Aviv",
            phone = "050-1234567"
        ),
        Student(
            id = "222222222",
            name = "Noam Cohen",
            isChecked = true,
            address = "8 Ben Yehuda St, Haifa",
            phone = "052-7654321"
        ),
        Student(
            id = "333333333",
            name = "Yael Or",
            isChecked = false,
            address = "25 Rothschild Blvd, Rishon LeZion",
            phone = "054-2223344"
        )
    )

    fun getAll(): ArrayList<Student> = students

    fun getById(id: String): Student? = students.find { it.id == id }

    fun toggleChecked(id: String) {
        val student = getById(id)
        student?.isChecked = !(student?.isChecked ?: false)
    }
}
