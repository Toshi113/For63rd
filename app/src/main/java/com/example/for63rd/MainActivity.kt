// パッケージ...1つのアプリ=1つのパッケージ。Kotlinで最も大きな枠組み。
package com.example.for63rd

// インポート文...他のパッケージをインストールできる。そこから好きなものを使うことができる。
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

// クラス...Kotlinで二番目に大きい枠組み。オブジェクト指向とよばれる由来。難しいので矢向の解説を聞こう。1クラス=1部品。
class MainActivity : AppCompatActivity() ,View.OnClickListener{

    // 整数をいれる「number」という名前の箱を作成します(=コンピューターのメモリを確保します)。最初の値は0にしています(慣習です)。
    // 変数...中に値を入れることができる箱。名前を付けることができる。
    var number : Int = 0

    // onCreateに囲まれた箇所(15から37行目)はActivityが作られるときに最初に実行されます。
    // メソッド...Kotlinで三番目に大きい枠組み。クラスの中にいっぱい作ることができる。1メソッド=1機能。
    override fun onCreate(savedInstanceState: Bundle?) {
        // このダブルスラッシュから始まる行のことをコメントといいます。ここはコンピューターには無視されるので好きに書いてOK。もちろん書かなくてもいいです。
        // 今回はこのソースコードの内容の説明を書いているので僕の口頭での説明が分かんなくなったらここを読んでくれればわかると思います。もちろんわかんなかったら気軽に質問してください。

        /*
        こんな感じでスラッシュとコメ印で囲むことで
        複数行にわたる
        コメントを書くこともできます。(ダブルスラッシュは1行のコメントしか書けません)
        基本的にコメントは自分や他人がこのプログラムを見たときにこれ何してるんだっけとならないように書くメモのようなものです。
        先ほどのダブルスラッシュ(1行だけならそののほうが見やすいとされています)と読みやすいほうを使い分けましょう。
        今回は皆さんが分かりやすいようにとんでもない量を書いていますが普通はわかりづらい箇所に簡単なメモを書く程度です。
        */
        
        /**
         * 上の書き方もいいですが、これはJavaDoc式の書き方。仕様説明の時に用いられ、可読性が高い。
         * @pram とすると引数(未解説)の情報がかけたりします。
         * いろんなコメントの書き方があるのでここ参照。https://qiita.com/mtanabe/items/2e52e6e162d28df8437f
         */

        // 下の2行はデフォルトであると思います。この2行では画面を作成する処理をしています。ほとんどの場合(最低でも皆さんが担当するレベル)ではここはデフォルトで存在するので書けなくてOKです。
        super.onCreate(savedInstanceState)
        // メソッドの実行。setContentViewという名前のメソッドが提供されていて実行しているのがこの行。実行の仕方は「メソッド名(引数)」
        // 引数...メソッドを実行するときに引き渡す値。メソッドの機能次第でその値を使っていろんなことができる。
        setContentView(R.layout.activity_main)

        // この1行で先ほど作成したtextViewに最初に表示する文字を指定しています。(ここは最初に実行される個所なのでここで指定したものが最初に表示されます。)
        textView_number.text = "0"

        // この2行でボタンにOnClickListenerをsetします(そのままですね)。OnClickListenerがsetされたViewがClickされると参照先のonClickイベントが実行されます。
        // 今回は「this」なので52行目から始まるonClick()が実行されます。
        button_minus.setOnClickListener(this)
        button_plus.setOnClickListener(this)
    }

    // ここ以降のonClick()メソッドは先ほどonClickListenerがsetされたボタンが押された際に実行されます。
    override fun onClick(v: View?) {
        // when文によって押されたボタンがどのボタンなのかを識別します。when文の書き方はさすがに文章では説明しきれないので僕の口頭の説明を聞くかググってください。
        when(v?.id){
            // 押されたボタンのid(先ほど自分たちで画面を作るときに決めたものです)が「button_minus」のときの処理
            R.id.button_minus -> {
                //「number」に保存している値を1減らします(=1引きます)
                number -= 1
                // TextView「textView_number」に表示される文字を「number」の値にします。toStringで「number」の値を文字列(=String)にします。
                textView_number.text = number.toString()
                // ログに出力します。なくても実際のアプリの動作には影響しません。ただ今後もっと高度な処理を書いていくとき、これを使うことでバグがあるときその箇所が特定しやすくなります。
                Log.i("INFORMATION","minus")
            }
            // 押されたボタンのidが「button_plus」のときの処理
            R.id.button_plus -> {
                //「number」に保存している値を1増やします(=1足します)
                number += 1
                // 先ほどと同様にTextView「textView_number」に表示される文字を「number」の値にします。
                textView_number.text = number.toString()
                // ログに出力します。
                Log.i("INFORMATION","plus")
            }
        }
    }
}
