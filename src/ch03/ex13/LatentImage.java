
package ch03.ex13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import ch03.ex11.ColorTransfomer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * ぼやけ検出、あるいは、エッジ検出といった畳み込みフィルターは、隣接するピクセル から1
 * つのピクセルを計算します。画像をぼやかすためには、ピクセルとその隣接する 8 個のピクセルの平均で、個々の色値を置き換えます。エッジ検出には、個々の色値c
 * を 4c − n − e − s − w で置き換えます。ここで、他の色は、北（north）、東（east）、南
 * （south）、西（west）のピクセルの色値です。これは、69 ページの3.6 節「遅延」で説明
 * された方法を用いた遅延では実装できないことに注意してください。なぜなら、計算する
 * ために、前段の画像（あるいは、少なくとも隣接するピクセル）が必要だからです。これ らの操作を扱うために遅延画像処理の機能を強化しなさい。これらの演算の1
 * つが評価さ れる際に、前段の計算が強制されるようにしなさい。
 */
public class LatentImage {
	
//分かりません

}
