package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemTodoBinding

private const val TAG = "MyActivity"
class TodoAdapter(private val todos:List<Todo>): RecyclerView.Adapter<TodoViewHolder>() {
    fun clearAll(){
        Log.d(TAG,"clear all")
        todos.forEach { it.completed=true }
        notifyDataSetChanged()//데이터 바인딩 다시해~
    }

    //뷰홀더(~= 뷰) 생성 -- 호출횟수 정해져있다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        Log.d(TAG,"OnCreateViewHolder")
        val binding =ItemTodoBinding.inflate(//inflate할 때,
            LayoutInflater.from(parent.context),//inflate해주는 녀석
            parent,//이 뷰가 속할 parent View (여기선 recyclerView(==parent)
            false//parent에 연결해줄껴? ㄴㄴ -> 내가 할게 아니라 리싸이클뷰가 해줘야함
        )
        return TodoViewHolder(binding).also { holder->
            binding.completedCheckBox.setOnCheckedChangeListener { button, isChecked ->
                Log.d(TAG,"checked clicked $isChecked")
                todos.getOrNull(holder.adapterPosition)?.completed=isChecked
            }
        }
    }

    //뷰에 데이터 바인딩 -- 호출 횟수 =사용자 행동에 따라 다름
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        Log.d(TAG,"OnBindingViewHolder $position")
        //position = holder.adapterPosition으로 변경 가능
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size

}

class TodoViewHolder(private val binding:ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(todo:Todo){
        binding.todoTitleText.text = todo.title
        binding.completedCheckBox.isChecked=todo.completed
    }
}