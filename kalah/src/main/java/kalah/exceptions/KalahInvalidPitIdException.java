package kalah.exceptions;

/**
 * Exception thrown when an invalid Pit ID is supplied
 * @author James
 *
 */
public class KalahInvalidPitIdException extends KalahException
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param message - description of the message
     */
    public KalahInvalidPitIdException(String message)
	{
		super(message);
	}
}

