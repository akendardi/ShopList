package com.example.shoplist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShoppingList() : LiveData<List<ShopItem>> {
        return shopListRepository.getShoppingList()
    }
}