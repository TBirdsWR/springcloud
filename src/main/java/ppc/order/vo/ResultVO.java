package ppc.order.vo;

import lombok.Data;
import ppc.order.enums.ReturnStatus;

@Data
public class ResultVO {

    private Integer code;

    private String  message;

    private Object data;
    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO() {
    }

    public ResultVO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultVO OK(){
        return new ResultVO(ReturnStatus.SUCCESS.getCode(), ReturnStatus.SUCCESS.getMessage());
    }
}
