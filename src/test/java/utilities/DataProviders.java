package utilities;
import org.testng.annotations.DataProvider;
import java.io.IOException;

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
}
