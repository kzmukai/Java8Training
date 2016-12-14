package ch03.ex11;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransfomer {
    Color apply(int x, int y, Color colorAtXY);

   
    default ColorTransfomer compose(ColorTransfomer before) {
        return (x, y, c) -> apply(x, y, before.apply(x, y, c));
    }

    static ColorTransfomer onlyColor(UnaryOperator<Color> op) {
        return (x, y, c) -> op.apply(c);
    }
}