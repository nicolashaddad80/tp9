package fr.cnam.tp9.line.linecommands;

import fr.cnam.tp9.line.specification.Line;

public class DeleteAllCommand extends LineComm {

    public DeleteAllCommand( Line a_Line ) {
        super(a_Line);
    }

    public void executer( ) {

        while (this.line.getLength()>0) {
            line.delete();
        }
        line.getPrinter().print();
    }

    @Override
	public final boolean isExecutable( ){
        return this.line.getLength()>0;
    }
}
