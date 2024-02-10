package com.kodeco.android.coordplot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun Map(xPercent: Float, yPercent: Float, boxSize: Int, modifier: Modifier = Modifier) {

    Box(
        modifier
            .size(boxSize.dp)
            .background(Color.Cyan)
    ){
        Image(
            painter = painterResource(id = R.drawable.car_image),
            contentDescription = "Car",
            modifier
                .offset((xPercent *  boxSize - 18).dp, (yPercent * boxSize - 18).dp)
                .size(36.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f, 300)
    }
}
