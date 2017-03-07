package com.SAFUI.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.annotations.*;

public class GetExcelData extends ReadExcelFile{

	  	public  Object[][] Testdata;
	    public  String sheetname = "Add new rule";
	    public  XSSFRow Row;
	    public  XSSFCell cell;
	
	
	@DataProvider (name = "Addnewruletestdata")
	public Object[][] getAddNewRuleTestData(){
		int rowCount = sheet.getLastRowNum(); //4
        System.out.println(rowCount);
        int colCount = sheet.getRow(0).getLastCellNum(); //13
        System.out.println(colCount);

        Testdata = new Object[rowCount][colCount];
		
        for (int rCnt=1; rCnt<=rowCount;rCnt++){
            for (int cCnt=0; cCnt<colCount;cCnt++){
            	String celldata = getCellData(sheetname, rCnt, cCnt);
            	 Testdata[rCnt-1][cCnt]= celldata; 
                System.out.println(Testdata[rCnt-1][cCnt]);
            }
        }
		return Testdata;
	}
	
	
	@SuppressWarnings("deprecation")
	public  String getCellData(String Sheet, int row, int col){
    	
    	// Cell = new XSSFCell(Row, null);
        try {
            int index = workbook.getSheetIndex(Sheet);
            sheet = workbook.getSheetAt(index);
            Row = sheet.getRow(row);
            if (Row == null)
            return "";

            cell = Row.getCell(col);
            if (cell == null)
            return "";
            
            switch (cell.getCellType())
            {
            
	            case  XSSFCell.CELL_TYPE_STRING:
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
	
//	 @Test(dataProvider="getAddNewRuleTestData")
//	 public void TC01_Verify_Add_new_rule(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
//				 						String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
//				 						String timewindow,String msgtemplate, String conditionexpr,String notifyrule ){
//
//	    System.out.println(rulenm +" "+ severity + attri + filtercompa +filtertriggervalue+
//					 aggregation + metric +conditioncompa +conditiontriggervalue+
//					 timewindow +msgtemplate  +conditionexpr +notifyrule);    
//	    }
	
	
}
