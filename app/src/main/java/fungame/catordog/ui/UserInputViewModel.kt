package fungame.catordog.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import fungame.catordog.data.UserDataUiEvents
import fungame.catordog.data.UserInputScreenState

class UserInputViewModel : ViewModel(){




    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event:UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value= uiState.value.copy(
                    nameEntred = event.name
                )
            }

            is UserDataUiEvents.AnimalSelected ->{
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }
    }

    companion object {
        var uiState = mutableStateOf(UserInputScreenState())

        const val TAG = "UserInputViewModel"



        fun onEvent(event: UserDataUiEvents) {
            when (event) {
                is UserDataUiEvents.UserNameEntered -> {
                    uiState.value = uiState.value.copy(
                        nameEntred = event.name
                    )
        Log.d(TAG, "onEvent:UserNameEntered->>")
                    Log.d(TAG, "${uiState.value}")
                }

                is UserDataUiEvents.AnimalSelected -> {
                    uiState.value = uiState.value.copy(
                        animalSelected = event.animalValue
                    )
                    Log.d(TAG, "onEvent:AnimalSelected->>")
                    Log.d(TAG, "${uiState.value}")
                }
            }
        }



    }
}


