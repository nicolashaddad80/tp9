package fr.cnam.tp9;

public class LineCommandHistory implements CommandHistory{

    Line previousLine;

    public  LineCommandHistory(){

   }

    @Override
    public void push(Line a_Element) {
        this.previousLine=a_Element;
    }

    @Override
    public Line pull() {
        return this.previousLine;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
