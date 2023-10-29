package edu.hw2.Task4;

public final class CallInfo {
    private CallInfo() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stacktrace = new Throwable().getStackTrace();
        String className = stacktrace[1].getClassName();
        String methodName = stacktrace[1].getMethodName();

        return new CallingInfo(className, methodName);
    }
}
