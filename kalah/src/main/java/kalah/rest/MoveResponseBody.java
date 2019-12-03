
package kalah.rest;

import java.io.Serializable;
import java.util.Map;

/**
 * HTTP Response Body returned to client when a move is successfully made.
 * @author James
 *
 */
class MoveResponseBody implements Serializable
{
    /**
     * Game ID
     */
	private String id;
	
	/**
	 * Game URL
	 */
	private String url;
	
	/**
	 * Map of the state of the Kalah Game board
	 */
	private Map<String, String> status;
	
	/**
	 * Constructor
	 */
	public MoveResponseBody()
	{
		
	}
	
	/**
	 * Parameter Constructor
	 * @param id
	 * @param url
	 * @param status
	 */
	public MoveResponseBody(String id, String url, Map<String, String> status)
	{
		this.id = id;
		this.url = url;
		this.status = status;
	}
	
	/**
	 * Return the status map
	 * @return
	 */
	public Map<String, String> getStatus()
	{
		return status;
	}
	
	/**
	 * Set the status map
	 * @param status
	 */
	public void setStatus(Map<String, String> status)
	{
		this.status = status;
	}
	
	/**
	 * Return the Game ID
	 * @return
	 */
	public String getId()
	{
		return this.id;
	}
	
	/**
	 * Set the Game ID
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * Return the Game URL
	 * @return
	 */
	public String getUrl()
	{
		return this.url;
	}
	/**
	 * Set the Game URL
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}	
}
