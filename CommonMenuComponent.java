package fr.cnam.tp9;


public abstract class  CommonMenuComponent implements MenuComponent {

   private String text;


   public CommonMenuComponent(String a_text){

       this.text=a_text;
   }

    public boolean isMenu(){
       return false;
    }

    @Override
    public Command getCommand() {
        return (new NoopCommand());
    }

    public String toString(){
       return this.text;
   }

}
