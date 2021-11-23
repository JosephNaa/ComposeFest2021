package js.pekah.statecodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import js.pekah.statecodelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* ... */
        binding.textInput.doAfterTextChanged {text ->
            name = text.toString()
            updateHello()
        }
    }

    private fun updateHello() {
        binding.helloText.text = "Hello, $name"
    }
}