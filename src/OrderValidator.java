
public class OrderValidator {

    public void validate(OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("OrderRequest cannot be null");
        }
        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (request.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        // Additional validations can be added here (address format, productId range, etc.)
    }
}
