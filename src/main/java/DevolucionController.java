import java.time.LocalDate;

public class DevolucionController {

    private Repo_Copia_Libros repoCopias = new Repo_Copia_Libros();
    private Repo_Prestamos repoPrestamos = new Repo_Prestamos();

    public Copia_Libro obtenerLibro(Integer numeroCopia){
        return repoCopias.buscar(numeroCopia);
    }

    public void actualizarCopia(Copia_Libro copia,Estado estado){
        copia.cambiarEstado(estado);
    }

    public void devolverLibro(Integer numero_copia){
        Copia_Libro copia = obtenerLibro(numero_copia);

        actualizarCopia(copia,new Estado(TipoDeEstado.BIBLIOTECA, LocalDate.now()));


    }

}
