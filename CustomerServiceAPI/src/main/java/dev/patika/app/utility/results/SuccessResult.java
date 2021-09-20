package dev.patika.app.utility.results;

public class SuccessResult extends Result{
    public SuccessResult() { super(true); }

    public SuccessResult(String message) { super(true, message); }
}
