package com.zero.schedule.exceptions;

/**
 * Created by MaXuewen on 2018/7/18.
 */
public class ScheduleException extends Exception {

  public ScheduleException() {
    super();
  }

  public ScheduleException(String msg) {
    super(msg);
  }

  public ScheduleException(Throwable cause) {
    super(cause);
  }

  public ScheduleException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public Throwable getUnderlyingException() {
    return super.getCause();
  }

  @Override
  public String toString() {
    Throwable cause = getUnderlyingException();
    if (cause == null || cause == this) {
      return super.toString();
    } else {
      return super.toString() + " [See nested exception: " + cause + "]";
    }
  }
}
