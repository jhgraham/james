
package kalah.rest;

import java.io.Serializable;
import java.util.Map;


class MoveResponseBody implements Serializable
{
	private String id;
	private String url;
	private Map<String, String> status;
	
	public MoveResponseBody()
	{
		
	}
	
	public MoveResponseBody(String id, String url, Map<String, String> status)
	{
		this.id = id;
		this.url = url;
		this.status = status;
	}
	
	public Map<String, String> getStatus()
	{
		return status;
	}
	
	public void setStatus(Map<String, String> status)
	{
		this.status = status;
	}
	
	public String getId()
	{
		return this.id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}	
}
