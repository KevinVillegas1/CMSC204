
public class QueueUnderflowException extends Exception{

	public QueueUnderflowException()
	{
		super("Dequeue method is called on an empty queue.");
	}
	
	public QueueUnderflowException(String message)
	{
		super(message);
	}
}
