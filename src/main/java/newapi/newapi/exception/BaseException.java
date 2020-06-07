package newapi.newapi.exception;

import newapi.newapi.NewApiApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.apache.commons.lang3.*;


public class BaseException extends RuntimeException {
    private MessageSource messageSource;
    private final ErrorCode errorCode;
    private final String message;
    private final Object[] args;

    protected BaseException(ErrorCode errorCode, String message) {
        this(errorCode, message, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    protected BaseException(ErrorCode errorCode, String message, Object[] args) {
        final String msg;
        this.messageSource = NewApiApplication.getApplicationContext().getBean(MessageSource.class);
        this.errorCode = errorCode;
        msg = messageSource.getMessage(errorCode.getMessage(), args, null, LocaleContextHolder.getLocale());
        this.message = (msg == null) ? message : msg;
        this.args = args;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getArgs() {
        return args;
    }

}
