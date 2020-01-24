package fr.cnam.tp9.menu.menucommands;

import fr.cnam.tp9.command.specification.Command;

public class NoopCommand implements Command {

    @Override
    public void executer(){
    }

    @Override
    public final boolean isCancellable() {
        return false;
    }

    @Override
    public  boolean isExecutable(){
        return true;
    }

}
