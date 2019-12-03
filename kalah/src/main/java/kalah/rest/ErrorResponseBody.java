package kalah.rest;

import java.io.Serializable;

public class ErrorResponseBody implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String error;
    
    public ErrorResponseBody(String error)
    {
        this.setError(error);
    }
    
    public ErrorResponseBody()
    {
        
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }
   
}
