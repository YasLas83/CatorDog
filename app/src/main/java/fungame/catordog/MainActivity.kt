package fungame.catordog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fungame.catordog.ui.sceens.FunFactsNavigationGraph
import fungame.catordog.ui.sceens.Routes
import fungame.catordog.ui.sceens.UserInputScreen
import fungame.catordog.ui.sceens.WelcomeScreen
import fungame.catordog.ui.theme.CatOrDogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatOrDogTheme {
                CatOrDogApp()

            }
        }
    }
    @Composable
    fun CatOrDogApp(){
        FunFactsNavigationGraph()
}
}

