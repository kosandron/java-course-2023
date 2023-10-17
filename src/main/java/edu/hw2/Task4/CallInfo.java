package edu.hw2.Task4;

public final class CallInfo {
    private CallInfo() {
    }

    @SuppressWarnings("MagicNumber")
    public static CallingInfo callingInfo() {
        try {
            throw new Exception();
        } catch (Throwable e) {
            StackTraceElement[] stacktrace = e.getStackTrace();

            String[] name = stacktrace[1].toString().split("\\.");
            String methodName = name[name.length - 2].split("\\(")[0];
            StringBuilder classNameBuilder = new StringBuilder();
            for (int i = 0; i < name.length - 3; i++) {
                classNameBuilder.append(name[i]);
                classNameBuilder.append(".");
            }
            classNameBuilder.append(name[name.length - 3]);

            return new CallingInfo(classNameBuilder.toString(), methodName);
        }
    }
}
