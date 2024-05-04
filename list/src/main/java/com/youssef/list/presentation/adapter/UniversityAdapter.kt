package com.youssef.list.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youssef.list.databinding.ItemUniversityBinding
import com.youssef.list.domain.entity.UniversityEntity

class UniversityAdapter(private val onClick: (UniversityEntity) -> Unit) :
    RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {

    var university: List<UniversityEntity> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class UniversityViewHolder(private val universityView: ItemUniversityBinding) :
        RecyclerView.ViewHolder(universityView.root) {
        fun bind(university: UniversityEntity) {
            universityView.universityNameTv.text = university.name
            universityView.universityDescTv.text = university.country
            universityView.universityCardView.setOnClickListener {
                onClick.invoke(university)
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UniversityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUniversityBinding.inflate(inflater, parent, false)
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind(university[position])
    }


    override fun getItemCount() = university.size
}