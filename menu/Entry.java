package fr.cnam.tp9.menu;


import fr.cnam.tp9.command.Command;

public class Entry implements MenuComponent {

    protected static final String ANSI_RESET = "\u001B[0m";
    protected  static final String ANSI_GREEN = "\u001B[32m";
    protected  static final String ANSI_RED = "\u001B[31m";


    protected String text;
    private Command command;
    private String shortcut;
    private Integer numEntry;

    public Entry(int a_NumEntry,String a_text, Command a_Command, String a_Shortcut){

        this.text = a_text;
        this.command=a_Command;
        this.shortcut=a_Shortcut;
        this.numEntry = a_NumEntry;
    }

    @Override
    public Command getCommand(){
        return this.command;
    }

    @Override
    public boolean isMenu() {
        return false;
    }

    @Override
    public String toString(){
        return (this.text+"\t\t["+ANSI_GREEN +this.shortcut+ ANSI_RESET+"]");

    }

    @Override
    public String getShortcut() {
        return this.shortcut;
    }

    @Override
    public Integer getNumber() {
        return (this.numEntry);
    }
}
