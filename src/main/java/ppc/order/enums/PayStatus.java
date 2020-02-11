package ppc.order.enums;

public enum PayStatus {
    WAIT(0,"等待支付"),SUCCESS(1,"支付成功");

    private Integer code;

    private String status;

    PayStatus(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
}
