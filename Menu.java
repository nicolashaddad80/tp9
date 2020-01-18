package fr.cnam.tp9;
import java.util.Scanner;

public class Menu extends Entry {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    /**
     * Attributes
     */
   private MenuComponent[] entree = new MenuComponent[20];

   private int nbElements = 0;
   private Menu parent=this;
   private MenuComponent choice=this;
   public Menu(String a_text,String a_Shortcut){
       super(a_text, new NoopCommand(),a_Shortcut);

       this.add(new Entry("Quitter",new ExitCommand(),"Q"));

   }
    /**
     * Methods
     */
    public void afficher(){
        System.out.print("--------------------------------------------------------\n");
        System.out.print(this.text+"\n");
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

    public MenuComponent  proposer() {
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
                        this.choice = this.entree[choix];
                        if(this.choiceIsNavigateUp()){
                            choice=this.parent;
                        }
                    } else
                        System.out.println("Il faut choisir un numero parmis les commandes valides:");
                }
            }
        return this.choice;

    }
    public void add(MenuComponent menuComp){
        if(menuComp.isMenu())
        {
            Entry back = new Entry("Retour",new MenuUpCommand(),"U");
            ((Menu)menuComp).add(back);
            ((Menu)menuComp).parent=this;

        }
        this.entree[this.nbElements++]=menuComp;

    }


    public boolean choiceIsQuit() {
        return this.choice.getCommand() instanceof ExitCommand;
    }

    public boolean choiceIsNavigateUp() {
        return this.choice.getCommand() instanceof MenuUpCommand;
    }

    @Override
    public final boolean isMenu(){
        return true;
    }
}
