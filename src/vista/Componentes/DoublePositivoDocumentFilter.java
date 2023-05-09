/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Componentes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author netom
 */
public class DoublePositivoDocumentFilter extends DocumentFilter {
    private int limite;

    public DoublePositivoDocumentFilter(int limite) {
        this.limite = limite;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
            AttributeSet attrs) throws BadLocationException {
        String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
        if (esDoublePositivo(newValue) && newValue.length() <= limite) {
            super.insertString(fb, offset, text, attrs);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
        String newValue = fb.getDocument().getText(0, fb.getDocument().getLength())
                .substring(0, offset)
                + text
                + fb.getDocument().getText(offset + length, fb.getDocument().getLength() - offset - length);
        if (esDoublePositivo(newValue) && newValue.length() <= limite) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean esDoublePositivo(String texto) {
        try {
            double valor = Double.parseDouble(texto);
            return valor >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}