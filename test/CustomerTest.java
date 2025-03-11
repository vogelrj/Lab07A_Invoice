import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer c1;

    @BeforeEach
    void setUp() {
        c1 = new Customer("That One Store", "123 Main Street\nSomewhere, CA 90210");
    }

    @Test
    void getName() {
        assertEquals("That One Store", c1.getName());
    }

    @Test
    void getAddress() {
        assertEquals("123 Main Street\nSomewhere, CA 90210", c1.getAddress());
    }

    @Test
    void setName() {
        c1.setName("That One Store");
        assertEquals("That One Store", c1.getName());
    }

    @Test
    void setAddress() {
        c1.setAddress("123 Main Street\nSomewhere, CA 90210");
        assertEquals("123 Main Street\nSomewhere, CA 90210", c1.getAddress());
    }
}
