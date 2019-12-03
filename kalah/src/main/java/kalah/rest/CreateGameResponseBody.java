
package kalah.rest;

import java.io.Serializable;


/**
 * HTTP Response Body returned to client when a Game is successfully created.
 * @author James
 *
 */
class CreateGameResponseBody implements Serializable
{
	
    /**
     * Game ID
     */
	private String id;
	
	/**
	 * URL of the game
	 */
	private String url;
	
	/**
	 * Default Constructor
	 */
	public CreateGameResponseBody()
	{
		
	}
	
	/**
	 * Parameter constructor
	 * @param id
	 * @param url
	 */
	public CreateGameResponseBody(String id, String url)
	{
		this.id = id;
		this.url = url;
	}
	
	/**
	 * Return the game ID
	 * @return
	 */
	public String getId()
	{
		return this.id;
	}
	
	/**
	 * Set the game ID
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * Get the Game URL
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
