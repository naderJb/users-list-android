package com.nader.userslist.base.baseclasses

import androidx.fragment.app.Fragment
import com.nader.userslist.base.extensions.safe
import com.nader.userslist.base.extensions.showToast

abstract class BaseFragment : Fragment() {
    fun showToast(exception: Exception?) {
        requireContext().showToast(exception?.message.safe())
    }
}