package fr.cnam.tp9;


import java.util.Scanner;

public class Menu extends CommonMenuComponent {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    /**
     * Attributes
     */
   private MenuComponent[] entree = new MenuComponent[20];
   private Command choice;
   private int nbElements = 0;
   public Menu(String a_text){

       super(a_text);
       this.setCommand(new MenuCommand((this)));
       this.choice=new NoopCommand();
       CommonMenuComponent menuExitEntry =new Entry("Quitter");
       menuExitEntry.setCommand(new ExitCommand());
       this.add(menuExitEntry);

   }
    /**
     * Methods
     */
    public void afficher(){
        System.out.print("--------------------------------------------------------\n");
        System.out.print(this.toString()+"\n");
        System.out.print("--------------------------------------------------------\n");
        for(int i = 1; i<this.nbElements; i++){
            if(this.entree[i].getCommand().isExecutable()) {
                System.out.print(ANSI_GREEN + i + ANSI_RESET);
            }
            else{
                System.out.print(ANSI_RED+ "X"+ ANSI_RESET);
            }
            System.out.print(") "+this.entree[i].toString());
            System.out.println("\n");
        }

        //Display Quit Command

        if(this.entree[0].getCommand().isExecutable()) {
            System.out.print(ANSI_GREEN + 0 + ANSI_RESET);
        }
        else{
            System.out.print(ANSI_RED+ "X"+ ANSI_RESET);
        }
        System.out.print(") "+this.entree[0].toString());
        System.out.println("\n");

        System.out.print("--------------------------------------------------------\n");
    }

    void  proposer() {
        boolean ok = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez choisir le numero de la commande :");

            while (!ok) {
                int choix = -1;
                try {
                    choix = scanner.nextInt();

                } catch (Exception e) {
                    scanner.nextLine();
                } finally {
                    if (choix >= 0 && choix < this.nbElements && this.entree[choix].getCommand().isExecutable()) {
                        ok = true;
                        choice = this.entree[choix].getCommand();
                        this.choice.executer();
                    } else
                        System.out.println("Il faut choisir un numero parmis les commandes valides:");
                }
            }


    }
    public void add(MenuComponent menuComp){

        this.entree[this.nbElements++]=menuComp;

    }

    public void setCommand(Command a_Command){
        super.setCommand(a_Command);
    }

    public boolean choiceIsQuit() {
        return choice instanceof ExitCommand;
    }


    int getNbElements(){
        return this.nbElements;
    }

    MenuComponent getCompAt(int i){

        //Add to exception to throw when no component is present at position i (no component yet or i is > nbElements

        return this.entree[i];
    }
}
