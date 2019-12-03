package kalah.exceptions;

/**
 * Kalah Base exception class
 * @author James
 *
 */
public class KalahException extends Throwable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param message - description of the error.
     */
	public KalahException(String message)
	{
		super(message);
	}
}
