package fr.cnam.tp9.menu;

import fr.cnam.tp9.menu.menucommands.*;
import fr.cnam.tp9.printer.Printable;
import fr.cnam.tp9.printer.Printer;

import java.io.PrintStream;
import java.util.*;

public class Menu extends Entry implements Printable {


    /**
     * Attributes
     */

    private class MenuPrinter  implements Printer {
        private PrintStream menuPrinterPort;
        public MenuPrinter(PrintStream a_MenuPrinterPort){
            this.menuPrinterPort=a_MenuPrinterPort;
        }
        @Override
        public void print() {
            this.menuPrinterPort.print(afficher());
        }
    };



    private Hashtable<Integer, MenuComponent> entree = new Hashtable<>(20);
    private Hashtable<String, MenuComponent> shortcutTable = new Hashtable<>(20);

    private Menu parent = this;
    private MenuComponent choice = this;
    private MenuPrinter menuPrinter = new MenuPrinter(System.out);

    public Menu(int a_MenuNum, String a_text, String a_Shortcut) {
        super(a_MenuNum, a_text, new NoopCommand(), a_Shortcut);

        this.add(new Entry(0, "Quitter", new ExitCommand(), "Q"));

    }

    /**
     * Methods
     */

    @Override
    public Printer getPrinter() {
        return menuPrinter;
    }

    public String afficher() {
        String menuElementsString = "--------------------------------------------------------\n" + this.text + '\n' + "--------------------------------------------------------\n";


        Vector sortedEntry = new Vector(entree.keySet());
        Collections.sort(sortedEntry);




        Iterator it = sortedEntry.iterator();

        while (it.hasNext()) {
            Integer entryKey = (Integer) it.next();
            MenuComponent entry = entree.get(entryKey);
            if (entryKey.intValue() > 0) {
                if (entry.getCommand().isExecutable()) {
                    menuElementsString = menuElementsString + ANSI_GREEN + entryKey + ANSI_RESET;
                } else {
                    menuElementsString = menuElementsString + ANSI_RED + "X" + ANSI_RESET;
                }
                menuElementsString = menuElementsString +") " + entry.toString()+'\n';
            }

        }

        Collections.reverse(sortedEntry);
        it = sortedEntry.iterator();

        while (it.hasNext()) {
            Integer entryKey = (Integer) it.next();
            MenuComponent entry = entree.get(entryKey);
            if (entryKey.intValue() <= 0) {
                if (entry.getCommand().isExecutable()) {
                    menuElementsString = menuElementsString + ANSI_GREEN + entryKey + ANSI_RESET;
                } else {
                    menuElementsString = menuElementsString + ANSI_RED + "X" + ANSI_RESET;
                }
                menuElementsString = menuElementsString +") " + entry.toString()+'\n';
            }

        }

        menuElementsString = menuElementsString +"--------------------------------------------------------\n";

        return menuElementsString;
    }

    public MenuComponent proposer() {
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
                        MenuComponent tempChoice = this.shortcutTable.get(shortcut);
                        if (tempChoice.getCommand().isExecutable()) {
                            ok = true;
                            this.choice = tempChoice;
                        }
                    }

                } catch (Exception e1) {
                    System.out.println("Exception trown but muted for the moment");
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

    public void add(MenuComponent menuComp) {
        if (menuComp.isMenu()) {
            Entry back = new Entry(this.entree.size() + 1, "Retour", new MenuUpCommand(), "U");
            ((Menu) menuComp).add(back);
            ((Menu) menuComp).parent = this;

        }
        this.entree.put(menuComp.getNumber(), menuComp);
        this.shortcutTable.put(menuComp.getShortcut(), menuComp);
    }


    public boolean choiceIsQuit() {
        return this.choice.getCommand() instanceof ExitCommand;
    }

    public boolean choiceIsNavigateUp() {
        return this.choice.getCommand() instanceof MenuUpCommand;
    }

    @Override
    public final boolean isMenu() {
        return true;
    }
}
