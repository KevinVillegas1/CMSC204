
public class StackOverflowException extends Exception{

	public StackOverflowException()
	{
		super("Push method is called on a full stack.");
	}
	
	public StackOverflowException(String message)
	{
		super(message);
	}
}
