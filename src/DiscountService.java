
public class DiscountService {

	private UserType userType;
    public double applyDiscount(UserType userType, double total) {
        if (userType == null) return total;

        return switch (userType) {
            case REGULAR -> total - 10;
            case PREMIUM -> total - 2;
            case GOLD -> total - 1;
        };
    }
}
