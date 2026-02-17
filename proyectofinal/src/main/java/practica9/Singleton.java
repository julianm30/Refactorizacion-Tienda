package practica9;

public class Singleton {
    private static Singleton instance = null;

    @ConstructorPrivado
    private Singleton(){
    }

    public static Singleton getInstance(){
        if (instance == null) 
            instance = new Singleton();
        return instance;
    }

    protected  static  void log (String mensaje){
        System.out.println("[LOG SYSTEM]: " + mensaje);
    }

}
