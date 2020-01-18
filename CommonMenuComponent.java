package fr.cnam.tp9;


public abstract class  CommonMenuComponent implements MenuComponent {




   public CommonMenuComponent(String a_text){

       this.text=a_text;
   }



    @Override
    public Command getCommand() {
        return (new NoopCommand());
    }



}
