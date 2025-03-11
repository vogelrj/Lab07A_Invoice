import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    private Invoice invoice;
    private Customer customer;
    private Product p1;
    private Product p2;
    private LineItem item1;
    private LineItem item2;

    @BeforeEach
    void setUp() {
        customer = new Customer("That One Store", "123 Main Street\nSomewhere, CA 90210");
        invoice = new Invoice(customer);
        p1 = new Product("Chair", 129.99);
        p2 = new Product("Headphones", 24.48);
        item1 = new LineItem(p1, 2);
        item2 = new LineItem(p2, 3);
    }

    @Test
    void getInvoiceNumber() {
        int invoiceNumber = invoice.getInvoiceNumber();
        assertTrue(invoiceNumber >= 1 && invoiceNumber <= 50, "Invoice number should be between 1 and 50.");
    }

    @Test
    void addItem() {
        invoice.addItem(item1);
        invoice.addItem(item2);
        assertEquals(2, invoice.getItems().size());
    }

    @Test
    void getTotal() {
        invoice.addItem(item1);
        invoice.addItem(item2);
        assertEquals((2 * 129.99) + (3 * 24.48), invoice.getTotal(), 0.01);
    }

    @Test
    void getCustomer() {
        assertEquals(customer, invoice.getCustomer());
    }

    @Test
    void getInvoiceDetails() {
        invoice.addItem(item1);
        invoice.addItem(item2);
        String details = invoice.getInvoiceDetails();
        assertTrue(details.matches("(?s).*Invoice Number:\\s*" + invoice.getInvoiceNumber() + ".*"),
                "Invoice number should appear in the details.");

        assertTrue(details.contains("That One Store"));
        assertTrue(details.contains("123 Main Street"));

        assertTrue(details.contains("Chair"));
        assertTrue(details.contains("Headphones"));
    }
}


