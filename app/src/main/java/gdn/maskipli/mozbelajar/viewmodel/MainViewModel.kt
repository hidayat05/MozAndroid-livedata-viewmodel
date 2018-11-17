package gdn.maskipli.mozbelajar.viewmodel

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val userName = MutableLiveData<String>()

    val address = MutableLiveData<String>()

    val buttonLoginState = MediatorLiveData<Boolean>()


    init {

        buttonLoginState.apply {

            addSource(userName){
                value = !it.isNullOrBlank() && !address.value.isNullOrBlank()
            }

            addSource(address){
                value = !it.isNullOrBlank() && !userName.value.isNullOrBlank()
            }
        }
    }

    fun resultInputField():String{
        return "name ${userName.value} and address ${address.value}"
    }
}