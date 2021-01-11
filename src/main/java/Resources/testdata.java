package Resources;

import java.util.ArrayList;
import java.util.List;
import pojo.pojo;

public class testdata {
	
	public testdata addplace_payload()
	{ 
		testdata t=new testdata();
			pojo po=new pojo();
			po.setAccuracy(50);
			po.setAddress("29, side layout, cohen 09");
			po.setName("Frontline house");
			po.setphone_number("+91) 983 893 3937");
			po.setWebsite("http://google.com");
			po.setLanguage("French-IN");
			List<String> mylist=new ArrayList<String>();
			mylist.add("shoepark");
			mylist.add("shop");
			po.setTypes(mylist);
			return t;
			
			
		
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}



