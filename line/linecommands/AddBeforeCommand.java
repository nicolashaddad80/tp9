package fr.cnam.tp9.line.linecommands;

import fr.cnam.tp9.line.specification.Line;

public class AddBeforeCommand extends AddCommand {


    public AddBeforeCommand( Line a_Line ) {
        super(a_Line);
    }

    public void executer( ){
        line.addBefore(this.getCarToInsert());
        line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return this.line.getCursorPos()>0;
    }
}
