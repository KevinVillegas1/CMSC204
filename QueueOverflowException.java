
public class QueueOverflowException extends Exception{

	public QueueOverflowException()
	{
		super("Enqueue method is called on a full queue.");
	}
	
	public QueueOverflowException(String message)
	{
		super(message);
	}
}
