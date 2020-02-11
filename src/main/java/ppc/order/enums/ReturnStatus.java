package ppc.order.enums;

import lombok.Getter;

@Getter
public enum ReturnStatus {
    SUCCESS(0,"SUCCESS"),ERROR(1,"ERROR");

    private Integer code;

    private String message;

    ReturnStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
