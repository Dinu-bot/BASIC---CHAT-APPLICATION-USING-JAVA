package Server;
public class ColorChanger {
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[36m";

    public void GREEN() {
        System.out.print(BLUE);
    }
    public void PURPLE(){
        System.out.print(PURPLE);
    }
    public void WHITE(){
        System.out.print(WHITE);
    }
    public void CYAN(){ System.out.print(CYAN);}
    public void YELLOW(){
        System.out.print(YELLOW);
    }
}
