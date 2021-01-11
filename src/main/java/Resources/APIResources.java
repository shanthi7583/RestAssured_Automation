package Resources;

//enum is special class in java which has collection of constants and methods
public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	public String resource;
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
		
	}
	
}
