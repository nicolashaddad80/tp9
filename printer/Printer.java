package fr.cnam.tp9.printer;

import java.io.PrintStream;

public class Printer{

    PrintStream output;

    public Printer(PrintStream a_Output){
        this.output=a_Output;
    }

    public void print(String a_StringToPrint){

        this.output.print(a_StringToPrint);
    }


}
