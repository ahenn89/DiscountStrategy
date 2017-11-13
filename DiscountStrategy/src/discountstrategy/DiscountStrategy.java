package discountstrategy;

/**
 *
 * @author Ashlee
 */
public interface DiscountStrategy {
    public abstract double getDiscountAmount(double qtyPurchased, double price);
}
