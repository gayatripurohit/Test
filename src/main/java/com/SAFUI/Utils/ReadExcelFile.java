package com.SAFUI.Utils;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;


public class ReadExcelFile {
	
		File 	file =null;
		FileInputStream inputStream;
		public 	XSSFWorkbook workbook ;
		public 	XSSFSheet sheet;
		public  XSSFRow Row;
		public  XSSFCell cell;
		protected ReadingProperties properties;
		public  Object[][] Testdata;
	
		String 	basepath, 	filenm;
	    
	    
	    
	    public ReadExcelFile(){
	    	properties =new ReadingProperties("ConfigCenter.properties");
		
			basepath=System.getProperty("user.dir")+properties.CONFIG.getProperty("excelfilepath");
			filenm = properties.CONFIG.getProperty("excelfilename");
			file = new File(basepath+"\\"+filenm);
	    }
	    
	    
	    
	    public Object[][] readExcelSheet(String fileName, String sheetName) {
	    
	    		
	    		try {
				inputStream = new FileInputStream(file);
			
			    //Find the file extension by spliting file name in substring and getting only extension name
			    String fileExtensionName = fileName.substring(fileName.indexOf("."));
			    //Check condition
		
			    if(fileExtensionName.equals(".xlsx")){
					workbook = new XSSFWorkbook(inputStream);
		
			    }
			    else if(fileExtensionName.equals(".xls")){
						//workbook = new HSSFWorkbook(inputStream);
				} 
		
			    //Read sheet inside the workbook by its name
			    sheet = workbook.getSheet(sheetName);
			    
			    int rowCount = sheet.getLastRowNum(); 
		        int colCount = sheet.getRow(0).getLastCellNum();

		        Testdata = new Object[rowCount][colCount];
				
		        for (int rCnt=1; rCnt<=rowCount;rCnt++){
		            for (int cCnt=0; cCnt<colCount;cCnt++){
		            	String celldata = getCellData(sheetName, rCnt, cCnt);
		            	 Testdata[rCnt-1][cCnt]= celldata; 
		            }
		        }			    
			}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return Testdata;
	   }


	    @SuppressWarnings("deprecation")
		public  String getCellData(String sheetName, int row, int col){	    	
	        try {
	            int index = workbook.getSheetIndex(sheetName);
	            sheet = workbook.getSheetAt(index);
	            Row = sheet.getRow(row);
	            if (Row == null)
	            return "";

	            cell = Row.getCell(col);
	            if (cell == null)
	            return "";
	            
	            switch (cell.getCellType())
	            {
	            
		            case  Cell.CELL_TYPE_STRING:
		            return cell.getStringCellValue();               
		            
		            case  Cell.CELL_TYPE_BOOLEAN:
		            return String.valueOf(cell.getBooleanCellValue());                 

		            case  Cell.CELL_TYPE_NUMERIC:
		            	  cell.setCellType(Cell.CELL_TYPE_STRING);
		            	  return String.valueOf(cell.getStringCellValue());    

		            case  Cell.CELL_TYPE_BLANK:
			            return "";      
		
		            case  Cell.CELL_TYPE_ERROR:
		            return cell.getStringCellValue();  
		            
		            default:
		            return "Cell not found";        

	            }
	        }
	            catch (Exception e) {
	            	System.out.println(e.getMessage());
	            	return "row " + row + " or column " + col+ " does not exist in xlsx";
	            }
	    }
	    
	    
		
		
}
