import java.util.ArrayList;

class Invoice {
    private int invoiceNumber;
    private ArrayList<LineItem> items = new ArrayList<>();
    private Customer customer;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.invoiceNumber = (int) (Math.random() * 50) + 1;
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(LineItem::getTotal).sum();
    }

    public String getInvoiceDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVOICE").append("\n");
        sb.append("Invoice Number: ").append(invoiceNumber).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Address: ").append(customer.getAddress()).append("\n\n");

        for (LineItem item : items) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }
}
