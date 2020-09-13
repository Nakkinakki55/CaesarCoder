package com.akira_pro_part.caesarcoder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart = findViewById<Button>(R.id.button)
        // ボタンタップ時の処理を指定する
        btnStart.setOnClickListener {
            // Intentを作成する
            val intent = Intent(this, CoderForm::class.java)
            // パラメータをセットする
            // 画面を遷移させる
            startActivity(intent)

            //画面を閉じる
            finish()
        }

    }
}