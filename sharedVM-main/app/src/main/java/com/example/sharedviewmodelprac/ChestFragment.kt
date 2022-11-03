package com.example.sharedviewmodelprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodelprac.databinding.FragmentChestBinding
import com.example.sharedviewmodelprac.model.SharedViewModel


class ChestFragment : Fragment() {
    var binding:FragmentChestBinding?=null
    private val sharedViewModel:SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentChestBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply{
            goNext.setOnClickListener { goNextScreen() }
            sharedVM = sharedViewModel
            chestFG=this@ChestFragment

        }
    }

    fun goNextScreen(){
        findNavController().navigate(R.id.action_chestFragment_to_legFragment)
    }

    fun cancel(){
        sharedViewModel.reset()
        findNavController().navigate(R.id.action_chestFragment_to_backFragment)
    }

}