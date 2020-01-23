package fr.cnam.tp9;



import fr.cnam.tp9.specification.editor.Editor;
import fr.cnam.tp9.specification.editor.HisEditor;
import fr.cnam.tp9.specification.line.Line;

import fr.cnam.tp9.editor.HistoryEditor;
import fr.cnam.tp9.line.LineTab;


public class EditorTest {

    public static void main(String[] Args)
    {
        Line line1=new LineTab(System.out);
        Editor myEditor1= (Editor) new HistoryEditor(line1,System.out);
        myEditor1.editer();
    }
}