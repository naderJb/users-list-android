package com.nader.userslist.users.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.nader.userslist.R
import com.nader.userslist.base.baseclasses.BaseFragment
import com.nader.userslist.databinding.FragmentUsersBinding
import com.nader.userslist.users.data.model.FragmentAdapterModel
import com.nader.userslist.users.presentation.ui.adapter.UsersFragmentViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : BaseFragment() {
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val fragments by lazy {
        FragmentAdapterModel(
            listOf(UsersListFragment(), FavoriteFragment()),
            resources.getStringArray(R.array.tab_name).toList()
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
    }

    private fun initTabs() {
        binding.vpUsers.adapter = UsersFragmentViewPagerAdapter(
            fragments,
            lifecycle,
            requireActivity().supportFragmentManager
        )
        TabLayoutMediator(binding.tbUsers, binding.vpUsers) { tab, position ->
            tab.text = fragments.titles[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}