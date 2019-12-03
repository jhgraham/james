package kalah.exceptions;


/**
 * Exception thrown when a game referenced by an ID does not exist.
 * @author James
 *
 */
public class KalahGameNotFoundException extends KalahException
{
    /**
     * Constructor
     * @param message - description of the error.
     */
	public KalahGameNotFoundException(String message)
	{
		super(message);
	}
}
