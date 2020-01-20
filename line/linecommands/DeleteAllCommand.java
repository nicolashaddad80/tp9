package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.line.Line;

public class DeleteAllCommand extends LineComm {

    public DeleteAllCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {

        while (this.line.getLength()>0) {
            line.delete();
        }
    }

    @Override
    public final boolean isExecutable(){
        return this.line.getLength()>0;
    }
}
