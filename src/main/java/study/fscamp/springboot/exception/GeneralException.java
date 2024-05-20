package study.fscamp.springboot.exception;

import lombok.Getter;
import study.fscamp.springboot.constant.ErrorCode;

@Getter
public class GeneralException extends RuntimeException{
  private final ErrorCode errorCode;

  public GeneralException() {
    super();
    this.errorCode = ErrorCode.INTERNAL_ERROR;
  }

  public GeneralException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public GeneralException(String message, Throwable cause, ErrorCode errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public GeneralException(Throwable cause, ErrorCode errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

  public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.errorCode = errorCode;
  }

}
