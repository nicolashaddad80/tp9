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
   private MenuComponent choice;
   private int nbElements = 0;
   private Menu parent=this;


   public Menu(String a_text){

       super(a_text);
       this.choice=this;
       CommonMenuComponent menuExitEntry =new Entry("Quitter",new ExitCommand());
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
                        choice = this.entree[choix];
                    } else
                        System.out.println("Il faut choisir un numero parmis les commandes valides:");
                }
            }


    }
    public void add(MenuComponent menuComp){
        if(menuComp.isMenu())
        {
            Entry back = new Entry("Retour",new MenuUpCommand());
            ((Menu)menuComp).add(back);
            ((Menu)menuComp).parent=this;

        }
        this.entree[this.nbElements++]=menuComp;

    }


    public boolean choiceIsQuit() {
        return choice.getCommand() instanceof ExitCommand;
    }

    public boolean choiceIsBack() {
        return choice.getCommand() instanceof MenuUpCommand;
    }



    int getNbElements(){
        return this.nbElements;
    }

    MenuComponent getCompAt(int i){

        //Add to exception to throw when no component is present at position i (no component yet or i is > nbElements

        return this.entree[i];
    }

    @Override
    public final boolean isMenu(){
        return true;
    }

    public MenuComponent getChoice(){
        return this.choice;
    }


    public Menu getParent(){
        return this.parent;
    }
}
