package com.dvdb.creditscore.presentation.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dvdb.creditscore.R
import com.dvdb.creditscore.presentation.overview.viewmodel.ViewModelOverview

class ViewOverviewFragment : Fragment() {
    private lateinit var viewModel: ViewModelOverview

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelOverview::class.java)
    }

    companion object {
        fun newInstance() = ViewOverviewFragment()
    }
}