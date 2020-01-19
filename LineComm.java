package fr.cnam.tp9;


public abstract class  LineComm implements Command {

    protected Line line;

    @Override
    public boolean isCancellable() {
        return true;
    }

    public LineComm(Line a_Line){
        line=a_Line;
    }

}
