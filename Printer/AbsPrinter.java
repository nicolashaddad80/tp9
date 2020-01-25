package fr.cnam.tp9.Printer;

import java.io.PrintStream;
import fr.cnam.tp9.Printer.specification.Printer;

public abstract class AbsPrinter implements Printer {
    protected PrintStream printerOutPort;

    public AbsPrinter( PrintStream a_outStram ) {
        this.printerOutPort = a_outStram;
    }
}
