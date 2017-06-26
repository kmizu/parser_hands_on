# IntelliJ IDEAを使う場合

* IntelliJ IDEAの導入
  * https://www.jetbrains.com/idea/download/
  * OSによってリンク先の指示に従ってインストールする
* Mavenプラグインの導入
  * インストールの設定次第ではすでに導入済み
  1. ツールバー[ファイル]→[設定]→[Plugins]
     * OS X: [IntelliJ IDEA]→[設定]→[Plugins].
  2. 検索欄から「Maven Integration」にチェックを入れて[OK]で閉じる
  3. IntelliJ IDEを再起動する
* Mavenを実行する
  * プロジェクトを右クリック

# 端末を使う場合

mvnコマンド(Maven)が入っている状態で、

```sh
$ mvn compile # コンパイル
```
