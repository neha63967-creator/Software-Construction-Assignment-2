
public class OrderService {

    // system constants (replaces magic numbers)
    private static final int BASE_A = 10;
    private static final int BASE_B = 20;

    private final DiscountService discountService;
    private final FileService fileService;
    private final LoggerService logger;
    private final OrderReportPrinter printer;

    private final UserType systemUserType;
    private final PaymentType systemPaymentType;

    public OrderService(UserType userType,
                        PaymentType paymentType,
                        DiscountService discountService,
                        FileService fileService,
                        LoggerService logger,
                        OrderReportPrinter printer) {
        this.systemUserType = userType;
        this.systemPaymentType = paymentType;
        this.discountService = discountService;
        this.fileService = fileService;
        this.logger = logger;
        this.printer = printer;
    }

    /**
     * Process an order and return the final total.
     */
    public double processOrder(OrderRequest request) throws Exception {
        // validation
        OrderValidator validator = new OrderValidator();
        validator.validate(request);

        logger.addLog("Start:" + request.getUserName());

        int qty = request.getQuantity();
        if (request.isUrgent()) qty++;

        double total = calculateTotal(qty, request.getPrice());
        total = discountService.applyDiscount(systemUserType, total);

        // persist order summary
        String orderLine = String.format("U:%s P:%d T:%.2f",
                request.getUserName(), request.getProductId(), total);
        fileService.appendToFile("order_data.txt", orderLine);

        // print report & summary
        printer.printReport(request.getUserName(), request.getProductId(), qty, total, request.getOrderDate().getFormattedDate());
        printer.printOrderSummary(request.getUserName(), total);

        // payment info (simple)
        printPaymentInfo(systemPaymentType);

        logger.addLog("End:" + request.getUserName());

        return total;
    }

    private double calculateTotal(int qty, double price) {
        return qty * price + BASE_A + BASE_B;
    }

    private void printPaymentInfo(PaymentType paymentType) {
        switch (paymentType) {
            case CASH -> System.out.println("Cash payment");
            case CARD -> System.out.println("Card payment");
            case BANK -> System.out.println("Bank payment");
            case OTHER -> System.out.println("Other payment");
        }
    }
}
