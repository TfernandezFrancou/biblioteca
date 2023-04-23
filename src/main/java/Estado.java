import java.time.LocalDate;

public class Estado {
    private TipoDeEstado estado;
    private LocalDate fecha;

    public Estado(TipoDeEstado estado, LocalDate fecha){
        this.estado = estado;
        this.fecha = fecha;
    }
}
