package ch04.ex03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *ほとんどがデフォルトから変化しない多くのjavaFXプロパティを持つクラスを考えなさい、
 *デフォルトでない値が設定されたり、xxxproperty()メソッドが最初に呼び出された時に 
 *要求に応じてプロパティを構築する方法を示しなさい。 
 * 
 */
public class Property {

    private final String defaultText = "sample";
    private StringProperty textProp = null;

    public final StringProperty textProperty() {
        if (textProp == null) {
            textProp = new SimpleStringProperty(defaultText);
        }
        return textProp;
    }

    public final void setText(String newValue) {
        if (textProp != null) {
            textProp.set(newValue);
        } else if (!defaultText.equals(newValue)) {
            textProp = new SimpleStringProperty(newValue);
        }
    }

    public final String getText() {
        return textProp != null ? textProp.get(): defaultText;
    }
}
