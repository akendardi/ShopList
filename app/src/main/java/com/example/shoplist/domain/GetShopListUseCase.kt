package com.example.shoplist.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopingList() : List<ShopItem> {
        return shopListRepository.getShoppingList()
    }
}