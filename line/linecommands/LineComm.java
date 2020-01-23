package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.specification.command.Cancelable;
import fr.cnam.tp9.specification.command.Command;
import fr.cnam.tp9.specification.line.Line;

public abstract class  LineComm implements Command, Cancelable <Line> {

    protected Line line;


    public LineComm(Line a_Line) {
        line = a_Line;
    }


    @Override
    public final boolean isCancellable() {
        return true;
    }

    @Override
    public void restoreContext(Line previousContext) {
        this.line = previousContext;
    }
}

