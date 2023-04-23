package top.lxyi.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 自定义异常
 */
//注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
@Data
//该注解用于子类对象之间进行比较的时候
@EqualsAndHashCode(callSuper = true)
public class ServerException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -4117536775356403126L;
    private int code;
    private String msg;

    public ServerException(String msg){
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }
    public ServerException(ErrorCode errorCode){
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
    public ServerException(String msg,Throwable e){
        super(msg ,e);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }
}
