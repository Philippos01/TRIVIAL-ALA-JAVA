package Sql_server;

public class ErrorClass extends Exception {
public ErrorClass() {
super("an error occured");
}
public 	ErrorClass(String message) {
	super(message);
}
}
