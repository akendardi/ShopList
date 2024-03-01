package com.example.shoplist.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(id: Int): ShopItem
    fun getShopingList() : List<ShopItem>
    fun removeShopItem(shopItem: ShopItem)
}