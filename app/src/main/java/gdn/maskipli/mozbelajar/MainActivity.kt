package gdn.maskipli.mozbelajar

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import gdn.maskipli.mozbelajar.databinding.ActivityMainBinding
import gdn.maskipli.mozbelajar.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        observeData()
    }

    private fun observeData() {

        mainViewModel.userName.observe(this, Observer {
            it?.let { username ->
                Log.e("mainActivity", username)
                welcomeMessage.text = getString(R.string.format_welcome_message, username)
            }
        })
    }
}
