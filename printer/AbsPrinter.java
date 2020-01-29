package fr.cnam.tp9.printer;

import java.io.PrintStream;
import fr.cnam.tp9.printer.specification.Printer;

public abstract class AbsPrinter implements Printer {
    protected final PrintStream printerOutPort;

    public AbsPrinter( PrintStream a_outStram ) {
        this.printerOutPort = a_outStram;
    }
}
