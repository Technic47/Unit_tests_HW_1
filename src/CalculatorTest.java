import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        int discount = 50;
        double purchaseAmount = 1000;
        System.out.println(Calculator.calculatingDiscount(purchaseAmount, discount));

        try {
            Calculator.calculatingDiscount(1000, -5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Calculator.calculatingDiscount(1000, 115);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertThat(Calculator.calculatingDiscount(1000, 50)).isEqualTo(1500);
        assertThat(Calculator.calculatingDiscount(1000, 100)).isEqualTo(2000);
        assertThat(Calculator.calculatingDiscount(1000, 0)).isEqualTo(1000);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(1000, -10)
        ).isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(1000, 110)
        ).isInstanceOf(ArithmeticException.class);
    }
}