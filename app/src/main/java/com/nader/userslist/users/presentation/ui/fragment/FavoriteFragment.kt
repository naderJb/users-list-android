package com.nader.userslist.users.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.nader.userslist.base.baseclasses.BaseFragment
import com.nader.userslist.databinding.FragmentFavoriteBinding
import com.nader.userslist.users.presentation.ui.adapter.UsersAdapter
import com.nader.userslist.users.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment : BaseFragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val usersViewModel: UsersViewModel by viewModels()


    @Inject
    lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        implementListeners()
        initObservers()
    }

    private fun initViews() {
        usersAdapter.isFavoriteDisabled(true)
        binding.rvUsers.adapter = usersAdapter
    }

    private fun implementListeners() {
        usersAdapter.setOnItemSelected {
            val userAdditionalInformationFragment =
                UserAdditionalInformationFragment.newInstance(it)
            userAdditionalInformationFragment.show(requireActivity().supportFragmentManager, "")
        }
    }

    private fun initObservers() {
        lifecycleScope.launch {
            usersViewModel.favoriteUsers.collect {
                usersAdapter.addData(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        usersViewModel.getFavoriteUsers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}