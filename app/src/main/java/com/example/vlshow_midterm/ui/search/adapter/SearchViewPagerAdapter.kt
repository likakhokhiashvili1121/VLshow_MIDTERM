package com.example.vlshow_midterm.ui.search.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.vlshow_midterm.ui.search.fragment.movie_search.ui.SearchMoviesFragment
import com.example.vlshow_midterm.ui.search.fragment.person_search.ui.SearchPersonFragment

class SearchViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments:ArrayList<Fragment> = arrayListOf(
        SearchMoviesFragment(),
        SearchPersonFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}