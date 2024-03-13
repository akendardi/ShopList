package com.example.shoplist.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.R
import com.example.shoplist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var count = 0
    companion object{
         val ENABLED_RES = R.layout.shop_item_enabled
         val DISABLED_RES = R.layout.shop_item_disabled

        const val MAX_POOL_SIZE = 10
    }


    var shopList = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(shopList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val item = shopList[position]
        Log.d("onBindViewHolder", "${++count}")
        holder.itemView.setOnLongClickListener{
            onShopItemLongClickListener?.invoke(item)
            true
        }
        holder.itemView.setOnClickListener{
            onShopItemClickListener?.invoke(item)
        }
        holder.tvName.text = item.name
        holder.tvCount.text = item.count.toString()
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (shopList[position].enabled){
            ENABLED_RES
        } else{
            DISABLED_RES
        }
    }

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    interface OnShopItemLongClickListener{
        fun onShopItemLongClick(shopItem: ShopItem)
    }

    interface OnShopItemClickListener{
        fun onShopItemClick(shopItem: ShopItem)
    }
}