import java.util.List;

public class Repo_Prestamos {

    private List<Prestamo> prestamos;

    public Prestamo buscarPrestamo(Copia_Libro copia){
        return prestamos.stream()
                .filter(prestamo -> prestamo.getLibro().getNumeroDeCopia()
                        .equals(copia.getNumeroDeCopia())).findFirst().get();

    }

}
