package gdn.maskipli.mozbelajar.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gdn.maskipli.mozbelajar.databinding.FragmentProfileBinding
import gdn.maskipli.mozbelajar.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentProfileBinding.inflate(inflater, container, false)
                .root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared view model
        mainViewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        observerData()
    }

    private fun observerData() {
        mainViewModel.address.observe(this, Observer {
            it?.let { addressResult ->
                address.text =  addressResult
            }
        })
    }
}