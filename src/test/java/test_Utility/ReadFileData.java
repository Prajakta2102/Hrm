package test_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFileData 
{
	public static String fetchDataFromExcel(int row ,int col)throws EncryptedDocumentException,IOException
	{
		String data="";
		String path="src"+File.separator+"test"+ File.separator+"resources"+File.separator+"XLSheet"+File.separator+"CityInfo.xlsx";
		FileInputStream file=new FileInputStream(path);
	    Sheet s=WorkbookFactory.create(file).getSheet("Personal_Infocity");
	   Cell c=s.getRow(row).getCell(col);
	   CellType type=c.getCellType();
	   
	   if(type==CellType.STRING)
	   {
		   data=c.getStringCellValue();
		   
	   }
	   else if(type==CellType.NUMERIC)
	   {
		   double x=c.getNumericCellValue();
   		 //String z=String.valueOf(x);
		   //int a=(int)x;//Explicit casting
	          data=Double.toString(x);//other method
		
	   }
	  
	   else  if(type==CellType.BLANK)
	   {
	    	
		   data="";
		   
		   System.out.print(s.getRow(row).getCell(col) + " ");
	   }
	  
	  
	   return  data;
	
	}

}
