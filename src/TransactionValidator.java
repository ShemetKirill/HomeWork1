import java.math.BigDecimal;

public interface TransactionValidator {
    boolean isValid(BigDecimal ammount);
}
