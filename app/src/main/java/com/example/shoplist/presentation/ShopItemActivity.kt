package com.example.shoplist.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.R
import com.example.shoplist.domain.ShopItem
import com.google.android.material.textfield.TextInputLayout

class ShopItemActivity : AppCompatActivity() {

    private lateinit var shopItemViewModel: ShopItemViewModel

    private lateinit var til_name: TextInputLayout
    private lateinit var til_count: TextInputLayout
    private lateinit var et_name: EditText
    private lateinit var et_count: EditText
    private lateinit var button_save: Button

    private var extraMode = EMPTY_STRING
    private var id = ShopItem.UNDEFINED_ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop_item)
        parseIntent()
        initViews()
        shopItemViewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]
    }

    companion object {
        private const val EXTRA_MODE = "extra_mode"
        private const val EXTRA_MODE_ADD_ITEM = "extra_mode_add_item"
        private const val EXTRA_MODE_EDIT_ITEM = "extra_mode_edit_item"
        private const val EXTRA_ID = "id"
        private const val EMPTY_STRING = ""

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

    private fun initViews(){
        til_name = findViewById(R.id.til_name)
        til_count = findViewById(R.id.til_count)
        et_name = findViewById(R.id.et_name)
        et_count = findViewById(R.id.et_count)
        button_save = findViewById(R.id.buttonSave)
    }

    private fun parseIntent(){
        val intent = intent
        val intentExtraMode = intent.getStringExtra(EXTRA_MODE)
        if (!intent.hasExtra(EXTRA_MODE)){
            throw RuntimeException("Param mode empty")
        }
        if (intentExtraMode != EXTRA_MODE_ADD_ITEM && intentExtraMode != EXTRA_MODE_EDIT_ITEM){
            throw RuntimeException("Param is unknown")
        }
        if (intentExtraMode == EXTRA_MODE_ADD_ITEM){
            extraMode = EXTRA_MODE_ADD_ITEM
        } else {
            if (!intent.hasExtra(EXTRA_ID)){
                throw RuntimeException("Not id")
            } else {
                extraMode = EXTRA_MODE_EDIT_ITEM
                id = intent.getIntExtra(EXTRA_ID, -1)
            }
        }
    }

    private fun observers(){
        //TODO observers
    }
}