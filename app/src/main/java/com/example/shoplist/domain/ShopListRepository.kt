package com.example.shoplist.domain

import androidx.lifecycle.LiveData

/*Данный интерфейс является астракцией бд. тут прописаны методы, которые
* должна уметь каждая база данных. нас не интересует, какая там база данных*/
interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(id: Int): ShopItem
    fun getShoppingList() : LiveData<List<ShopItem>>
    fun removeShopItem(shopItem: ShopItem)
}