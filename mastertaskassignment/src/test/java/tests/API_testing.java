package tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class API_testing {

	@Test
	public void foreignPlayer() {
		int count = 0;
		boolean flag = false;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\payload.json");
			Object obj = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println(jsonObject);
			JSONArray jsonArray = (JSONArray) jsonObject.get("player");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
				if(jsonObject1.get("Country").equals("India"))
					count++;
			}
			System.out.println("The Actual count for foreignPlayer will be:::" + count);
			if (count <= 4) {
				flag = true;
			}
			Assert.assertTrue(flag);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void wicketKeeper(){
        int count=0;
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader reader = new FileReader("src\\main\\resources\\payload.json");
            Object obj = jsonParser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("player");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject1 =(JSONObject) jsonArray.get(i);
                if(jsonObject1.get("role").equals("Wicket-keeper"))
                    count++;
            }
            System.out.println("wicket-keeper count will be :::"+count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1,count);

    }
}
