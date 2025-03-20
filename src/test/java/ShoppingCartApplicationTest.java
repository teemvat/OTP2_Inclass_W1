import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartApplicationTest {

    @Test
    void calculateTotalPrice() {
        double price = 10.0;
        int quantity = 5;
        double expected = 50.0;
        double actual = ShoppingCartApplication.calculateTotalPrice(price, quantity);
        assertEquals(expected, actual);
    }

}