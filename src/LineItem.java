class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() { return product.getUnitPrice() * quantity; }

    public String toString() {
        return quantity + " x " + product.getProductName() + " @ " + product.getUnitPrice() + " = " + getTotal();
    }
}
