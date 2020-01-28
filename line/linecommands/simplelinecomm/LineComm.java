package fr.cnam.tp9.line.linecommands.simplelinecomm;


import fr.cnam.tp9.line.specification.Line;
import fr.cnam.tp9.command.specification.Command;

public abstract class LineComm implements Command {

    protected static Line line;


    public LineComm( Line a_Line ) {
        LineComm.line = a_Line;
    }


}

