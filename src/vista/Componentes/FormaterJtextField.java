/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Componentes;

import java.util.Arrays;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author netom
 */
public class FormaterJtextField {
        public static void limitarLongitudCampo(JTextField campo, int maxChars) {
        PlainDocument doc = (PlainDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length()) <= maxChars) {
                    super.insertString(fb, offs, str, a);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length() - length) <= maxChars) {
                    super.replace(fb, offs, length, str, a);
                }
            }
        });
    }
        public static boolean validarCurp(String curp) {
    String regex = "[A-Z]{4}[0-9]{6}[H,M][A-Z]{5}[0-9]{2}";

    if (curp == null || !curp.matches(regex)) {
        return false;
    }

    String[] meses = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V"};

    int[] valores = new int[17];
    for (int i = 0; i < 16; i++) {
        char c = curp.charAt(i);
        if (i < 4) {
            valores[i] = c - 'A' + 10;
        } else if (i < 10) {
            valores[i] = c - '0';
        } else {
            valores[i] = Arrays.asList(meses).indexOf(String.valueOf(c));
        }
    }

    int suma = 0;
    for (int i = 0; i < 17; i++) {
        suma += valores[i] * (18 - i);
    }

    int digitoVerificador = 10 - (suma % 10);
    if (digitoVerificador == 10) {
        digitoVerificador = 0;
    }

    return Character.toUpperCase(curp.charAt(17)) == Character.toUpperCase(meses[digitoVerificador].charAt(0));
}
}
