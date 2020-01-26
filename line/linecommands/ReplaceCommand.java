package fr.cnam.tp9.line.linecommands;

import fr.cnam.tp9.line.specification.Line;

public class ReplaceCommand extends AddCommand {


    public ReplaceCommand( Line a_Line ) {
        super(a_Line);
    }

    public void executer( ) {
        line.replace(this.getCarToInsert());
        line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return this.line.getCursorPos()>0;
    }
}