package fr.cnam.tp9.line.linecommands;


import fr.cnam.tp9.line.specification.ClonableLine;


import java.util.Scanner;

public abstract class CanceAddCommand extends CancelableLinComm {

    public CanceAddCommand(ClonableLine a_Line ) {
        super(a_Line);
    }

    protected char getCarToInsert( ){

        Scanner myCharReader = new Scanner(System.in);
        System.out.println("Tapez un caractere ");
        return myCharReader.next().charAt(0);
    }

}
