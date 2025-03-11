import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    private LineItem item1;
    private LineItem item2;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product("Chair", 129.99);
        product2 = new Product("Headphones", 24.48);
        item1 = new LineItem(product1, 2);
        item2 = new LineItem(product2, 3);
    }

    @Test
    void getTotal() {
        assertEquals(259.98, item1.getTotal());
        assertEquals(73.44, item2.getTotal());
    }

    @Test
    void getProduct() {
        assertEquals(product1, item1.getProduct());
        assertEquals(product2, item2.getProduct());
    }

    @Test
    void getQuantity() {
        assertEquals(2, item1.getQuantity());
        assertEquals(3, item2.getQuantity());
    }

    @Test
    void testToString() {
        assertEquals("2 x Chair @ 129.99 = 259.98", item1.toString());
        assertEquals("3 x Headphones @ 24.48 = 73.44", item2.toString());
    }
}
