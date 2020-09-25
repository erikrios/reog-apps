package io.erikrios.github.reogapps.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.erikrios.github.reogapps.databinding.FragmentFoodsBinding

class FoodsFragment : Fragment() {

    private var _binding: FragmentFoodsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodsBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}