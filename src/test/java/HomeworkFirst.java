import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

class HomeworkFirst {

    private String info = "Expenses for next 10 years are ";

    @Test
    void countExpenses() {
        BigDecimal cash = new BigDecimal(100000.00);
        BigDecimal precentFirstDecade = new BigDecimal(0.1);
        BigDecimal precentSecondDecade = new BigDecimal(0.08);
        BigDecimal precentThirdDecade = new BigDecimal(0.06);
        BigDecimal years = new BigDecimal(10);

        BigDecimal expenseResultFirstDecade = precentageCount(cash, precentFirstDecade, years);
        Assertions.assertEquals("100000.00", expenseResultFirstDecade.toString());
        BigDecimal expenseResultSecondDecade = precentageCount(cash, precentSecondDecade, years);
        Assertions.assertEquals("80000.00", expenseResultSecondDecade.toString());
        BigDecimal expenseResultThirdDecade = precentageCount(cash, precentThirdDecade, years);
        Assertions.assertEquals("60000.00", expenseResultThirdDecade.toString());


    }

    private BigDecimal precentageCount(BigDecimal amount, BigDecimal precent, BigDecimal period) {
        BigDecimal expenses;
        expenses = amount.multiply(precent).multiply(period);
        expenses = expenses.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(info + expenses);
        return expenses;
    }
}
