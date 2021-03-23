// package文でこのプログラムがどの組織に所属するのかを区別します。世界にはたくさんのプログラムがあるのでこうでもしないと同一名のプログラムが生まれてしまい区別できないのです。
// 僕らの場合は聖光学院がseiko.ac.jpなので本番では「jp.ac.seiko」というドメインでアプリを作成します。
// 1packageで1つのアプリを構成します。いくつかあるkotlinのプログラムの単位の中ではpackageが最大の単位になります。
package com.example.for63rd

// import文によって(Android作成元であるGoogleが作った)必要なプログラムをロードします。自分で書けなくてもAndroidStudioが勝手に保管してくれるのでそこまで気にしなくてOKです。
// もう少し抽象的に説明すると、「import文によって他のpackageを読み込んでいる。」ということになります
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

// classはプログラムの1単位(packageの次に大きいです)ですが初心者が1日目で学ぶにはあまりにも難しい
// (完全な理解は僕も3カ月かかりました。ちなみに初めて理解できた時は悟ったような気分になります)ので今回は触れません。
// classを用いてプログラミングをしていくプログラミング言語を「オブジェクト指向言語」と言います。対義語はC言語などに代表される「手続き指向言語」です。
// オブジェクト指向の解説の部分には☆マークを付けておきました。余裕があれば読んでもいいですが今回はわからなくて結構です。
class MainActivity : AppCompatActivity() ,View.OnClickListener{

    // 整数をいれる「number」という名前の箱を作成します(=コンピューターのメモリを確保します)。最初の値は0にしています(慣習です)。
    // この「number」のようなものを「変数」と呼びます。変数には値を保存することができて、すべてのプログラムは究極的にはこの変数の操作に帰着します。
    var number : Int = 0

    // onCreateに囲まれた箇所(26から57行目)はActivityが作られるときに最初に実行されます。
    // ☆このようにfunというキーワードで始まるコードの単位をメソッドといいます。
    override fun onCreate(savedInstanceState: Bundle?) {
        // このダブルスラッシュから始まる行のことをコメントといいます。ここはコンピューターには無視されるので好きに書いてOK。もちろん書かなくてもいいです。
        // 今回はこのソースコードの内容の説明を書いているので僕の口頭での説明が分かんなくなったらここを読んでくれればわかると思います。もちろん分からなかったら気軽に質問してください。

        /* こんな感じでスラッシュとコメ印で囲むことで
        複数行にわたる
        コメントを書くこともできます。(ダブルスラッシュは1行のコメントしか書けません)
        基本的にコメントは自分や他人がこのプログラムを見たときにこれ何してるんだっけとならないように書くメモのようなものです。
        先ほどのダブルスラッシュ(1行だけならそのほうが見やすいとされています)と読みやすいほうを使い分けましょう。
        今回は皆さんが分かりやすいようにとんでもない量を書いていますが普通はわかりづらい箇所に簡単なメモを書く程度です。
        */

        /**
         * これはJavaDoc式の書き方のコメントです。仕様説明の時に用いられ、可読性が高いです。
         * @pram とすると引数(未解説)の情報がかけたりします。
         * いろいろなコメントの書き方があるのでここ参照してください。https://qiita.com/mtanabe/items/2e52e6e162d28df8437f
         * 他には//TODOによるTODOコメント、//XXXコメントなど多様なものがあります。
         */

        // 下の2行はデフォルトであると思います。この2行では画面を作成する処理をしています。ほとんどの場合(最低でも皆さんが担当するレベル)ではここはデフォルトで存在するので書けなくてOKです。
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // この1行で先ほど作成したtextViewに最初に表示する文字を指定しています。(ここは最初に実行される個所なのでここで指定したものが最初に表示されます。)
        textView_number.text = "0"

        // この2行でボタンにOnClickListenerをsetします(そのままですね)。OnClickListenerがsetされたViewがClickされると参照先のonClickイベントが実行されます。
        // 今回は「this」なので60行目から始まるonClick()が実行されます。
        // ☆ここまでにも何回か登場していますが、「メソッド名(引数)」の形でメソッドの実行をすることができます。
        button_minus.setOnClickListener(this)
        button_plus.setOnClickListener(this)
    }

    // ここ以降のonClick()メソッドは先ほどonClickListenerがsetされたボタンが押された際に実行されます。
    override fun onClick(v: View?) {
        // when文によって押されたボタンがどのボタンなのかを識別します。when文の書き方はさすがに文章では説明しきれないので僕の口頭の説明を聞くかググってください。
        when(v?.id){
            // 押されたボタンのid(先ほど自分たちで画面を作るときに決めたものです)が「button_minus」のときの処理
            R.id.button_minus -> {
                // 「number」に保存している値を1減らします(=1引きます)
                number -= 1
                // TextView「textView_number」に表示される文字を「number」の値にします。toStringで「number」の値を文字列(=String)にします。
                textView_number.text = number.toString()
                // ログに出力します。なくても実際のアプリの動作には影響しません。ただ今後もっと高度な処理を書いていくとき、これを使うことでバグがあるときその箇所が特定しやすくなります。
                Log.i("INFORMATION","minus")
            }
            // 押されたボタンのidが「button_plus」のときの処理
            R.id.button_plus -> {
                // 「number」に保存している値を1増やします(=1足します)
                number += 1
                // 先ほどと同様にTextView「textView_number」に表示される文字を「number」の値にします。
                textView_number.text = number.toString()
                // ログに出力します。
                Log.i("INFORMATION","plus")
            }
        }
    }
}
