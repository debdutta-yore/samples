package com.yore.samples.architecture.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.yore.samples.architecture.R
import com.yore.samples.architecture.presentation.ui.viewmodel.SplashViewModel
import com.yore.samples.architecture.databinding.FragmentSplashBinding
import com.yore.samples.core.common.Page
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {
    var binding: FragmentSplashBinding? = null
    val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding?.lifecycleOwner = this
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.viewmodel = viewModel

        viewModel.notifyNavigation.observe(viewLifecycleOwner){
            when(it.getContentIfNotHandled()){
                Page.HOME->Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.notifyNavigation.removeObservers(viewLifecycleOwner)
        binding = null
    }
}
