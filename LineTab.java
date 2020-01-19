package fr.cnam.tp9;

public class LineTab implements Line,Cloneable{
    //some constants to manage output text colors
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";


    /**
     * Tableau de stockage des carastères de la ligne
     */

    private char [] carTable=null;
    /**
     * La position du curseur pointant sur le caractère courant
     */

   private int cursorPosition=0;

    /**
     * Constructeur de notre ligne  "ligne vide a la créationé
     */
    public LineTab(){
        this.carTable=new char[0];
        this.cursorPosition=0;
    }

    /**
     * Obtient le nombre de caractères dans une ligne.
     *
     * @return L'entier représentant le nombre de caractères dans une ligne.
     */
    public int getLength(){
        return this.carTable.length;
    }



    /**
     * Obtient la position du curseur sur la ligne.
     *
     * @return L'entier représentant la position du curseur sur la ligne.
     */
    public int getCursorPos(){
        return this.cursorPosition;

    }

    /**
     * Obtient le caractère à la ième position sur la ligne.
     * Ne fonctionne que si i est inférieur à la longueur de la ligne.
     *
     * @param i La position du caractère souhaité.
     * @return Le caractère à la ième position sur la ligne.
     */
    public char getCharAt(int i){
        if(i>this.getLength()|| i<1){
            //Through Exception
            return 'X'; //to delete when exception code is done
        }
        else {
            return this.carTable[i];
        }

    }

    /**
     * Obtient le caractère actuellement sous le curseur.
     * Ne fonctionne que si la ligne est non vide.
     *
     * @return Le caractère actuellement sous le curseur.
     */
    public char getCurrentChar(){
        if(this.getLength()==0){
            //Through Exception
            return 'X'; //to delete when exception code is done
        }
        else {
            return this.carTable[this.cursorPosition - 1];
        }
    }


    /**
     * Fait avancer le curseur d'une position à droite.
     * Ne fonctionne que si le curseur n'est pas déjà au bout de la ligne.
     */
    public void moveRight(){
        if(this.getCursorPos()==this.getLength()){
            //Through Exception
        }
        else {
            this.cursorPosition++;
        }
    }


    /**
     * Fait avancer le curseur d'une position à gauche.
     * Ne fonctionne que si le curseur n'est pas déjà au début de la ligne.
     */
    public void moveLeft(){
        if(this.getCursorPos()<2){
            //Through Exception
        }
        else {
            this.cursorPosition--;
        }

    }


    /**
     * Place le curseur sur le premier caractère.
     * Ne fonctionne que si la ligne est non vide.
     */
    public void moveBeginning(){

        if(this.getLength()==0){
            //Through Exception
        }
        else {
            this.cursorPosition = 1;
        }

    }


    /**
     * Remplace le caractère sous le curseur par le caractère c.
     * Ne fonctionne qui si la ligne est non vide.
     *
     * @param c Le nouveau caractère.
     */
    public void replace(char c){
        //TBD add check or exception when the  line is empty
        if(this.getLength()==0){
            //Through Exception
        }
        else{
            this.carTable[this.cursorPosition-1]=c;
        }
    }


    /**
     * Supprime le caractère sous le curseur.
     * Ne fonctionne que si la ligne est non vide.
     * La position du curseur reste inchangée sauf si le dernier caractère vient d'être supprimé.
     */
    public void delete(){
        //TBD add check or exception when the  line is empty

        if(this.getLength()==0){
           /* tempTab[0]=c;
            this.cursorPosition++;*/
            //TBD add check or exception when the  line is empty
        }
        else {
            char[] tempTab = new char[this.getLength() - 1];
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getCursorPos()-1);
            System.arraycopy(this.carTable, this.getCursorPos() , tempTab, this.getCursorPos()-1, this.getLength() - this.getCursorPos() );
            this.carTable=tempTab;
        }


        if(this.cursorPosition>this.getLength()){
            this.cursorPosition--;
        }
    }


    /**
     * Supprime le premier caractère de la ligne.
     * Ne fonctionne que si la ligne est non vide.
     * Le curseur reste sur le même caractère, sauf s'il était sur le dernier caractère.
     */
    public void deleteFirst(){
        //TBD add check or exception when the  line is empty


        if(this.getLength()==0){
            //TBD add check or exception when the  line is empty
        }
        else {
            char[] tempTab = new char[this.getLength() - 1];
            System.arraycopy(this.carTable, 1, tempTab, 0, this.getLength()-1);
            this.carTable=tempTab;
        }

        if(this.cursorPosition>1){
            this.cursorPosition--;
        }
        if(this.getLength()==0) {
            this.cursorPosition--;
        }

}


    /**
     * Supprime le dernier caractère de la ligne.
     * Ne fonctionne que si la ligne est non vide.
     * Le curseur reste sur le même caractère, sauf s'il était sur le dernier caractère.
     */
    public void deleteLast() {
        //TBD add check or exception when the  line is empty
        if(this.getLength()==0){
            //TBD add check or exception when the  line is empty
        }
        else {
            char[] tempTab = new char[this.getLength() - 1];
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getLength()-1);
            this.carTable=tempTab;
        }

        if(this.cursorPosition>this.getLength()){
            this.cursorPosition--;
        }

    }



    /**
     * Ajoute le caractère c avant le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addBefore(char c){
        char[] tempTab = new char[this.getLength() + 1];
        if(this.getLength()==0){
            //Through Exception
        }
        else {
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getCursorPos()-1);
            tempTab[this.getCursorPos()-1]=c;
            System.arraycopy(this.carTable, this.getCursorPos() - 1, tempTab, this.getCursorPos(), this.getLength() - this.getCursorPos() + 1);
            this.cursorPosition++;
            this.carTable=tempTab;
        }

    }


    /**
     * Ajoute le caractère c après le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addAfter(char c){

        char[] tempTab = new char[this.getLength() + 1];
        if(this.getLength()==0){
            //Through Exception
        }
        else {
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getCursorPos());
            tempTab[this.getCursorPos()]=c;
            System.arraycopy(this.carTable, this.getCursorPos() , tempTab, this.getCursorPos()+1, this.getLength() - this.getCursorPos() );
            this.carTable=tempTab;
        }



    }


    /**
     * Ajoute le caractère c au début de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addBeginning(char c){
        char[] tempTab = new char[this.getLength() + 1];
        if(this.getLength()==0){
            tempTab[0]=c;
        }
        else {
            tempTab[0]=c;
            System.arraycopy(this.carTable, 0, tempTab, 1, this.getLength());
        }
        this.cursorPosition++;
        this.carTable=tempTab;
    }


    /**
     * Ajoute le caractère c à la fin de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addEnd(char c){
        char[] tempTab = new char[this.getLength() + 1];
        if(this.getLength()==0){
            tempTab[0]=c;
            this.cursorPosition++;
        }
        else {
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getLength());
            tempTab[this.getLength()]=c;
        }

        this.carTable=tempTab;
    }


    /**
     * Affiche la ligne en mettant entre crochets [] le caractère courant.
     * Si la ligne est vide, un seul caractère tilde(~) est affiché.
     */
    public void print(){
        if(this.getLength()==0) {
            System.out.print(ANSI_RED +'~' + ANSI_RESET);
        }
        else {
            for (int i = 0; i < this.getCursorPos()-1; i++) {

                System.out.print(ANSI_BLUE+this.carTable[i]+ ANSI_RESET);
            }
            System.out.print(ANSI_RED +"["+ ANSI_RESET+ANSI_BLACK+ANSI_WHITE_BACKGROUND +(this.carTable[this.getCursorPos()-1])+ ANSI_RESET+ANSI_RED +"]"+ ANSI_RESET);

            for (int i = this.getCursorPos(); i < this.getLength(); i++) {

                System.out.print(ANSI_BLUE+this.carTable[i]+ ANSI_RESET);
            }
        }
        System.out.print("\n");
    }


    @Override
    public Line clone(){
        LineTab clone_Line=new LineTab();
        clone_Line.cursorPosition=this.cursorPosition;
        clone_Line.carTable= new char[this.getLength()];
        System.arraycopy(this.carTable, 0, clone_Line.carTable, 0, this.getLength());


        return clone_Line;
    }
}
