package ninzaCRM.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic mothods related to file operations like property file , excel file
 * @author M Preethi
 */
public class FileUtility
{
	/**
	 * This method read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	/**
	 * This method will read data from Excel file and return the value to caller
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheet,int row , int cell) throws  IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();	
	}
	
	public Object[][] readDataFromExcelFile(String sheet,int firstrow , int firstcell,int lastrow,int lastcell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Object[][] data = new Object[lastrow][lastcell];
		for(int i=firstrow;i<=lastrow;i++)
		{
			for(int j=firstcell;j<=lastcell;j++)
			{
				data[i][j]= wb.getSheet(sheet).getRow(i).getCell(j).toString();	
			}
			
		}
		
		return data;
		
	}
	

}
