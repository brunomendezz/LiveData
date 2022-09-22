package ar.edu.unlam.ejerciciolivedata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

var numero=0

    var numeroActual = MutableLiveData<Int>()
    var booleanActual = MutableLiveData<Boolean>()

}