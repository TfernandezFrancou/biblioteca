import java.util.List;

public class Repo_Prestamos {

    private List<Prestamo> prestamos;

    public void agregarPrestamo(Prestamo prestamo){
        this.prestamos.add(prestamo);
    }

    public Prestamo buscarPrestamo(Copia_Libro copia){
        return prestamos.stream()
                .filter(prestamo -> prestamo.getLibro().equals(copia)).findFirst().get();

    }

}
