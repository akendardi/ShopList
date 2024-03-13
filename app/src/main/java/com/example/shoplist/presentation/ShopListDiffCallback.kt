package com.example.shoplist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoplist.domain.ShopItem

//a class for adding a callback that will indicate what changes have occurred to the object
class ShopListDiffCallback(
    private val oldList : List<ShopItem>,
    private val newList : List<ShopItem>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    //checking for changes to the object id
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    //checking for changes to the object field
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldElement = oldList[oldItemPosition]
        val newElement = newList[newItemPosition]
        return oldElement == newElement
    }
}