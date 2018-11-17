package gdn.maskipli.mozbelajar.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import gdn.maskipli.mozbelajar.databinding.FragmentLoginBinding
import gdn.maskipli.mozbelajar.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return FragmentLoginBinding.inflate(inflater, container, false)
                .also { it.mainViewModel = mainViewModel }
                .root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared view model
        mainViewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        observeData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        btnLogin?.setOnClickListener {
            Toast.makeText(activity, mainViewModel.resultInputField(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeData() {
        mainViewModel.userName.observe(this, Observer {

        })

        mainViewModel.buttonLoginState.observe(this, Observer {
            btnLogin?.isEnabled = it ?: false
        })
    }
}
