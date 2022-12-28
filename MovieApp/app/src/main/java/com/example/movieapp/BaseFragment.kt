package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {



    open fun hideProgressBar() {}

    open fun showProgressBar() {}

    open fun setupRecyclerView() {}

    open fun observeData() {}
}