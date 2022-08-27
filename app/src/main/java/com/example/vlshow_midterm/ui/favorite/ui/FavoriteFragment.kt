package com.example.vlshow_midterm.ui.favorite.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.vlshow_midterm.databinding.FragmentFavoriteBinding
import com.example.vlshow_midterm.ui.favorite.adapter.FavoriteViewPagerAdapter

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager2: ViewPager2 = binding.viewPagerFavorite
        viewPager2.isUserInputEnabled = false
        val adapter = FavoriteViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = adapter
        binding.moviesCategory.setOnClickListener {
            viewPager2.currentItem = 0
            binding.moviesCategory.setTextColor(Color.parseColor("#D81F26"))
            binding.personCategory.setTextColor(Color.parseColor("#FFFFFF"))

        }
        binding.personCategory.setOnClickListener {
            viewPager2.currentItem = 1
            binding.personCategory.setTextColor(Color.parseColor("#D81F26"))
            binding.moviesCategory.setTextColor(Color.parseColor("#FFFFFF"))

        }
    }
}