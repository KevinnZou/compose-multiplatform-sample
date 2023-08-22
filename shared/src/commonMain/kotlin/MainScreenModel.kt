import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel

/**
 * Created By Kevin Zou On 2023/8/22
 */
class MainScreenModel : ScreenModel {
    var count = mutableStateOf(0)

    fun addOne(){
        count.value++
    }
}