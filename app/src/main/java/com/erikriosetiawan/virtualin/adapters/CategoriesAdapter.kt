package com.erikriosetiawan.virtualin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.erikriosetiawan.virtualin.R
import com.erikriosetiawan.virtualin.models.Category

class CategoriesAdapter(
    var context: Context? = null,
    var categories: MutableList<Category>? = null
) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false))

    override fun getItemCount(): Int = categories?.size ?: -1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        categories?.get(position)?.let { it ->
            holder.bindItem(it) {
                Toast.makeText(context, categories?.let {
                    it[position].name
                }, Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgIcon: ImageView = view.findViewById(R.id.img_icon)
        private val tvCategoryName: TextView = view.findViewById(R.id.tv_category_name)

        fun bindItem(category: Category, listener: (Category) -> Unit) {
            category.icon?.let {
                imgIcon.setImageResource(it)
            }
            category.name?.let {
                tvCategoryName.text = it
            }
            itemView.setOnClickListener { listener(category) }
        }
    }
}