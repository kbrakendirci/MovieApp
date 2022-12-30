package com.example.movieapp

import androidx.recyclerview.widget.RecyclerView

interface ListAdapterListener<T> {
    fun onListItemClicked(item: T, position: Int) {}
    fun onRemoveClicked(item: T, adapter: RecyclerView.Adapter<*>?) {}
    fun onEditClicked(item: T, position: Int) {}
    fun onUpdateClicked(item: T, position: Int) {}
}