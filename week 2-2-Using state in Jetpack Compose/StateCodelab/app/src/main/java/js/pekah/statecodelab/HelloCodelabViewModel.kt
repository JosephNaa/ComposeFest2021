package js.pekah.statecodelab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloCodelabViewModel: ViewModel() {

   // LiveData holds state which is observed by the UI
   // (state flows down from ViewModel)
   private val _name = MutableLiveData("")
   val name: LiveData<String> = _name

   // onNameChanged is an event we're defining that the UI can invoke
   // (events flow up from UI)
   fun onNameChanged(newName: String) {
       _name.value = newName
   }
}

class HelloCodeLabActivityWithViewModel : AppCompatActivity() {
   private val helloViewModel by viewModels<HelloCodelabViewModel>()

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       /* ... */

       binding.textInput.doAfterTextChanged {
           helloViewModel.onNameChanged(it.toString()) 
       }

       helloViewModel.name.observe(this) { name ->
           binding.helloText.text = "Hello, $name"
       }
   }
}