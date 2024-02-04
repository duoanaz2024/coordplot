package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                PlotSurface()
            }
        }
    }
}

@Composable
fun PlotSurface() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        var xPercentage: Float by remember { mutableFloatStateOf(0.5f) }
        var yPercentage: Float by remember { mutableFloatStateOf(0.5f) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(100.dp))

            Map(xPercentage, yPercentage)

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "X - Axis")
            Slider(
                value = xPercentage,
                onValueChange = { xPercentage = it }
            )
            Text(text = xPercentage.toString())

            Text(text = "Y - Axis")
            Slider(
                value = yPercentage,
                onValueChange = { yPercentage = it }
            )
            Text(text = yPercentage.toString())
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

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {

    Box(
        modifier
            .size(300.dp)
            .background(Color.Blue)
    ){
        Box(
            modifier
                .offset((xPercent * 300 - 18).dp, (yPercent * 300 - 18).dp)
                .size(36.dp)
                .clip(shape = CircleShape)
                .background(Color.Green)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}
