package fr.cnam.tp9;

import java.util.Stack;

public class LineCommandHistory implements CommandHistory{

    private Stack<Line> linesStack;
    public  LineCommandHistory(){
        this.linesStack= new Stack<Line>();
   }

    @Override
    public void push(Line a_Line) {
        this.linesStack.push(a_Line);
    }

    @Override
    public Line pull() {
        return this.linesStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.linesStack.isEmpty();
    }
}
