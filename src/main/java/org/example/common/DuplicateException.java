package org.example.common;

public class DuplicateException extends Exception {

    public DuplicateException() {
        super();
    }

    public DuplicateException(String s) {
        super(s);
    }

    public DuplicateException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DuplicateException(Throwable throwable) {
        super(throwable);
    }

    protected DuplicateException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
