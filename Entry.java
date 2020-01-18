package fr.cnam.tp9;


public class Entry implements MenuComponent {
    private String text;
    private Command command;
    public Entry(String a_text,Command a_Command){

        this.text = a_text;
        this.command=a_Command;

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
        return this.text;
    }


}
