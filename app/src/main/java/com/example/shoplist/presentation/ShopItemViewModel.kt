package com.example.shoplist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShopListRepositoryImpl
import com.example.shoplist.domain.AddShopItemUseCase
import com.example.shoplist.domain.EditShopItemUseCase
import com.example.shoplist.domain.GetShopItemFromIdUseCase
import com.example.shoplist.domain.ShopItem
import java.lang.Exception

class ShopItemViewModel : ViewModel() {
    val repository = ShopListRepositoryImpl
    val addShopItemUseCase = AddShopItemUseCase(repository)
    val editShopItemUseCase = EditShopItemUseCase(repository)
    val getShopItemUseCase = GetShopItemFromIdUseCase(repository)


    fun getShopItem(id: Int) {
        val item = getShopItemUseCase.getShopItem(id)
    }

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val validInput = validateInput(name, count)
        if (validInput) {
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val validInput = validateInput(name, count)
        if (validInput) {
            val shopItem = ShopItem(name, count, true)
            editShopItemUseCase.editShopItem(shopItem)
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean{
        var result = true
        if (name.isBlank()){
            //TODO show name error
            result = false
        }
        if (count <= 0){
            //TODO show count error
            result = false
        }
        return result
    }
}