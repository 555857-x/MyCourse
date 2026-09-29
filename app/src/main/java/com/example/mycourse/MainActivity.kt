package com.example.mycourse

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mycourse.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = CoursePagerAdapter(this)

        val judulTab = arrayOf("Home", "Materi", "Quiz")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, posisi ->
            tab.text = judulTab[posisi]
        }.attach()
    }

    fun bukaHalaman(posisi: Int) {
        binding.viewPager.currentItem = posisi
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                bukaHalaman(0)
                true
            }
            R.id.action_materi -> {
                bukaHalaman(1)
                true
            }
            R.id.action_quiz -> {
                bukaHalaman(2)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private class CoursePagerAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment()
                1 -> MateriFragment()
                else -> QuizFragment()
            }
        }
    }
}