package UtilityRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadSample 
{
static FileInputStream f;
static XSSFWorkbook w;
static XSSFSheet s;



	public  ExcelReadSample() throws Exception
	{
		f=new FileInputStream("D:\\Java (Shone)\\PageFactoryProject\\src\\main\\resources\\Excel File\\ExcelReadSample.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet("Sheet1");
	}
    public static String readingStringData(int i,int j) 
    {
    	Row r=s.getRow(i);
		Cell c=r.getCell(j);
		return c.getStringCellValue();
    }
    public static String readingIntegerData(int i,int j)
    {
    	Row r=s.getRow(i);
		Cell c=r.getCell(j);
		int a=(int)c.getNumericCellValue();
		return String.valueOf(a);
    }
    
}
	
	



			