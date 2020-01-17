package fr.cnam.tp9;


public abstract class  CommonMenuComponent implements MenuComponent {

   private String text;
    private Command command;

   public CommonMenuComponent(String a_text){

       this.text=a_text;
   }
   public void setCommand(Command a_Command){
       this.command=a_Command;
   }
   public Command getCommand(){
       return this.command;
   }

   public String toString(){
       return this.text;
   }

}
