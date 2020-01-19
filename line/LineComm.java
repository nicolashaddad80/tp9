package fr.cnam.tp9.line;


import fr.cnam.tp9.command.Command;

public abstract class  LineComm implements Command {

    protected Line line;

    @Override
    public boolean isCancellable() {
        return true;
    }

    public LineComm(Line a_Line){
        line=a_Line;
    }

    public void setLine(Line a_Line){
        this.line=a_Line;
    }
}
