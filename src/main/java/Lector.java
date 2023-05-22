import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class Lector {

    private String nombre;
    private List<Prestamo> prestamos;
    @Getter
    private LocalDate fechaFinMulta;
    private List<Multa> multas;


    public Boolean estaHabilitado(){
        return fechaFinMulta.isBefore(LocalDate.now()) && prestamos.stream().noneMatch(Prestamo::estaVencido);
    }

    public void agregarPrestamo(Prestamo prestamo){
        if(this.estaHabilitado() && librosEnPrestamo()<3) {
            this.prestamos.add(prestamo);
        }
    }

    public Integer librosEnPrestamo(){
        return this.prestamos.size();
    }

    public void agregarMulta(Multa multa) {
        multas.add(multa);
        //actualiza la fecha de fin de multa
        LocalDate fechaNueva = LocalDate.now().plusDays(multa.diasMultado());
        if (fechaFinMulta.isBefore(fechaNueva)) {
            fechaFinMulta = fechaNueva;
        }
    }
}
