import java.util.List;

public class Repo_Copia_Libros {

    private List<Copia_Libro> copias;

    public void agregarCopia(Copia_Libro copia){
        this.copias.add(copia);
    }

    public Copia_Libro buscar(Integer numero_copia){
       return copias.stream().filter(copia_libro -> copia_libro.getEstado().equals(numero_copia)).findFirst().get();
    }
    

}
