package com.example.introduction_to_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introduction_to_compose.ui.theme.Introduction_to_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Introduction_to_composeTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}


data class Message(val autor:String , val body:String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                // Set image size to 40 dp
                .size(50.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape).border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.autor, color = MaterialTheme.colors.secondaryVariant, style = MaterialTheme.typography.subtitle2)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }

}
@Preview
@Composable
fun PreviewMessageCard() {
    Introduction_to_composeTheme() {
        Surface {
            MessageCard(
                msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}
