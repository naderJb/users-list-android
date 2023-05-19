package com.nader.userslist.users.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nader.userslist.users.data.model.FragmentAdapterModel

class UsersFragmentViewPagerAdapter(
    private val fragmentAdapterModel: FragmentAdapterModel,
    lifecycle: Lifecycle,
    fragmentManager: FragmentManager,
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = fragmentAdapterModel.fragments.size

    override fun createFragment(position: Int): Fragment = fragmentAdapterModel.fragments[position]
}