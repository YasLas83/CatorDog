package fungame.catordog.ui


import android.text.style.BackgroundColorSpan
import android.widget.Button
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fungame.catordog.R
import fungame.catordog.data.UserDataUiEvents
import java.lang.reflect.RecordComponent

@Composable
fun TopBar(value :String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
       Text(text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
       )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Native Mobile"
        )
    }
}

@Composable
fun TextComponent(textValue:String, textSize : TextUnit, colorValue: Color = Color.Black){

    Text(text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light,
        )
}

@Composable
fun TextFieldComponent(
    onTextChange: (name:String) -> Unit
){
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue=it
            onTextChange(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )

}

@Composable
fun AnimalCard(image:Int , selected: Boolean,
               animalSelected: (animalName:String)->Unit){
    val localFocusManager = LocalFocusManager.current
    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = if (selected) Color.Green else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val animalName = if (image == R.drawable.cat) "Cat" else "Dog"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    },
                painter = painterResource(id = image),
                contentDescription = "Cat Icone"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar(value = "Bach")
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "Tach", textSize = 24.sp, colorValue = Red)
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview(){

}

@Preview
@Composable
fun AnimalCardPreview(){

}

@Composable
fun ButtonComponent(
    goToDetailsScreen : () -> Unit
){

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { goToDetailsScreen }) {
            TextComponent(textValue = "Go to Details Screen",
                colorValue = Color.White,
                textSize = 18.sp)
    }
}

@Composable
fun TextWithShadow(value: String){
    val shadowOffset = Offset(
        x = 1f,
        y = 2f,
    )
    Text(text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style=TextStyle(
        shadow= Shadow(Color.Green, shadowOffset,2f)
        )
    )

}