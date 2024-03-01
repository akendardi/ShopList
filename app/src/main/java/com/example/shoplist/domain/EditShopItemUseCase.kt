package com.example.shoplist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(id: Int){
        shopListRepository.editShopItem(id)
    }
}