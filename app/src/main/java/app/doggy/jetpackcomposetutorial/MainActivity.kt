package app.doggy.jetpackcomposetutorial

import android.content.res.Configuration
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val msg = Message("Android", "Jetpack Compose is fun!")
        setContent {
            MaterialTheme {
                MessageCard(msg)
            }
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    // 2. 修飾子を使用してレイアウトを調整．
    // 2. Messageにpaddingを適用．
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Android Robot Image",
            modifier = Modifier
                // 2. Imageの縦横のサイズを40dpに設定．
                .size(40.dp)
                // 2. Imageを円形に切り取る．
                .clip(CircleShape)
                // 3. マテリアルデザイン（色）を適用する．
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                // 3. マテリアルデザイン（色）を適用する．
                color = MaterialTheme.colors.secondaryVariant,
                // 3. マテリアルデザイン（タイポグラフィ）を適用する．
                style = MaterialTheme.typography.subtitle2,
            )
            // 2. 余白を追加．
            Spacer(modifier = Modifier.width(8.dp))

            // 3. マテリアルデザイン（図形）を適用する．
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // 3. マテリアルデザイン（タイポグラフィ）を適用する．
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
// 3. ダークモードを有効にする．
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    val testMag = Message("test", "test is important!")
    MaterialTheme {
        MessageCard(testMag)
    }
}