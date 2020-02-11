package ppc.order.enums;

public enum OrderStatus {
    NEW(0,"新订单"),FINISHED(1,"完结"),CANCEL(2,"取消");

    private Integer code;

    private String status;

    OrderStatus(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
}
