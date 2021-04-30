package com.digital.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvList: RecyclerView
    private var adapter = MenuItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setItemsLista()
    }

    private fun initViews() {
        rvList = findViewById(R.id.rv_list)
        rvList.adapter = adapter
        rvList.layoutManager = GridLayoutManager(this, 2)
    }

    private fun setItemsLista() {
        adapter.setItensList(
            arrayListOf(
                MenuItemModel(
                    "Cartões"
                ),
                MenuItemModel(
                    "Meus comprovantes"
                ),
                MenuItemModel(
                    "Home Broker"
                ),
                MenuItemModel(
                    "Extrato"
                ),
                MenuItemModel(
                    "Empréstimos"
                ),
                MenuItemModel(
                    "Portabilidade de salário"
                ),
                MenuItemModel(
                    "Recarga de telefone"
                ),
                MenuItemModel(
                    "Transferências"
                ),
                MenuItemModel(
                    "Crédito Especial"
                ),
                MenuItemModel(
                    "Depósito por boleto"
                ),
                MenuItemModel(
                    "Investimentos"
                )
            )
        )
    }
}