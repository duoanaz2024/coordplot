package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme
import kotlin.math.roundToInt

@Composable
fun MapSlider(titleRes: Int, percentage: Float, onPercentageChange: (Float) -> Unit) {

    Row(
        modifier = Modifier.padding(8.dp)
    ){
        Text(text = stringResource(titleRes) + ": " + (percentage * 100).roundToInt() + "%",
            Modifier.padding(8.dp)
                .width(120.dp))
        Slider(
            value = percentage,
            onValueChange = onPercentageChange
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MapSliderPreview() {
    var percentage: Float by remember { mutableFloatStateOf(0.5f) }
    MyApplicationTheme {
        MapSlider(
            titleRes = R.string.x_axis,
            percentage = percentage
        ) { percentage = it }
    }
}
