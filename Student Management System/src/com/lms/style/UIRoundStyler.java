package com.lms.style;

import com.formdev.flatlaf.FlatClientProperties;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author KEHAN HASALAWA
 */
public class UIRoundStyler {

    public static void applyRoundStyleToButtons(List<JButton> buttons) {
        for (JButton button : buttons) {
            button.putClientProperty("JButton.buttonType", "roundRect");
        }
    }

    public static void applyRoundStyleToTextFields(List<? extends JTextField> textFields) {
        for (JTextField textField : textFields) {
            textField.putClientProperty("JComponent.roundRect", true);
            textField.putClientProperty(FlatClientProperties.STYLE, "margin:0,20,0,10");
        }
    }
    
    public static void applyRoundStyleToPasswordFields(List<JPasswordField> passwordFields) {
        for (JPasswordField passwordField : passwordFields) {
            passwordField.putClientProperty("JComponent.roundRect", true);
        }
    }

    public static void applyRoundStyleToComboBoxes(List<JComboBox<?>> comboBoxes) {
        for (JComboBox<?> comboBox : comboBoxes) {
            comboBox.putClientProperty("JComponent.roundRect", true);
        }
    }

    public static void styleComponents(JButton[] buttons, JTextField[] textFields, JFormattedTextField[] formattedTextFields,
            JPasswordField[] passwordFields, JComboBox<?>[] comboBoxes) {
        applyRoundStyleToButtons(Arrays.asList(buttons));
        applyRoundStyleToTextFields(Arrays.asList(textFields));
        applyRoundStyleToPasswordFields(Arrays.asList(passwordFields));
        applyRoundStyleToTextFields(Arrays.asList(formattedTextFields));
        applyRoundStyleToComboBoxes(Arrays.asList(comboBoxes));
    }

}
