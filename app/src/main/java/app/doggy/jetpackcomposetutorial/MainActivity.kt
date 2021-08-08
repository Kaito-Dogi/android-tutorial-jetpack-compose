package app.doggy.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // アクティビティのレイアウトを定義する．
        // レイアウトコンテンツはXMLファイルで定義せず，コンポーズ可能な関数を呼び出す．
        setContent {
            NewStory()
        }
    }
}

// @Composableアノテーションを付けてコンポーズ可能な関数を作成する．
// コンポーズ可能な関数は，他のコンポーズ可能な関数のスコープ内からのみ呼び出せる．
@Composable
fun NewStory() {
    // 要素を垂直方向に並べる．
    Column(
        // パラメータを渡してレイアウトの設定を追加できる．
        modifier = Modifier.padding(16.dp)
    ) {
        // 画像を追加．
        Image(
            painter = painterResource(R.drawable.header),
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)), // 画像の角をShapeに合わせて切り抜く．
            contentScale = ContentScale.Crop
            // contentDescription = null
        )

        // 余白を追加．
        Spacer(modifier = Modifier.height(16.dp))

        // 文字を追加．
        Text("A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
            style = typography.h6,
            maxLines = 2)
        Text("Davenport, California",
            style = typography.body2)
        Text("December 2018",
            style = typography.body2)
    }
}

// Canaryビルドでは，@Previewを付けるとIDE内でプレビューできる．
@Preview
@Composable
fun DefaultPreview() {
    NewStory()
}