package com.example.sleepcounter

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.sleepcounter.databinding.FragmentCalculateBinding
import java.sql.Time
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Period

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
private const val ARG_SLEEP_HOURS = "sleepHours"
private const val ARG_SLEEP_MINUTES = "sleepMinutes"

class CalculateFragment : Fragment() {

    private var _binding: FragmentCalculateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.timePicker.setIs24HourView(true);
        binding.buttonBereken.setOnClickListener {
            calculateTime()
        }
        binding.buttonCredits.setOnClickListener{
            findNavController().navigate(R.id.action_calculateFragment_to_creditsFragment);
        }
    }

    class Time(internal var hours: Int, internal var minutes: Int) {
        override fun toString(): String {
            return hours.toString() + " : " + minutes.toString();
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateTime () {

        val currentTime = LocalDateTime.now();
        val start = Time(currentTime.hour, currentTime.minute)
        val stop = Time(binding.timePicker.hour, binding.timePicker.minute)

        val diff = Time(0, 0)

        if (stop.minutes < start.minutes) {
            ++start.hours
            stop.minutes += 60
        }

        diff.hours = stop.hours - start.hours
        diff.minutes = stop.minutes - start.minutes

        Log.d("TEST", diff.hours.toString() + " hours and " + diff.minutes.toString() + " minutes")

        val args: Bundle = bundleOf(Pair(ARG_SLEEP_HOURS, diff.hours.toString()), Pair(
            ARG_SLEEP_MINUTES, diff.minutes.toString()))

        when {
            diff.hours == 0 -> findNavController().navigate(R.id.action_calculateFragment_to_zombieFragment, args);
            diff.hours == 1 -> findNavController().navigate(R.id.action_calculateFragment_to_deadFragment, args);
            diff.hours == 2 -> findNavController().navigate(R.id.action_calculateFragment_to_timeFragment, args);
            diff.hours == 3 -> findNavController().navigate(R.id.action_calculateFragment_to_pffFragment, args);
            diff.hours == 4 -> findNavController().navigate(R.id.action_calculateFragment_to_wowFragment, args);
            diff.hours == 5 -> findNavController().navigate(R.id.action_calculateFragment_to_bigmanFragment, args)
            diff.hours == 6 -> findNavController().navigate(R.id.action_calculateFragment_to_alrightFragment, args)
            diff.hours == 7 -> findNavController().navigate(R.id.action_calculateFragment_to_pussyFragment, args)
            diff.hours >= 8 -> findNavController().navigate(R.id.action_calculateFragment_to_babyFragment, args)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}