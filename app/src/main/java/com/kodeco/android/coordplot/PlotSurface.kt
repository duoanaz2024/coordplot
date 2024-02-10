package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme
import kotlin.math.roundToInt

@Composable
fun PlotSurface() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        var xPercentage: Float by remember { mutableFloatStateOf(0.5f) }
        var yPercentage: Float by remember { mutableFloatStateOf(0.5f) }
        var boxSize: Int
        /*BoxWithConstraints {
            boxSize = if (maxHeight < 400.dp) {
                200
            } else{
                300
            }
            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(5.dp))
                Map(xPercentage, yPercentage, boxSize)
                MapSlider(titleRes = R.string.x_axis, percentage = xPercentage) { xPercentage = it }
                MapSlider(titleRes = R.string.y_axis, percentage = yPercentage) { yPercentage = it }

            }
        }*/

        BoxWithConstraints {
            if (maxHeight < 400.dp) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.padding(8.dp)
                ){
                    Map(xPercentage, yPercentage, 300)
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        MapSlider(titleRes = R.string.x_axis, percentage = xPercentage) { xPercentage = it }
                        MapSlider(titleRes = R.string.y_axis, percentage = yPercentage) { yPercentage = it }

                    }
                }
            } else{
                boxSize = 300
                Column(
                    modifier = Modifier.fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Map(xPercentage, yPercentage, boxSize)
                    MapSlider(titleRes = R.string.x_axis, percentage = xPercentage) { xPercentage = it }
                    MapSlider(titleRes = R.string.y_axis, percentage = yPercentage) { yPercentage = it }

                }
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}
