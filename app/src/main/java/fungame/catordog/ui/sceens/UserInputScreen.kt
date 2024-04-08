package fungame.catordog.ui.sceens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fungame.catordog.data.UserDataUiEvents
import fungame.catordog.ui.AnimalCard
import fungame.catordog.ui.TextComponent
import fungame.catordog.ui.TextFieldComponent
import fungame.catordog.ui.TopBar
import fungame.catordog.ui.UserInputViewModel
import fungame.catordog.R
import fungame.catordog.ui.ButtonComponent

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String,String>) -> Unit,
) {
        Surface (modifier = Modifier.fillMaxSize()){
            
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ){
                TopBar(value = "Hi there  \uD83D\uDC4B")
                
                TextComponent(
                    textValue = "Let's learn about You !" ,
                    textSize = 24.sp,)

                Spacer(modifier = Modifier.size(20.dp))

                TextComponent(
                    textValue = "This app will prepare a details page" +
                            " based on input provided by you !",
                    textSize = 18.sp )

    Spacer(modifier = Modifier.size(60.dp))
    TextComponent(textValue = "Name", textSize =18.sp )
    Spacer(modifier = Modifier.size(10.dp))
    TextFieldComponent(onTextChange = {
        UserInputViewModel.onEvent(
            UserDataUiEvents.UserNameEntered(it)
        )
    })
         Spacer(modifier = Modifier.size(20.dp))

         TextComponent(textValue = "What do you like", textSize = 18.sp)

         Spacer(modifier = Modifier.size(10.dp))

         Row (modifier = Modifier.fillMaxWidth()){
              AnimalCard(image = R.drawable.cat, animalSelected ={
                UserInputViewModel.onEvent(
                    UserDataUiEvents.AnimalSelected(it)
                )
              }, selected = UserInputViewModel.uiState.value.animalSelected == "Cat" )
             AnimalCard(image = R.drawable.dog, animalSelected = {
                 UserInputViewModel.onEvent(
                     UserDataUiEvents.AnimalSelected(it)
                 )
             }, selected = UserInputViewModel.uiState.value.animalSelected == "Dog")
         }
            Spacer(modifier = Modifier.weight(1f))

               if(!UserInputViewModel.uiState.value.nameEntred.isNullOrEmpty()
                   &&
                   !UserInputViewModel.uiState.value.animalSelected.isNullOrEmpty()){
                ButtonComponent (
                    goToDetailsScreen = {
                        println("===CommingHere")
                        println("===${UserInputViewModel.uiState.value.nameEntred}" +
                                "and ${UserInputViewModel.uiState.value.animalSelected}")
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntred,
                                userInputViewModel.uiState.value.animalSelected,
                            )
                        )
                    }
                )
        }
            }
}
}
