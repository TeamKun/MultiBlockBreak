# MultiBlockBreak
１ブロック壊すと複数壊れるプラグイン
minecraft 1.16.5

### コマンド

* multiblockbreak
 * start
 * stop
 * addPlayer
   * <selector>
 * removePlayer
   * <selector>
 * config
   * show
    * set
      * \<configItem>
        * \<value>

### 設定項目

* minRadius\<Integer> (4)
* maxRadius\<Integer> (8)
壊れるブロックの範囲
minとmaxの間からランダムに半径が選択される
* numberOfExecutionsPerSec\<Integer> (25000)
1秒間辺りに処理されるブロック数
* shouldBlockTriggerEffect\<Boolean> (false)
ブロックが壊れる時のエフェクトを表示するか否か
* couldHappenAccident\<Boolean> (true)
暴発するか否か
* accidentProbability\<Double> (1.0)
暴発の確率(1.0は1.0%)
* accidentRadius\<Integer> (16)
暴発時の半径
* exceptCreativePlayer\<Boolean> (false)
クリエイティブモードのプレイヤーがブロックを壊した時,周りのブロックが壊れないようにするか否か
* shouldItemDrop\<Boolean> (false)
  壊れたブロックからアイテムがドロップするか否か
