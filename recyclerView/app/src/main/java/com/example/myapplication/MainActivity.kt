package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val todos = listOf(
        Todo("my titlemy title #1",false),
        Todo("my titlemy title #2",false),
        Todo("my titlemy title #3",false),
        Todo("my titlemy title #4",false),
        Todo("my title my title#5",false),
        Todo("my titlemy title #6",false),
        Todo("my titmy titlee #7",false),
        Todo("my timy titletle #8",false),
        Todo("my titmy titlele #9",false),
        Todo("my timy titletle #10",false),
        Todo("my titlemy title #11",false),
        Todo("my titlemy title #12",false),
        Todo("my titlemy title #13",false),
        Todo("my titlemy title #14",false),
        Todo("my title my title#15",false),
        Todo("my titlemy title #16",false),
        Todo("my titmy titlee #17",false),
        Todo("my timy titletle #18",false),
        Todo("my titmy titlele #19",false),
        Todo("my timy titletle #20",false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.todoList.adapter=TodoAdapter(todos)//리사이클러뷰
        binding.clearButton.setOnClickListener {
            (binding.todoList.adapter as? TodoAdapter)?.clearAll()
        }
    }
}