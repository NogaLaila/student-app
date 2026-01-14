package com.example.studentsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.R
import com.example.studentsapp.models.Student

class StudentsAdapter(
    private val students: ArrayList<Student>,
    private val onStudentClick: (Student) -> Unit,
    private val onCheckClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgStudent)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val id: TextView = itemView.findViewById(R.id.tvId)
        val checkBox: CheckBox = itemView.findViewById(R.id.chk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]

        holder.name.text = student.name
        holder.id.text = student.id

        holder.img.setImageResource(R.drawable.avatar)

        holder.checkBox.setOnCheckedChangeListener(null)
        holder.checkBox.isChecked = student.isChecked

        holder.checkBox.setOnCheckedChangeListener { _, _ ->
            onCheckClick(student)
        }

        holder.itemView.setOnClickListener {
            onStudentClick(student)
        }
    }

    override fun getItemCount(): Int = students.size
}
