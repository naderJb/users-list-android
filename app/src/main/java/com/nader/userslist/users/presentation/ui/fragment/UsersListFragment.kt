package com.nader.userslist.users.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.nader.userslist.base.baseclasses.BaseFragment
import com.nader.userslist.base.extensions.shouldShowFap
import com.nader.userslist.base.models.DataStatus
import com.nader.userslist.databinding.FragmentUsersListBinding
import com.nader.userslist.users.presentation.ui.adapter.UsersAdapter
import com.nader.userslist.users.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UsersListFragment : BaseFragment() {
    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!

    private val usersViewModel: UsersViewModel by viewModels()

    @Inject
    lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        implementListeners()
        initObservers()
    }

    private fun initViews() {
        binding.rvUsers.adapter = usersAdapter
        usersViewModel.getUsers()
    }

    private fun implementListeners() {
        usersAdapter.setOnItemSelected {
            val userAdditionalInformationFragment =
                UserAdditionalInformationFragment.newInstance(it)
            userAdditionalInformationFragment.show(requireActivity().supportFragmentManager, "")
        }
        usersAdapter.setOnFavoriteSelected {
            usersViewModel.updateUser(it)
        }
        binding.fap.setOnClickListener {
            binding.rvUsers.smoothScrollToPosition(0)
        }
        binding.rvUsers.shouldShowFap {
            binding.fap.isVisible = it
        }
    }

    private fun initObservers() {
        lifecycleScope.launch {
            usersViewModel.users.collect {
                usersAdapter.addData(it)
            }
        }
        lifecycleScope.launch {
            usersViewModel.status.collect { dataStatus ->
                when (dataStatus) {
                    DataStatus.DataLoading -> {
                        showLoading(true)
                    }

                    DataStatus.DataLoaded -> {
                        showLoading(false)
                    }

                    is DataStatus.DataError -> {
                        showLoading(false)
                        showToast(dataStatus.exception)
                    }
                }
            }
        }
    }

    private fun showLoading(isVisible: Boolean) {
        binding.animationView.isVisible = isVisible
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}