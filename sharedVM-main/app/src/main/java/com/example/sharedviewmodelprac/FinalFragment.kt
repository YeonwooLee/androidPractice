package com.example.sharedviewmodelprac

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodelprac.databinding.FragmentFinalBinding
import com.example.sharedviewmodelprac.model.SharedViewModel

class FinalFragment : Fragment() {
    var binding:FragmentFinalBinding?=null
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFinalBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply{
            sharedVM = sharedViewModel
            finalFG = this@FinalFragment
            saveButton.setOnClickListener{
                sendHealthLog()
            }
        }

    }

    fun sendHealthLog(){
//        Toast.makeText(this@FinalFragment.context,"저장되었습니다(구라임)",Toast.LENGTH_SHORT).show()
        val healthLog = getString(R.string.health_log_detail,
            sharedViewModel.backSet.value,
            sharedViewModel.chestSet.value,
            sharedViewModel.wholeLegSet.value,
            sharedViewModel.wholeSet.value)
        val mailReceivers = Array<String>(1){"fox_93@naver.com"}
        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT,getString(R.string.new_health_log))
            .putExtra(Intent.EXTRA_TEXT,healthLog)
            .putExtra(Intent.EXTRA_EMAIL,mailReceivers)

        if(activity?.packageManager?.resolveActivity(intent,0)!=null){
            startActivity(intent)
        }
    }
    fun cancel(){
        sharedViewModel.reset()
        findNavController().navigate(R.id.action_finalFragment_to_backFragment)
    }


}