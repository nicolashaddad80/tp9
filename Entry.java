package fr.cnam.tp9;


public class Entry implements MenuComponent {

    private String text;
    private Command command;

    public Entry(String a_text, Command a_Command) {

        this.text = a_text;
        this.command = a_Command;

    }

    public Command getCommand() {
        return this.command;
    }

    public String toString() {
        return this.text;
    }
}
