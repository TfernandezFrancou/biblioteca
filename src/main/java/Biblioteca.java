import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Lector> lectores;

    private static Biblioteca instancia= null;

    public static Biblioteca getInstancia(){
        if(instancia==null){
            instancia = new Biblioteca();
        }
        return instancia;
    }
    private Biblioteca(){

    }
}
