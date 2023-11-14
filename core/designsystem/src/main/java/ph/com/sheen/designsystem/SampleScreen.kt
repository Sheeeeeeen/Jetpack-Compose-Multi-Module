package ph.com.sheen.designsystem

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import ph.com.sheen.designsystem.theme.ui.JetpackComposeMultiModuleTheme

@Composable
fun SampleRoute(){
    SampleScreen()
}

@Composable
fun SampleScreen(modifier: Modifier = Modifier){
    Text(
        text = "Sheen",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun SampleScreenPreview(){
    JetpackComposeMultiModuleTheme {
        SampleScreen()
    }
}