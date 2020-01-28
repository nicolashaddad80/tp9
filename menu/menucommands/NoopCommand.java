package fr.cnam.tp9.menu.menucommands;

import fr.cnam.tp9.command.specification.Cancelable;
import fr.cnam.tp9.command.specification.Command;

public class NoopCommand implements Cancelable {

    @Override
	public void executer( ){
    }


    @Override
	public boolean isExecutable( ){
        return true;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }

    @Override
    public void undo() {

    }
}
