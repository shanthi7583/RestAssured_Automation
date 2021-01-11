package stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

		@Before("@DeletePlace")
		public void beforeScenario() throws IOException
		{		//execute this code only when place id is null
			//write a code that will give you place id
			
			AddPlaceAPI	 m =new AddPlaceAPI();
			if(AddPlaceAPI.place_id==null)
			{
			
			m.AddplaceAPI("Shetty", "French", "Asia");
			m.user_calls_with_post_http_request("AddPlaceAPI", "POST");
			m.verify_place_Id_created_maps_to_using("Shetty", "getPlaceAPI");
			}
			


	}

}
