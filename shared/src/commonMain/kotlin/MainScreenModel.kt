import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created By Kevin Zou On 2023/8/22
 */
class MainScreenModel : ScreenModel {
    var count by mutableStateOf(0)
    var text by mutableStateOf("")
    private val client = HttpClient()

    init {
        loadData()
    }

    fun addOne(){
        count++
    }

    fun loadData() {
        coroutineScope.launch {
            val response = client.get("https://ktor.io/docs/")
            text = response.bodyAsText()
        }
    }
}