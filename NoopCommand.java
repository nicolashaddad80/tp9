package fr.cnam.tp9;

public class NoopCommand implements Command {

    @Override
    public void executer(){
    }

    @Override
    public  boolean isExecutable(){
        return true;
    }

}
