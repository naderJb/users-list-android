package com.nader.userslist.users.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.nader.userslist.base.baseclasses.BaseFragment
import com.nader.userslist.databinding.FragmentUsersBinding
import com.nader.userslist.users.presentation.ui.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : BaseFragment() {
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    val usersViewModel: UsersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        implementListeners()
        initObservers()
    }

    private fun initViews() {
        usersViewModel.getUsers()
    }

    private fun implementListeners() {
    }


    private fun initObservers() {
        lifecycleScope.launch {
            usersViewModel.users.collect {
                it.forEach { users ->
                    Log.e("nano", users.name)
                }
            }
        }
        lifecycleScope.launch {
            usersViewModel.status.collect {

            }
        }
    }


}