package com.example.shoplist.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(id: Int)
    fun getShopItem(id: Int): ShopItem
    fun getShopingList() : List<ShopItem>
    fun removeShopItem(shopItem: ShopItem)
}