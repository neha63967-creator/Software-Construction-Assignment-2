public class ShippingService {

    public int calculateShipping(int distance) {
        if (distance < 0) distance = 0;
        if (distance < 10) return 50;
        if (distance < 50) return 100;
        if (distance < 100) return 150;
        return 200;
    }
}
