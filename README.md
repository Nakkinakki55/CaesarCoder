# CaesarCoder(暗号化・復号化アプリ)
このプロジェクトでは、**Kotlinを使用してシーザー暗号による文字列の暗号化・復号化** を行うAndroidアプリを開発します。  
「ひらがな」「カタカナ」「アルファベット大文字・小文字」に対応し、ユーザーが指定した文字数だけシフトさせることで暗号化・復号化を実現します。

---

## 使用技術
| 技術 | 詳細 |
|------|------|
| **開発言語** | Kotlin |
| **開発環境** | Android Studio |

---

## シーザー暗号とは？
**シーザー暗号**（Caesar Cipher）は、古代ローマの皇帝 **ジュリアス・シーザー** によって使用されたとされる暗号方式です。  
この暗号では、文字を一定の数だけ**前後にずらす**ことで、読みづらくするというシンプルな方式を採用しています。
<br>
例えば、「HELLO」という単語を右に **3文字ずらす** と、以下のようになります。
<br>
```txt
H -> K 
E -> H 
L -> O 
L -> O 
O -> R
```
結果として、「HELLO」が「KHOOR」に変換されます。  
**復号化** するときは、同じ数だけ逆方向にずらせば元の文字列に戻ります。

この方法は単純ですが、文字数が少ない場合は簡単に解読されてしまうため、現代の暗号技術ではほぼ使われません。しかし、教育用途や簡易的な暗号メッセージのやり取りに利用されることがあります。  

---

## インストール方法
### 1. リポジトリをクローン
```txt
git clone https://github.com/Nakkinakki55/CaesarCoder.git
cd CaesarCoder
```

## 使い方
1. 文字ずらす にずらしたい数を入力
2. 「暗号化」ボタン を押すと暗号化された文字列が表示
3. 「復号化」ボタン を押すと元の文字列に復元

![image](https://github.com/user-attachments/assets/524bc088-cc26-4a43-91a4-07e9afe97dbf)

---

# CaesarCoder (Encryption/Decryption App)
This project involves developing an Android application using Kotlin to perform string encryption and decryption via the Caesar cipher. The app supports Hiragana, Katakana, and both uppercase and lowercase English alphabets, allowing users to encrypt and decrypt text by shifting characters by a specified number of positions.

---

## Technologies Used
| Technology | Details |
|------|------|
| **Development Language** | Kotlin |
| **Development Environment** | Android Studio |

---

## What is the Caesar Cipher?
The Caesar Cipher is an encryption method said to have been used by Julius Caesar, an ancient Roman emperor. This cipher employs a simple technique of shifting letters forward or backward by a fixed number of positions to make them unreadable.
<br>
For example, if you shift the word "HELLO" 3 characters to the right, it becomes:
<br>
```txt
H -> K 
E -> H 
L -> O 
L -> O 
O -> R
```
As a result, "HELLO" is transformed into "KHOOR". To decrypt it, you simply shift the characters back by the same number of positions.

While this method is straightforward, it can be easily deciphered if the number of characters is small, making it rarely used in modern cryptography. However, it can still be employed for educational purposes or for simple encrypted messages. 

---

## Installation
### 1. Clone the Repository
```txt
git clone https://github.com/Nakkinakki55/CaesarCoder.git
cd CaesarCoder
```

## Usage
1. Enter the desired shift amount in "文字ずらす" (Shift Characters).
2. Tap the "暗号化" (Encrypt) button to display the encrypted string.
3. Tap the "復号化" (Decrypt) button to restore the original string.

![image](https://github.com/user-attachments/assets/524bc088-cc26-4a43-91a4-07e9afe97dbf)



