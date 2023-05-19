package com.nader.userslist.users.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.nader.userslist.R
import com.nader.userslist.base.baseclasses.BaseBottomSheetFragment
import com.nader.userslist.base.extensions.safe
import com.nader.userslist.databinding.FragmentUserAdditionalInformationBinding
import com.nader.userslist.users.data.model.UserModel


class UserAdditionalInformationFragment : BaseBottomSheetFragment() {

    private var _binding: FragmentUserAdditionalInformationBinding? = null
    private val binding get() = _binding!!

    private var userModel: UserModel? = null

    override fun getTheme(): Int = R.style.TransparentBottomSheetDialogTheme


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentUserAdditionalInformationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        userModel = arguments?.getParcelable(USER_MODEL)
        with(binding) {
            userModel?.let { user ->
                tvName.text = user.name.safe()
                tvStreet.text = user.address.street.safe()
                tvSuite.text = user.address.suite.safe()
                tvCity.text = user.address.city.safe()
                tvZipcode.text = user.address.city.safe()
                tvLat.text = user.address.geo.lat.safe()
                tvLong.text = user.address.geo.lng.safe()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(userModel: UserModel): UserAdditionalInformationFragment =
            UserAdditionalInformationFragment().apply {
                this.arguments = bundleOf(
                    USER_MODEL to userModel
                )
            }

        const val USER_MODEL = "USER_MODEL"
    }

}