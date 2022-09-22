package ar.edu.unlam.ejerciciolivedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import ar.edu.unlam.ejerciciolivedata.databinding.ActivityMainBinding
import ar.edu.unlam.ejerciciolivedata.viewmodel.MainViewModel



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var vm: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        vm.numeroActual.observe(this, Observer {
            binding.tvNumero.text= it.toString()
        })

        vm.booleanActual.observe(this, Observer {
            val esparOno = it
            if(esparOno)
            {
                binding.tvEsPar.text ="PAR"
            } else{
                binding.tvEsPar.text ="IMPAR"
            }
        })

        binding.buttonMas.setOnClickListener{
            vm.numeroActual.postValue(++vm.numero)
            vm.booleanActual.postValue(vm.numero%2==0)
           
        }
        binding.buttonMenos.setOnClickListener{
            vm.numeroActual.postValue(--vm.numero)
            vm.booleanActual.postValue(vm.numero%2==0)
        }

    }
}
