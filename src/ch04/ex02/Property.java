package ch04.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * チャートやテーブルといった多くのJavaFX プロパティを持つクラスを考えなさい。特定
 * のアプリケーションでは、ほとんどのプロパティには決してリスナーが登録されない可
 * 能性が高いです。したがって、プロパティごとにプロパティオブジェクトを持つことは
 * 無駄です。プロパティ値を保存するために最初に普通のフィールドを使用して、初めて xxxProperty()
 * メソッドが呼び出されたときにだけプロパティオブジェクトを使用す るように、要求に応じてプロパティを構築する方法を示しなさい。
 * 
 */
public class Property {

	  private String text = "";
	    private StringProperty textProp = null;
	    
	    public final StringProperty textProperty() {
	        if (textProp == null) {
	            textProp = new SimpleStringProperty(text);
	            text = null;
	        }
	        return textProp;
	    }
	    public final void setText(String newValue) {
	        if (textProp != null) {
	            textProp.set(newValue);
	        } else {
	            text = newValue;
	        }
	    }
	    public final String getText() {
	        return textProp != null ? textProp.get(): text;
	    }
	}
