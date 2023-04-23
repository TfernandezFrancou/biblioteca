import java.time.LocalDate;

public class Copia_Libro {

    private Libro libro;
    private Integer numeroDeCopia;
    private Estado estado;

    public Copia_Libro(Libro libro, Integer numeroDeCopia){
        this.libro = libro;
        this.numeroDeCopia = numeroDeCopia;
        this.estado = new Estado(TipoDeEstado.PRESTADO, LocalDate.now());

    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }
}
