package services;

public class PaymentGatway {
    private static PaymentGatway gatway;
    private int costPerhour;
    private PaymentGatway() {
        costPerhour = 10;
    }

    public static synchronized PaymentGatway getPaymentGatway() {
        if(gatway == null) {
            gatway = new PaymentGatway();
        }
        return gatway;
    }

    public int calculateCharges(int duration) {
        return this.costPerhour * duration;
    }
}
