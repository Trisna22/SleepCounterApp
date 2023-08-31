package com.example.sleepcounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sleepcounter.databinding.FragmentBabyBinding
import com.example.sleepcounter.databinding.FragmentCreditsBinding
import com.example.sleepcounter.databinding.FragmentDeadBinding
import com.example.sleepcounter.databinding.FragmentPussyBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BabyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreditsFragment : Fragment() {

    private lateinit var _binding: FragmentCreditsBinding;
    private val binding get() = _binding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreditsBinding.inflate(inflater, container, false)
        return binding.root
    }



}