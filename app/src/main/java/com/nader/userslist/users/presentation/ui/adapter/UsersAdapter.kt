package com.nader.userslist.users.presentation.ui.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.nader.userslist.databinding.ItemUserBinding
import com.nader.userslist.users.data.model.UserModel
import javax.inject.Inject

class UsersAdapter @Inject constructor() : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var users = ArrayList<UserModel>()

    private var onItemSelected: ((UserModel) -> Unit)? = null
    private var onFavoriteSelected: ((UserModel) -> Unit)? = null
    private var isFavoriteDisabled: Boolean = false

    fun isFavoriteDisabled(isDisabled: Boolean) {
        isFavoriteDisabled = isDisabled
    }

    fun setOnItemSelected(listener: (UserModel) -> Unit) {
        onItemSelected = listener
    }

    fun setOnFavoriteSelected(listener: (UserModel) -> Unit) {
        onFavoriteSelected = listener
    }

    fun addData(allUsers: List<UserModel>) {
        users.clear()
        users.addAll(ArrayList(allUsers))
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder =
        UsersViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(users[position])
    }

    inner class UsersViewHolder(private var binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userModel: UserModel) {
            binding.user = userModel
            binding.root.setOnClickListener { onItemSelected?.invoke(userModel) }
            binding.tvFavorite.isGone = isFavoriteDisabled
            binding.tvFavorite.setColorFilter(
                if (userModel.isFavorite) Color.YELLOW else
                    Color.BLACK,
                PorterDuff.Mode.SRC_IN
            )
            binding.tvFavorite.setOnClickListener {
                onFavoriteSelected?.invoke(userModel)
                userModel.isFavorite = userModel.isFavorite.not()
                binding.tvFavorite.setColorFilter(
                    if (userModel.isFavorite) Color.YELLOW else
                        Color.BLACK,
                    PorterDuff.Mode.SRC_IN
                )
            }
        }

    }


}