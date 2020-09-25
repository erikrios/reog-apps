package io.erikrios.github.reogapps.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import io.erikrios.github.reogapps.R
import io.erikrios.github.reogapps.adapters.ExplorePagerAdapter
import io.erikrios.github.reogapps.databinding.FragmentExploreBinding
import io.erikrios.github.reogapps.ui.MainActivity

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments = mutableListOf(NewsFragment(), SitesFragment(), FoodsFragment())
        binding?.viewPager2?.adapter = ExplorePagerAdapter(this, fragments)

        binding?.let {
            binding?.tabLayout?.let { tabLayout ->
                binding?.viewPager2?.let { viewPager2 ->
                    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                        tab.apply {
                            when (position) {
                                0 -> text = getString(R.string.news)
                                1 -> text = getString(R.string.sites)
                                2 -> text = getString(R.string.foods)
                            }
                        }
                    }.attach()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).setActionBarElevation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}