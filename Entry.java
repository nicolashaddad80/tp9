package fr.cnam.tp9;


public class Entry extends CommonMenuComponent {


    public Entry(String a_text){

        super(a_text);

    }

    @Override
    public boolean isMenu(){
        return false;
    }

}
