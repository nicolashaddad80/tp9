package fr.cnam.tp9;


public class Entry implements MenuComponent {
    protected String text;
    private Command command;
    private String shortcut;
    public Entry(String a_text,Command a_Command,String a_Shortcut){

        this.text = a_text;
        this.command=a_Command;
        this.shortcut=a_Shortcut;
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
        return (this.text+"\t\t["+this.shortcut+"]");
    }


}
