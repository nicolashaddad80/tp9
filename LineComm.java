package fr.cnam.tp9;


public abstract class  LineComm implements Command {

    protected Line line;

    public LineComm(Line a_Line){
        line=a_Line;
    }

}
