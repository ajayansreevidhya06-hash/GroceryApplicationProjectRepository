package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility 
{
	
	
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	
	//i=row j=column
	public static String readStringData(int row,int column,String sheet) throws IOException
	{                          
		//f=new FileInputStream("C:\\Users\\manoj\\git\\GroceryApplicationProjectRepository\\GroceryApplicationProject\\src\\test\\resources\\TestData.xlsx");
		f=new FileInputStream(Constants.TESTDATAFILE);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);    //predefined class   ////to fetch row
		XSSFRow r=s.getRow(row);//non prim data type class ////to fetch column
		XSSFCell c=r.getCell(column); //to fetch column-predefined method
		return c.getStringCellValue();
		
	}
	
	public static double readIntegerData(int row,int column,String sheet) throws IOException
	{
		//f=new FileInputStream("C:\\Users\\manoj\\git\\GroceryApplicationProjectRepository\\GroceryApplicationProject\\src\\test\\resources\\TestData.xlsx");
		//path added in constants class
		f=new FileInputStream(Constants.TESTDATAFILE);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(row);     //non prim data type  ////to fetch row
		XSSFCell c=r.getCell(column);    //to fetch column
		return c.getNumericCellValue();
	}

}
