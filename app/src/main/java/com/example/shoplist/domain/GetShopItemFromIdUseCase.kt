package com.example.shoplist.domain

class GetShopItemFromIdUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(id: Int): ShopItem{
        return shopListRepository.getShopItem(id)
    }
}