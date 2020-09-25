package io.erikrios.github.reogapps.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ExplorePagerAdapter(
    fragment: Fragment,
    val fragments: MutableList<Fragment>
) :
    FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemCount(): Int = fragments.size
}