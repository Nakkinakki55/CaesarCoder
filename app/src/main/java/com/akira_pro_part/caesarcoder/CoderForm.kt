package com.akira_pro_part.caesarcoder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class CoderForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coder_form)

        //----------------------------------------------------------------
        //オブジェクト
        //----------------------------------------------------------------
        
        //文字入力欄
        val editInput = findViewById<EditText>(R.id.txtHirabunn)
        
        //数値入力欄
        val editNum = findViewById<EditText>(R.id.txtNum)
        
        //文字出力欄
        val editOutput = findViewById<EditText>(R.id.txtFukubunn)

        //暗号ボタン
        val btnAngou = findViewById<Button>(R.id.btnAngou)
        
        //復号ボタン
        val btnFukugou = findViewById<Button>(R.id.btnFukugou)

        //----------------------------------------------------------------

        
        
        
        
        
        //----------------------------------------------------------------
        //文字列
        //----------------------------------------------------------------
        //日本語　文字列
        var strHiragana = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽぁぃぅぇぉっゃゅょゎ"
        var strKatakana="アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポァィゥェォッャュョヮ"
        //英語　文字列
        var strEigoOmoji = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var strEigoKomoji="abcdefghijklmnopqrstuvwxyz"
        //----------------------------------------------------------------


        
        
        //----------------------------------------------------------------
        //暗号ボタンクリックイベント
        //----------------------------------------------------------------
        btnAngou.setOnClickListener {
            //文字数入力欄 空白判定
            if (editNum.text.isNullOrBlank()) {
                //エラーメッセージ
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("「文字ずらす」入力欄に1以上100以下の数字を入力してください")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()

                //処理抜ける
                return@setOnClickListener
            }


            //文字数入力欄に数値が入っているか判定
            if (editNum.text.toString().toIntOrNull() == null) {
                //エラーメッセージ
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("「文字ずらす」入力欄に1以上100以下の数字を入力してください")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()

                //処理抜ける
                return@setOnClickListener
            }

            //数値が書かれている文字を数値変換にして変数にする
            val intNum = editNum.text.toString().toIntOrNull()

            //数値入力欄に1-100が入っているか判定
            if (intNum != null) {
                if (intNum < 1 || intNum > 100) {

                    AlertDialog.Builder(this)
                        .setTitle("ERROR！")
                        .setMessage("「文字ずらす」入力欄に1以上100以下の数字を入力してください")
                        .setPositiveButton("OK") { dialog, which -> }
                        .show()

                    //処理抜ける
                    return@setOnClickListener
                }
            }

            //文字入力欄の空白判定
            if (editInput.text.isNullOrBlank()) {
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("「ひらがな　カタカナ～」入力欄に文字を入力してください")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()

                //処理抜ける
                return@setOnClickListener
            }

            //文字型変数に入力欄の内容を代入する
            var strEditHirabunnConvert = editInput.text.toString()

            //出力欄を空白にする
            editOutput.setText("");

            var strMojiLineForEdit = ""

            //入力欄の文字数をカウント
            var intSizeNum: Int? = strEditHirabunnConvert?.length

            //入力欄の文字を一文字ずつ判定する
            if (intSizeNum != null) {
                for (i in 0..(intSizeNum - 1)) {

                    var charMoji = ""
                    
                    //文字を取得する
                    var strHitomoji = strEditHirabunnConvert[i].toString()

                    //取得した文字がひらがなの場合
                    if (strHiragana.contains(strHitomoji)) {
                        //暗号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = AngouKa(strHitomoji, strHiragana, intNum)
                        }
                    }
                    //取得した文字がカタカナの場合
                    else if (strKatakana.contains(strEditHirabunnConvert[i])) {
                        //暗号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = AngouKa(strHitomoji, strKatakana, intNum)
                        }

                    }
                    //取得した文字が英語大文字の場合
                    else if (strEigoOmoji.contains(strEditHirabunnConvert[i])) {
                        //暗号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = AngouKa(strHitomoji, strEigoOmoji, intNum)
                        }

                    }
                    //取得した文字が英語小文字の場合
                    else if (strEigoKomoji.contains(strEditHirabunnConvert[i])) {
                        //暗号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = AngouKa(strHitomoji, strEigoKomoji, intNum)
                        }
                    }
                    //取得した文字がひらがな、カタカナ、英文字以外の場合
                    else{
                        charMoji=strEditHirabunnConvert[i].toString()
                    }
                    //暗号化した文字を文字列に結合する
                    strMojiLineForEdit = strMojiLineForEdit + charMoji
                }
            }

            //暗号化した文字を表示する
            editOutput.setText(strMojiLineForEdit);
        }
        //----------------------------------------------------------------

        
        
        
        
        

        //----------------------------------------------------------------
        //復号ボタンクリックイベント
        //----------------------------------------------------------------
        btnFukugou.setOnClickListener {
            //数値入力欄 空白判定
            if (editNum.text.isNullOrBlank()) {
                //エラーメッセージ
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("「文字ずらす」入力欄に1以上100以下の数字を入力してください")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()

                //処理抜ける
                return@setOnClickListener
            }


            //数値入力欄に数値が入っているか
            if (editNum.text.toString().toIntOrNull() == null) {

                //エラーメッセージ
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("「文字ずらす」入力欄に1以上100以下の数字を入力してください")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()

                //処理抜ける
                return@setOnClickListener
            }

            //数値入力欄を数値変換にして変数にする
            val intNum = editNum.text.toString().toIntOrNull()

            //数値入力欄に1以上100以下の値がない場合
            if (intNum != null) {
                if (intNum < 1 || intNum > 100) {

                    AlertDialog.Builder(this)
                        .setTitle("ERROR！")
                        .setMessage("「文字ずらす」入力欄に1以上100以下の数字を入力してください")
                        .setPositiveButton("OK") { dialog, which -> }
                        .show()

                    //処理抜ける
                    return@setOnClickListener
                }
            }


            //文字入力欄の空白判定
            if (editInput.text.isNullOrBlank()) {
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("「ひらがな　カタカナ～」入力欄に文字を入力してください")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()

                //処理抜ける
                return@setOnClickListener
            }

            //文字入力欄の値を文字型変数代入
            var strEditHirabunnConvert = editInput.text.toString()

            //出力欄を空白にする
            editOutput.setText("");

            var strMojiLineForEdit = ""

            //文字入力欄の文字数をカウント
            var intSizeNum: Int? = strEditHirabunnConvert?.length

            //入力欄の文字を一文字ずつ判定する
            if (intSizeNum != null) {
                for (i in 0..(intSizeNum - 1)) {
                    //一文字ずつ英語文と日本語文にあるか判定

                    var charMoji = ""
                    var strHitomoji = strEditHirabunnConvert[i].toString()

                    //取得した文字がひらがなの場合日本語にある場合
                    if (strHiragana.contains(strHitomoji)) {
                        //復号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = Fukugou(strHitomoji, strHiragana, intNum)
                        }
                    }
                    //取得した文字がカタカナの場合
                    else if (strKatakana.contains(strEditHirabunnConvert[i])) {
                        //復号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = Fukugou(strHitomoji, strKatakana, intNum)
                        }

                    }
                    //取得した文字が英語大文字の場合
                    else if (strEigoOmoji.contains(strEditHirabunnConvert[i])) {
                        //復号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = Fukugou(strHitomoji, strEigoOmoji, intNum)
                        }

                    }
                    //取得した文字が英語小文字の場合
                    else if (strEigoKomoji.contains(strEditHirabunnConvert[i])) {
                        //復号化メソッド呼ぶ
                        if (intNum != null) {
                            charMoji = Fukugou(strHitomoji, strEigoKomoji, intNum)
                        }

                    }
                    //取得した文字がひらがな、カタカナ、英文字以外の場合
                    else{
                        charMoji=strEditHirabunnConvert[i].toString()
                    }

                    //復号化した文字を文字列に結合する
                    strMojiLineForEdit = strMojiLineForEdit + charMoji
                }
            }

            //復号化した文字を表示する
            editOutput.setText(strMojiLineForEdit);
        }
    }
//----------------------------------------------------------------


}


//----------------------------------------------------------------
//暗号化メソッド
fun  AngouKa(strMoji: String, strHiragan: String, intNumEdit: Int):String {

    //一致している文字の場所を探す
    //場所を変数に格納する
    val intNumPlace:Int=strHiragan.indexOf(strMoji)

    //数値格納用変数
    var intNumForString=0;

    //文字数をカウントする
    val intSize=strHiragan.length


    if(intSize<intNumPlace+1+intNumEdit) {
        intNumForString=(intNumPlace+intNumEdit)%intSize
    }
    else {
        intNumForString=intNumPlace+intNumEdit
    }

    //戻り値　暗号化した文字
    return strHiragan[intNumForString].toString()

}
//----------------------------------------------------------------

//----------------------------------------------------------------
//復号化メソッド
fun  Fukugou(strMoji: String, strHiragan: String, intNumEdit: Int):String {


    //文字を反転する
    val str: StringBuffer = StringBuffer(strHiragan)
    val strRevese = str.reverse().toString()
    val intNumPlace:Int=strRevese.indexOf(strMoji)

    //数値格納用変数
    var intNumForString=0;
    val intSize=strRevese.length


    if(intSize<intNumPlace+1+intNumEdit) {
        intNumForString=(intNumPlace+intNumEdit)%intSize
    }
    else {
        intNumForString=intNumPlace+intNumEdit
    }

    //戻り値　　復号化した文字
    return strRevese[intNumForString].toString()
}
//----------------------------------------------------------------


