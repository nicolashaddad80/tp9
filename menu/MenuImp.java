package fr.cnam.tp9.menu;

import java.io.PrintStream;

import fr.cnam.tp9.command.specification.Command;
import fr.cnam.tp9.menu.specification.Entry;
import fr.cnam.tp9.printer.AbsPrinter;
import java.util.*;
import fr.cnam.tp9.printer.specification.Printer;
import fr.cnam.tp9.menu.menucommands.*;
import fr.cnam.tp9.menu.specification.Menu;
import fr.cnam.tp9.textformating.TextColor;

public class MenuImp extends EntryImp implements Menu {


    /**
	 * Private classes
	 */
	private class MenuPrinter extends AbsPrinter {


        public MenuPrinter( PrintStream a_MenuPrinterPort ) {
            super(a_MenuPrinterPort);
        }

        @Override
		public void print( ) {
            this.printerOutPort.print(afficher());
        }
    }


    /**
	 * Attributes
	 */
	private Hashtable<Integer,Entry> entree = new Hashtable<Integer,Entry>(20);
    private Hashtable<String,Entry> shortcutTable = new Hashtable<String,Entry>(20);

    private fr.cnam.tp9.menu.MenuImp parent = this;
    private Entry choice = this;
    private fr.cnam.tp9.menu.MenuImp.MenuPrinter menuPrinter;

    public MenuImp( int a_MenuNum, String a_text, String a_Shortcut, PrintStream a_menuOutStream ) {
        super(a_MenuNum, a_text, new NoopCommand(), a_Shortcut);
        this.menuPrinter = new MenuPrinter(a_menuOutStream);
        this.add(new EntryImp(0, "Quitter", new ExitCommand(), "Q"));
    }

    /**
	 * Methods
	 */
	@Override
	public Printer getPrinter( ) {
        return menuPrinter;
    }

    public String afficher( ) {
        String menuElementsString = "--------------------------------------------------------\n\t\t\t\t" + TextColor.GREEN.set + this.text + TextColor.DEFAULT.set + '\n' + "--------------------------------------------------------\n";

        //Exception or Check with if
        Vector sortedEntry = new Vector(entree.keySet());

        //Exception or Check with if
        Collections.sort(sortedEntry);


        Iterator it = sortedEntry.iterator();

        while (it.hasNext()) {
            Integer entryKey = (Integer) it.next();
            Entry entry = entree.get(entryKey);

            if (entryKey.intValue() > 0) {
                if (((Command)entry.getCommand()).isExecutable()) {

                    menuElementsString = menuElementsString + TextColor.GREEN.set + entryKey + TextColor.DEFAULT.set;
                    menuElementsString = menuElementsString + ") " + entry.toString() + "\t\t[" + TextColor.GREEN.set + entry.getShortcut() + TextColor.DEFAULT.set + "]\n";
                } else {
                    menuElementsString = menuElementsString + TextColor.RED.set + "-" + TextColor.DEFAULT.set;
                    menuElementsString = menuElementsString + ") " + entry.toString() + "\t\t[" + TextColor.RED.set + entry.getShortcut() + TextColor.DEFAULT.set + "]\n";

                }

            }

        }

        Collections.reverse(sortedEntry);
        it = sortedEntry.iterator();

        while (it.hasNext()) {
            Integer entryKey = (Integer) it.next();
            Entry entry = entree.get(entryKey);
            if (entryKey.intValue() <= 0) {
                if (entry.getCommand().isExecutable()) {
                    menuElementsString = menuElementsString + TextColor.GREEN.set + entryKey + TextColor.DEFAULT.set;
                    menuElementsString = menuElementsString + ") " + entry.toString() + "\t\t[" + TextColor.GREEN.set + entry.getShortcut() + TextColor.DEFAULT.set + "]\n";
                } else {
                    menuElementsString = menuElementsString + TextColor.RED.set + "-" + TextColor.DEFAULT.set;
                    menuElementsString = menuElementsString + ") " + entry.toString() + "\t\t[" + TextColor.RED.set + entry.getShortcut() + TextColor.DEFAULT.set + "]\n";
                }

            }

        }

        menuElementsString = menuElementsString + "--------------------------------------------------------\n";

        return menuElementsString;
    }

    public Entry proposer( ) {

        System.out.println("Veuillez choisir la commande :");
        boolean ok = false;

        Scanner scanner = new Scanner(System.in);


        while (!ok) {
            Integer choix;
            String shortcut;
            try {
                choix = scanner.nextInt();

                if (this.entree.containsKey(choix) && this.entree.get(choix).getCommand().isExecutable()) {
                    ok = true;
                    this.choice = this.entree.get(choix);
                }

            } catch (InputMismatchException e) {
                try {
                    shortcut = scanner.nextLine();
                    if (this.shortcutTable.containsKey(shortcut)) {
                        Entry tempChoice = this.shortcutTable.get(shortcut);
                        if (tempChoice.getCommand().isExecutable()) {
                            ok = true;
                            this.choice = tempChoice;
                        }
                    }

                } catch (Exception e1) {
                    System.out.println("Exception should be trown  but muted for the moment");
                }

            } finally {
                if (ok) {
                    if (this.choiceIsNavigateUp()) {
                        this.choice = this.parent;
                    }
                } else {
                    System.out.println("Il faut choisir une commande valide:");
                }
            }
        }
        return this.choice;

    }

    public void add( Entry menuComp ) {
        if (menuComp.isMenu()) {
            EntryImp back = new EntryImp(((MenuImp) menuComp).entree.size(), "Retour", new MenuUpCommand(), "U");
            ((MenuImp) menuComp).add(back);
            ((MenuImp) menuComp).parent = this;

        }
        this.entree.put(menuComp.getNumber(), menuComp);
        this.shortcutTable.put(menuComp.getShortcut(), menuComp);
    }


    public boolean choiceIsQuit( ) {
        return !(this.choice.getCommand() instanceof ExitCommand);
    }

    public boolean choiceIsNavigateUp( ) {
        return this.choice.getCommand() instanceof MenuUpCommand;
    }

    @Override
	public final boolean isMenu( ) {
        return true;
    }
}
