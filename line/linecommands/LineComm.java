package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.command.Command;
import fr.cnam.tp9.line.Line;

public abstract class  LineComm implements Command {

    protected Line line;

    @Override
    public final boolean isCancellable() {
        return true;
    }

    public LineComm(Line a_Line){
        line=a_Line;
    }

    public void setLine(Line a_Line){
        this.line=a_Line;
    }
}
