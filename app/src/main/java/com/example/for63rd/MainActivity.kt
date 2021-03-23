package com.example.for63rd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    //整数をいれる「number」という名前の箱を作成します(=コンピューターのメモリを確保します)。最初の値は0にしています(慣習です)。
    var number : Int = 0

    //onCreateに囲まれた箇所(15から37行目)はActivityが作られるときに最初に実行されます。
    override fun onCreate(savedInstanceState: Bundle?) {
        //このダブルスラッシュから始まる行のことをコメントといいます。ここはコンピューターには無視されるので好きに書いてOK。もちろん書かなくてもいいです。
        // 今回はこのソースコードの内容の説明を書いているので僕の口頭での説明が分かんなくなったらここを読んでくれればわかると思います。もちろんわかんなかったら気軽に質問してください。

        /*こんな感じでスラッシュとコメ印で囲むことで
        複数行にわたる
        コメントを書くこともできます。(ダブルスラッシュは1行のコメントしか書けません)
        基本的にコメントは自分や他人がこのプログラムを見たときにこれ何してるんだっけとならないように書くメモのようなものです。
        先ほどのダブルスラッシュ(1行だけならそののほうが見やすいとされています)と読みやすいほうを使い分けましょう。
        今回は皆さんが分かりやすいようにとんでもない量を書いていますが普通はわかりづらい箇所に簡単なメモを書く程度です。
        */

        //下の2行はデフォルトであると思います。この2行では画面を作成する処理をしています。ほとんどの場合(最低でも皆さんが担当するレベル)ではここはデフォルトで存在するので書けなくてOKです。
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //この1行で先ほど作成したtextViewに最初に表示する文字を指定しています。(ここは最初に実行される個所なのでここで指定したものが最初に表示されます。)
        textView_number.text = "0"

        //この2行でボタンにOnClickListenerをsetします(そのままですね)。OnClickListenerがsetされたViewがClickされると参照先のonClickイベントが実行されます。
        //今回は「this」なので38行目から始まるonClick()が実行されます。
        button_minus.setOnClickListener(this)
        button_plus.setOnClickListener(this)
    }

    //ここ以降のonClick()メソッドは先ほどonClickListenerがsetされたボタンが押された際に実行されます。
    override fun onClick(v: View?) {
        //when文によって押されたボタンがどのボタンなのかを識別します。when文の書き方はさすがに文章では説明しきれないので僕の口頭の説明を聞くかググってください。
        when(v?.id){
            //押されたボタンのid(先ほど自分たちで画面を作るときに決めたものです)が「button_minus」のときの処理
            R.id.button_minus -> {
                //「number」に保存している値を1減らします(=1引きます)
                number -= 1
                //TextView「textView_number」に表示される文字を「number」の値にします。toStringで「number」の値を文字列(=String)にします。
                textView_number.text = number.toString()
                //ログに出力します。なくても実際のアプリの動作には影響しません。ただ今後もっと高度な処理を書いていくとき、これを使うことでバグがあるときその箇所が特定しやすくなります。
                Log.i("INFORMATION","minus")
            }
            //押されたボタンのidが「button_plus」のときの処理
            R.id.button_plus -> {
                //「number」に保存している値を1増やします(=1足します)
                number += 1
                //先ほどと同様にTextView「textView_number」に表示される文字を「number」の値にします。
                textView_number.text = number.toString()
                //ログに出力します。
                Log.i("INFORMATION","plus")
            }
        }
    }
}
