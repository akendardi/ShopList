package com.example.shoplist.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.R

class ShopItemActivity : AppCompatActivity() {

    private lateinit var shopItemViewModel: ShopItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop_item)
        shopItemViewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]
    }

    companion object {
        private const val EXTRA_MODE = "extra_mode"
        private const val EXTRA_MODE_ADD_ITEM = "extra_mode_add_item"
        private const val EXTRA_MODE_EDIT_ITEM = "extra_mode_edit_item"
        private const val EXTRA_ID = "id"

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_MODE, EXTRA_MODE_ADD_ITEM)
            return intent
        }

        fun newIntentEditItem(context: Context, id: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_MODE, EXTRA_MODE_EDIT_ITEM)
            intent.putExtra(EXTRA_ID, id)
            return intent
        }
    }
}