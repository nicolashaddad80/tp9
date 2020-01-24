package fr.cnam.tp9.menu;

import fr.cnam.tp9.menu.specification.Entry;
import fr.cnam.tp9.command.specification.Command;

public class EntryImp implements Entry {
    protected String text;
    private Command command;
    private String shortcut;
    private Integer numEntry;

    public EntryImp( int a_NumEntry, String a_text, Command a_Command, String a_Shortcut ){

        this.text = a_text;
        this.command=a_Command;
        this.shortcut=a_Shortcut;
        this.numEntry = a_NumEntry;
    }

    @Override
	public Command getCommand( ){
        return this.command;
    }

    @Override
	public boolean isMenu( ) {
        return false;
    }

    @Override
	public String toString( ){
        return (this.text);

    }

    @Override
	public String getShortcut( ) {
        return this.shortcut;
    }

    @Override
	public Integer getNumber( ) {
        return (this.numEntry);
    }
}
