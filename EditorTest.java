package fr.cnam.tp9;

import fr.cnam.tp9.editor.SimpleEditor;
import fr.cnam.tp9.line.specification.Line;
import fr.cnam.tp9.line.LineTab;
import fr.cnam.tp9.editor.specification.Editor;



public class EditorTest {

    public static void main( String[] Args )
    {
        Line line1=new LineTab(System.out);
        Editor myEditor1= (Editor) new SimpleEditor(line1,System.out);
        myEditor1.editer();
    }
}