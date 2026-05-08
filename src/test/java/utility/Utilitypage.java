package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilitypage {
	public static String getCellValue(String sheet,int r,int c)
	{

	try{
		File f=new File("C:\\Users\\athir\\OneDrive\\Documents\\datadrivenasian.xlsx");
		FileInputStream fi=new FileInputStream(f);
		try (XSSFWorkbook wb = new XSSFWorkbook(fi)) {
			XSSFCell cell=(XSSFCell) wb.getSheet(sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				return cell.getRawValue();
			}
		}
		
	}
	catch(Exception e)
	{
		
		return "";
	}
	
	
	}

public static int getRowCount(String sheet)
{
	try
	{
		File f=new File("C:\\Users\\athir\\OneDrive\\Documents\\datadrivenasian.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		return wb.getSheet(sheet).getLastRowNum();
	}
	catch(Exception e)
	{
		return 0;
		
	}
}

	}
    
