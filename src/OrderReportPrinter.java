public class OrderReportPrinter {

    public void printReport(String user, int productId, int qty, double total, String date) {
        System.out.println("----- ORDER REPORT -----");
        System.out.println("User: " + user);
        System.out.println("Product: " + productId);
        System.out.println("Quantity: " + qty);
        System.out.printf("Total: %.2f%n", total);
        System.out.println("Date: " + date);
    }

    public void printOrderSummary(String user, double total) {
        System.out.println("----- ORDER SUMMARY -----");
        System.out.println("User: " + user);
        System.out.printf("Total: %.2f%n", total);
    }
}
