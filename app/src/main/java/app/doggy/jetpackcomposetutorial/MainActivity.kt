package app.doggy.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
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
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

// Canaryビルドでは，@Previewを付けるとIDE内でプレビューできる．
@Preview
@Composable
fun DefaultPreview() {
    NewStory()
}