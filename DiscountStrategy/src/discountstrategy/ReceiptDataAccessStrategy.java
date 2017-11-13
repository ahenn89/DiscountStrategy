package discountstrategy;

/**
 *
 * @author Ashlee
 */
public interface ReceiptDataAccessStrategy {
    
    public Customer findCustomer(String customerId);
    public Product findProduct(String productId);
    
}
