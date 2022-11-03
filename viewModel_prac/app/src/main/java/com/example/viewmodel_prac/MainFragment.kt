package com.example.viewmodel_prac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.viewmodel_prac.databinding.FragmentMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.math.max


class MainFragment : Fragment() {
    lateinit var binding:FragmentMainBinding
    private val viewModel:MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewBinding - UI컨트롤러가 UI 업데이트
        binding.button.setOnClickListener {
            viewModel.pointUp()
            if(viewModel.isTwenty.value!!){
                showFinalScoreDialog()
            }
        }
        viewModel.curPoint.observe(viewLifecycleOwner){newPoint->
            binding.textView.text=getString(R.string.current_point,newPoint)
        }


        //dataBinding - layout단에서 UI업데이트
        binding.vm=viewModel
        binding.mCnt= maxCount
        binding.lifecycleOwner=viewLifecycleOwner

    }
    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("20에도달")
            .setMessage("함더?")
            .setCancelable(false)
            .setPositiveButton("포지티브버튼(re init variables)"){_,_->
                posi()
            }
            .setNegativeButton("네거티브버튼(activity.finish)"){_,_->
                nega()
            }
            .show()
    }
    fun posi(){
        viewModel.reInit()
    }
    fun nega(){
        activity?.finish()
    }
}