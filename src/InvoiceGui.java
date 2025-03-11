import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceGui {
    private JFrame frame;
    private JTextField productField, priceField, quantityField;
    private JTextArea invoiceArea;
    private Invoice invoice;

    public InvoiceGui() {
        frame = new JFrame("Invoice System");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        inputPanel.add(new JLabel("Product Name:"), gbc);
        gbc.gridx = 1;
        productField = new JTextField(15);
        inputPanel.add(productField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Unit Price:"), gbc);
        gbc.gridx = 1;
        priceField = new JTextField(15);
        inputPanel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        quantityField = new JTextField(15);
        inputPanel.add(quantityField, gbc);


        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add Item");
        inputPanel.add(addButton, gbc);

        frame.add(inputPanel, BorderLayout.NORTH);

        invoiceArea = new JTextArea(15, 40);
        invoiceArea.setEditable(false);
        invoiceArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(invoiceArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        Customer customer = new Customer("That One Store", "123 Main Street\nSomewhere, CA 90210");
        invoice = new Invoice(customer);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToInvoice();
            }
        });

        frame.setVisible(true);
    }

    private void addItemToInvoice() {

        if (productField.getText().isEmpty() || priceField.getText().isEmpty() || quantityField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All fields are required", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String name = productField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(name, price);
            LineItem item = new LineItem(product, quantity);
            invoice.addItem(item);

            invoiceArea.setText(formatInvoice(invoice));

            productField.setText("");
            priceField.setText("");
            quantityField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Price and Quantity Required", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String formatInvoice(Invoice invoice) {
        StringBuilder sb = new StringBuilder();

        // Centered INVOICE header
        sb.append(String.format("%30s\n\n", "**INVOICE**"));
        sb.append(invoice.getCustomer().getName()).append("\n");
        sb.append(invoice.getCustomer().getAddress()).append("\n\n");
        sb.append("Invoice Number: ").append(invoice.getInvoiceNumber()).append("\n\n");

        sb.append("---------------------------------------------------\n");
        sb.append(String.format("%-15s %-5s %-10s %-10s\n", "Item", "Qty", "Price", "Total"));
        sb.append("---------------------------------------------------\n");

        for (LineItem item : invoice.getItems()) {
            sb.append(String.format("%-15s %-5d $%-9.2f $%-9.2f\n",
                    item.getProduct().getProductName(), item.getQuantity(),
                    item.getProduct().getUnitPrice(), item.getTotal()));
        }

        sb.append("---------------------------------------------------\n");
        sb.append(String.format("AMOUNT DUE: $%.2f", invoice.getTotal()));

        return sb.toString();
    }
}
