package fr.cnam.tp9.Printer;

import fr.cnam.tp9.specification.printer.Printer;

import java.io.PrintStream;

public abstract class AbsPrinter implements Printer {
    protected PrintStream printerOutPort;

    public AbsPrinter(PrintStream a_outStram) {
        this.printerOutPort = a_outStram;
    }
}
