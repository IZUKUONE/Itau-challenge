package challenge.itau.model;

import java.time.OffsetDateTime;

public class Transaction {

    public OffsetDateTime getDateHour;
    private double value;
    private OffsetDateTime dateHour;

    public Transaction(final double value, final OffsetDateTime dateHour) {
        this.value = value;
        this.dateHour = dateHour;
    }

    public double getValue() {
        return value;
    }
    public OffsetDateTime getDateHour() {
        return dateHour;
    }
}
