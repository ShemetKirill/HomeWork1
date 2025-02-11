import java.math.BigDecimal;

public interface TransactionValidator {
    public boolean isValid(BigDecimal ammount);
}
