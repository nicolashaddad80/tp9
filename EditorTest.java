package fr.cnam.tp9;

import fr.cnam.tp9.editor.Heditor;
import fr.cnam.tp9.line.LineTab;

public class EditorTest {

    public static void main(String[] Args)
    {
        Heditor myEditor1;
        LineTab line1=new LineTab();
        myEditor1=new Heditor(line1);
        myEditor1.editer();
    }
}