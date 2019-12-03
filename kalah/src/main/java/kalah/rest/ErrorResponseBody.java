package kalah.rest;

import java.io.Serializable;

/**
 * HTTP Response Body returned to client when an error occurs
 * @author James
 *
 */
public class ErrorResponseBody implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Error string returned to client
     */
    private String error;

    /**
     * Parameter constructor
     * @param error
     */
    public ErrorResponseBody(String error)
    {
        this.setError(error);
    }
    
    /**
     * Constructor
     */
    public ErrorResponseBody()
    {
        
    }

    /** 
     * Return the error string
     * @return
     */
    public String getError()
    {
        return error;
    }

    /**
     * Set the error string
     * @param error
     */
    public void setError(String error)
    {
        this.error = error;
    }
}
