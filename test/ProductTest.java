import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product p1;
    private Product p2;

    @BeforeEach
    void setUp() {
        p1 = new Product("Chair", 129.99);
        p2 = new Product("Headphones", 24.48);
    }

    @Test
    void getProductName() {
        assertEquals("Chair", p1.getProductName());
        assertEquals("Headphones", p2.getProductName());
    }

    @Test
    void getUnitPrice() {
        assertEquals(129.99, p1.getUnitPrice());
        assertEquals(24.48, p2.getUnitPrice());
    }
}
