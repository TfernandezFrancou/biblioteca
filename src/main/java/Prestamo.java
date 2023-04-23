import java.time.LocalDate;
import java.util.List;

public class Prestamo {
    private Lector cliente;
    private Copia_Libro libro;
    private LocalDate fechaEmision;
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

     public void agregarDevolucion(LocalDate fechaDevolucionPrestamo){
        fechaDevolucion = fechaDevolucionPrestamo;
        int diferencia = diferenciaDias(fechaDevolucionPrestamo,fechaEmision);

        if(diferencia > 30){
            Multa nuevaMulta = new Multa((diferencia * 2L),LocalDate.now());
            cliente.agregarMulta(nuevaMulta);
        }
         Estado estadoNuevo = new Estado(TipoDeEstado.BIBLIOTECA,LocalDate.now());
         this.libro.cambiarEstado(estadoNuevo);
    }

    private int diferenciaDias(LocalDate fecha1, LocalDate fecha2){
      return fecha1.compareTo(fecha2);
    };

}