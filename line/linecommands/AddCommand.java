package fr.cnam.tp9.line.linecommands;

import fr.cnam.tp9.line.specification.Line;
import java.util.Scanner;

public abstract class AddCommand extends LineComm {

    public AddCommand( Line a_Line ) {
        super(a_Line);
    }

    protected char getCarToInsert( ){

        Scanner myCharReader = new Scanner(System.in);
        System.out.println("Tapez le caractere a rajouter");
        return myCharReader.next().charAt(0);
    }

}