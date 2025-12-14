# UTF-8 Encoder (Java)

## 概要
このプロジェクトは、**Unicodeの符号位置（U+0800 ～ U+FFFF）をUTF-8の3バイト表現に変換する**  
シンプルなJavaプログラムです。

情報処理技術者試験（IPA）でよく出題される  
**UTF-8エンコードのアルゴリズム理解**を目的として実装しています。

---

## 機能
- UnicodeコードポイントをUTF-8（3バイト）に変換
- UTF-8バイト列を **16進数（HEX）** で表示
- UTF-8バイト列を **2進数（BINARY）** で表示
- アルゴリズムは試験問題の疑似コードに忠実

---

## 実行環境
- Java 8 以上

---

## 使い方

### 1. コンパイル
```bash
javac Utf8Encoder.java
2. 実行
bash
Sao chép mã
java Utf8Encoder
実行例
入力（Unicodeコードポイント）：

java
Sao chép mã
0x3042  // 「あ」
出力：
![Uploading image.png…]()

text
Sao chép mã
UTF-8 (HEX):
E3 81 82

UTF-8 (BINARY):
11100011
10000001
10000010
アルゴリズム説明
UTF-8（3バイト）のビット構造は以下の通りです：

1110xxxx 10xxxxxx 10xxxxxx
下位から6ビットずつ取り出すために mod 64 を使用

右シフトの代わりに 除算（/ 64） を使用

各バイトの先頭ビットは初期値で設定

int[] utf8Bytes = {224, 128, 128};
utf8Bytes[i] += cp % 64;
cp = cp / 64;
学習目的
UTF-8エンコードの仕組みをビット単位で理解する

情報処理技術者試験（IPA）のアルゴリズム問題対策

Javaによるビット演算・数値処理の練習
