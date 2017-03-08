package com.SAFUI.Utils;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.*;
import org.apache.poi.ss.usermodel.*;


public class ReadExcelFile {
	
		File 	file =null;
		FileInputStream inputStream;
		public 	XSSFWorkbook workbook ;
		public 	XSSFSheet sheet;
		public  XSSFRow Row;
		public  XSSFCell cell;
		    
		public  Object[][] Testdata;
		public 	Object[][] deletetestdata;
		String 	sheet1 = "Add new rule";
		String 	sheet2 = "Delete Rule";
		String  sheet3 = "Edit Rule";
		String  sheet4 = "Enable/Disable Rule";
		String 	basepath;
		String 	filenm;
		
	   
	    protected ReadingProperties properties;
	    
	    public ReadExcelFile(){
	    	properties =new ReadingProperties();
			properties.loadProperty();
			
			basepath=System.getProperty("user.dir")+properties.Settingprop.getProperty("excelfilepath");
			filenm = properties.Settingprop.getProperty("excelfilename");
	    }
	    
	    
	    
	    public Object[][] readExcelSheet(String filePath,String fileName,String sheetName) {
	    
	    		file = new File(filePath+"\\"+fileName);
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


		@DataProvider (name = "Addnewruletestdata")
		public Object[][] getAddNewRuleTestData(){

			Testdata = readExcelSheet (basepath,filenm,sheet1);
			return Testdata;
		}
		
		
		
		@DataProvider(name="Deleteruletestdata")
		public Object[][] getDeleteRuleTestData(){
			deletetestdata=readExcelSheet(basepath, filenm, sheet2);	
			return deletetestdata;
		}
		
		
		@DataProvider(name="Editruletestdata")
		public Object[][] getEditRuleTestData(){
			deletetestdata=readExcelSheet(basepath, filenm, sheet3);	
			return deletetestdata;
		}
		
		
		@SuppressWarnings("deprecation")
		public  String getCellData(String sheetName, int row, int col){
	    	
	    	// Cell = new XSSFCell(Row, null);
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
		            return String.valueOf(cell.getNumericCellValue());          

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
	            	return "row " + row + " or column " + col+ " does not exist in xls";
	            }

	    }
}
