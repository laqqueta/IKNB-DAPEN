package id.go.ojk.client.util.states;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class JenisProgramState {
    public static String selectedValue = "";
    public static String selectedKey = "";
    public static final BooleanProperty validationState = new SimpleBooleanProperty(false);
    public static String program = "";
    public static long periodePelaporan = 0;
}
