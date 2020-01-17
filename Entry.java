package fr.cnam.tp9;


public class Entry extends CommonMenuComponent {

    private Command command;
    public Entry(String a_text,Command a_Command){

        super(a_text);
        this.command=a_Command;

    }

    public Command getCommand(){
        return this.command;
    }


}
