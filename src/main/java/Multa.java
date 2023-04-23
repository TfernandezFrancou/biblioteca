
import lombok.Getter;

import java.time.LocalDate;

public class Multa {

    private Long diasMultado;
    private LocalDate fechaEmision;

    public Multa(Long diasMultado, LocalDate fechaEmision){
        this.diasMultado = diasMultado;
        this.fechaEmision = fechaEmision;
    }

    public Long diasMultado(){
        return diasMultado;
    }
}
