package com.nader.userslist.users.presentation.ui

import androidx.lifecycle.viewModelScope
import com.nader.userslist.base.baseclasses.BaseViewModel
import com.nader.userslist.base.models.DataStatus
import com.nader.userslist.base.models.Status
import com.nader.userslist.users.data.model.UserModel
import com.nader.userslist.users.domain.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : BaseViewModel() {
    private val _users: MutableStateFlow<List<UserModel>> = MutableStateFlow(listOf())
    val users = _users.asStateFlow()


    private val _status: MutableStateFlow<DataStatus> = MutableStateFlow(DataStatus.DataLoaded)
    val status = _status.asStateFlow()


    fun getUsers() {
        viewModelScope.launch {
            usersUseCase.getUsers().collect { dataStatus ->
                when (dataStatus.status) {
                    Status.LOADING -> _status.emit(DataStatus.DataLoading)

                    Status.SUCCESS -> {
                        _status.emit(DataStatus.DataLoading)
                        dataStatus.data?.let {
                            _users.emit(it)
                        }
                    }

                    Status.ERROR -> {
                        _status.emit(DataStatus.DataError(dataStatus.exception))
                    }
                }
            }
        }
    }
}