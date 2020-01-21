package fr.cnam.tp9;

import fr.cnam.tp9.editor.Heditor;
import fr.cnam.tp9.line.Line;
import fr.cnam.tp9.line.LineTab;


public class EditorTest {

    public static void main(String[] Args)
    {
        Line line1=new LineTab(System.out);
        Heditor myEditor1=new Heditor(line1,System.out);
        myEditor1.editer();
    }
}