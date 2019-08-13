package testNG_tests;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import utilities.*;

public class Test_Factory_Runner {
  
	Excel_manipulation ex=new Excel_manipulation(); 
	
	ArrayList<Data> al=new ArrayList<Data>();
	Data data;
	@DataProvider(name="excel_data")
	public String[][] get_excel() {
		String[][] k= ex.get_excel_data();
		
		return k;
	}
	
	@Factory(dataProvider="excel_data")
	public Object[] createInstances(String email, String password) {
		return new Object[] {new Profile_page_actions(email, password)};
	}

	
}
