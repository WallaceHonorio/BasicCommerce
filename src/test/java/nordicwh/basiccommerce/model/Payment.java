package nordicwh.basiccommerce.model;

import java.util.Date;

public record Payment(long numberCreditCard, int numberCode, String name, Date valid) {
}
