package com.example.sleepcounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sleepcounter.databinding.FragmentBabyBinding
import com.example.sleepcounter.databinding.FragmentPussyBinding
import com.example.sleepcounter.databinding.FragmentWowBinding
import com.example.sleepcounter.databinding.FragmentZombieBinding

private const val ARG_SLEEP_HOURS = "sleepHours"
private const val ARG_SLEEP_MINUTES = "sleepMinutes"

/**
 * A simple [Fragment] subclass.
 * Use the [BabyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ZombieFragment : Fragment() {

    private lateinit var _binding: FragmentZombieBinding;
    private val binding get() = _binding;

    // TODO: Rename and change types of parameters
    private var sleepHours: String? = null
    private var sleepMinutes: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sleepHours = it.getString(ARG_SLEEP_HOURS)
            sleepMinutes = it.getString(ARG_SLEEP_MINUTES)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentZombieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sleepCounter.text = "Je hebt $sleepHours uur en $sleepMinutes minuten slaap!";
    }

}