package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
//	public List<String> Excelreader() throws IOException
	public static void main() throws IOException
	{
//		Importing file>> assigning it to Workbook obj
		FileInputStream efil= new FileInputStream("C:\\Users\\POOJASRA\\AutomationWs2\\eclipse-workspace\\eclipse-workspace\\EpsMvnCuc\\src\\main\\java\\utilities\\EpExcldata.xlsx");
		Workbook Epbook = new XSSFWorkbook(efil);
		
//		goto sheets
		int sheets= Epbook.getNumberOfSheets();
		System.out.println("no.of sheets=="+sheets);		
		Sheet epsht= Epbook.getSheetAt(0);
		
//		goto each row
		Iterator<Row> erows= epsht.iterator();
		
//		candidate data
		List<String> cdata= new ArrayList<String>();
		
		while(erows.hasNext()) //true, if any row exist in that sheet 
		{
			Row row=erows.next(); // goes to first row that exists
			Iterator<Cell> cols=row.cellIterator();
			
//			goes to column of the row, i.e. each cell that has data
			while(cols.hasNext()) //true, if any column exists data in that row 
			{
				Cell edata = cols.next(); // iterates each cell
				String data=edata.toString();
				if(edata.getCellType()==CellType.NUMERIC)
				{
					//System.out.println((int)value.getNumericCellValue());
					int num=(int)edata.getNumericCellValue();
					data=num+"";
					
					cdata.add(data);
				}
				else
				{
					cdata.add(edata+"");
				}
				
			}
			
			
		}
		for(String data:cdata)
		{
		  System.out.println(":"+data);
		}
//		return cdata;
		
	}

	
	}	


