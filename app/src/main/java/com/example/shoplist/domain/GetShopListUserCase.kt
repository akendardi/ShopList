package com.example.shoplist.domain

class GetShopListUserCase(private val shopListRepository: ShopListRepository) {
    fun getShopingList() : List<ShopItem> {
        return shopListRepository.getShopingList()
    }
}