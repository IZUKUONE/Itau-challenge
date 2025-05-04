package challenge.itau.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import javax.xml.crypto.dsig.TransformService;
import java.time.OffsetDateTime;

public class TransactionDto {

    @NotNull
    @Min(1)
    private double value;

    @NotNull
    private OffsetDateTime dateHour;

    public Double getValue() {
        return value;
    }

    public OffsetDateTime getDateHour() {
        return dateHour;
    }
}
