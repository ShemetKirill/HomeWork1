import java.math.BigDecimal;

public interface ITransactionFee {
    public BigDecimal applyFee(BigDecimal ammount);
}
