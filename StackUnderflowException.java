
public class StackUnderflowException extends Exception{

	public StackUnderflowException()
	{
		super("Top or pop method is called on an empty stack.");
	}
	
	public StackUnderflowException(String message)
	{
		super(message);
	}
}
