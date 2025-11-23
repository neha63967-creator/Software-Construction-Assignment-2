import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SettingsLoader {

    private UserType userType = UserType.REGULAR;
    private PaymentType paymentType = PaymentType.CASH;

    /**
     * Loads settings from a text file. Expected lines:
     * U:<number>  (1=REGULAR, 2=PREMIUM, 3=GOLD)
     * P:<CASH|CARD|BANK|OTHER>
     */
    public void loadSettings(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            // keep defaults
            return;
        }

        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.startsWith("U:") || line.startsWith("U")) {
                    String val = line.contains(":") ? line.substring(line.indexOf(':') + 1).trim() : line.substring(1).trim();
                    try {
                        int code = Integer.parseInt(val);
                        userType = switch (code) {
                            case 1 -> UserType.REGULAR;
                            case 2 -> UserType.PREMIUM;
                            case 3 -> UserType.GOLD;
                            default -> UserType.REGULAR;
                        };
                    } catch (NumberFormatException ignore) { /* keep default */ }
                } else if (line.startsWith("P:") || line.startsWith("P")) {
                    String val = line.contains(":") ? line.substring(line.indexOf(':') + 1).trim() : line.substring(1).trim();
                    try {
                        paymentType = PaymentType.valueOf(val.toUpperCase());
                    } catch (IllegalArgumentException ignore) { /* keep default */ }
                }
            }
        } catch (FileNotFoundException e) {
            // defaults used
        }
    }

    public UserType getUserType() { return userType; }
    public PaymentType getPaymentType() { return paymentType; }
}
