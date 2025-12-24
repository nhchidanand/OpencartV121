package utilities;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name="loginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\ReadData.xlsx";
		ExcelUtility ExUtil = new ExcelUtility(path);
		int rows = ExUtil.getRowCount("Sheet1");
		int columns = ExUtil.getCellCount("Sheet1", 1);
		String logindata[][] =new String[rows][columns];
		for(int r=1; r<=rows; r++)
		{
			for(int c=0; c<columns; c++)
			{
				logindata[r-1][c] = ExUtil.getCellData("Sheet1", r, c);
			}
		}
		return logindata;
	}
	
	
	@DataProvider(name = "AddressData")
	public String[][] AddressData() throws IOException
	{
		String path = ".\\testData\\ReadData.xlsx";
		ExcelUtility exutil = new ExcelUtility(path);
		int rows = exutil.getRowCount("Sheet2");
		int columns = exutil.getCellCount("Sheet2", 1);
		String addressdata[][] = new String[rows][columns];
		for(int r=1; r<=rows; r++)
		{
			for(int c=0; c<columns; c++)
			{
				addressdata[r-1][c] = exutil.getCellData("Sheet2", r, c);
			}
		}
		return addressdata;
	}
	
	
	@DataProvider (name="LoginTestDataValidAndInvalid")
	public String[][] validAndInvalid() throws IOException
	{
		String path = ".\\testData\\ReadData.xlsx";
		ExcelUtility ExUtil = new ExcelUtility(path);
		int rows = ExUtil.getRowCount("Sheet3");
		int columns = ExUtil.getCellCount("Sheet3", 1);
		String loginTestDataValidAndInvalid[][] =new String[rows][columns];
		for(int r=1; r<=rows; r++)
		{
			for(int c=0; c<columns; c++)
			{
				logindata[r-1][c] = ExUtil.getCellData("Sheet3", r, c);
			}
		}
		return loginTestDataValidAndInvalid;
	}
	
	
	@DataProvider(name="AddressData2")
	public Object[][] AddressData2() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\testData\\JReadData.json";
		JSONUtility jsonutil = new JSONUtility();
		List<HashMap<String, String>> data = jsonutil.JsonDataReader(path);
		Object a[][] = new Object[][] {{data.get(0)}, {data.get(1)}};
		return a;
	}
}
