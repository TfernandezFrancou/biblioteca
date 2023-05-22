import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class Prestamo {
    @Getter
    private Lector cliente;
    @Getter
    private Copia_Libro libro;
    @Getter
    private LocalDate fechaEmision;
    @Getter
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;


    public Prestamo(Lector cliente,Copia_Libro copia, LocalDate fechaEmision,
                    LocalDate fechaVencimiento){
        this.cliente=cliente;
        Estado estadoNuevo = new Estado(TipoDeEstado.PRESTADO,LocalDate.now());
        copia.cambiarEstado(estadoNuevo);
        this.libro=copia;
        this.fechaEmision=fechaEmision;
        this.fechaVencimiento=fechaVencimiento;

    }

    public Boolean estaVencido(){
        return diferenciaDias(LocalDate.now(),fechaEmision) > 30;
    }

    public void agregarFechaDevolucion(LocalDate fecha){
        fechaDevolucion = fecha;
    }

    public int diferenciaDias(LocalDate fecha1, LocalDate fecha2){
      return fecha1.compareTo(fecha2);
    };

}