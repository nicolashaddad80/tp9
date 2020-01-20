package fr.cnam.tp9.line.linecommands;

import fr.cnam.tp9.line.Line;

public class AddAfterCommand extends AddCommand {


    public AddAfterCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer(){
        line.addAfter(this.getCarToInsert());
    }

    @Override
    public final boolean isExecutable(){
        return this.line.getCursorPos()>0;
    }
}
