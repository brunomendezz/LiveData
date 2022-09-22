package ar.edu.unlam.ejerciciolivedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import ar.edu.unlam.ejerciciolivedata.databinding.ActivityMainBinding
import ar.edu.unlam.ejerciciolivedata.viewmodel.MainViewModel
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var vm: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        vm.numeroActual.observe(this, Observer {
            binding.tvNumero.text= it.toString()
        })

        vm.booleanActual.observe(this, Observer {
            var esparOno = it
            if(esparOno)
            {
                binding.tvEsPar.text ="PAR"
            } else{
                binding.tvEsPar.text ="IMPAR"
            }
        })

        binding.buttonMas.setOnClickListener{
            vm.numeroActual.value=++vm.numero
            vm.booleanActual.value=vm.numero%2==0
           
        }
        binding.buttonMenos.setOnClickListener{
            vm.numeroActual.value=--vm.numero
            vm.booleanActual.value=vm.numero%2==0
        }

    }
}
//ESTO LO HICE PORQ ME LO PEDIA EN EL by viewModels() ,no se que es..
private operator fun Any.setValue(mainActivity: MainActivity, property: KProperty<*>, mainViewModel: MainViewModel) {

}
