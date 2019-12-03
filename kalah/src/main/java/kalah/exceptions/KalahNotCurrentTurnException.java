package kalah.exceptions;


/**
 * Exception throw when it is not the current turn of the player (North / South)
 * @author James
 *
 */
public class KalahNotCurrentTurnException extends KalahException
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param message - description of the error
     */
    public KalahNotCurrentTurnException(String message)
	{
		super(message);
	}
}
