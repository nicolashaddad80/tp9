package fr.cnam.tp9;

import fr.cnam.tp9.editor.Heditor;
import fr.cnam.tp9.line.LineTab;
import fr.cnam.tp9.printer.Printer;

public class EditorTest {

    public static void main(String[] Args) {
        new Heditor(new LineTab(), new Printer(System.out)).editer();
    }
}