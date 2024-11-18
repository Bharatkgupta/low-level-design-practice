package managers;

import models.Ride;

public class PaymentGateway {
    private static PaymentGateway gateway;
    private PaymentGateway() {};

    public static PaymentGateway getGateway() {
        if(gateway == null) {
            synchronized(PaymentGateway.class) {
                if(gateway == null) {
                    gateway = new PaymentGateway();
                }
            }
        }
        return gateway;
    }

    public void getBreakup(Ride ride) {
        // print messages related to who pay to whom and how much
        return;
    }
}
