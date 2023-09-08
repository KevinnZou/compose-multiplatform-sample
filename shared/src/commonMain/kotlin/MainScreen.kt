import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import co.touchlab.kermit.Logger

/**
 * Created By Kevin Zou On 2023/8/22
 */
class MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel { MainScreenModel() }
        var count by remember { mutableStateOf(0) }
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Main Screen $count, ${screenModel.count}")
                Text(screenModel.text, modifier = Modifier.padding(top = 20.dp))
                Button(
                    onClick = { navigator.push(SecondScreen()) },
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Text("Go Next")
                }
                Button(
                    onClick = {
                        count++
                        screenModel.addOne()
                        Logger.i {
                            "MainScreen Add One"
                        }
                    },
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Text("Add 1")
                }
            }

        }
    }
}

