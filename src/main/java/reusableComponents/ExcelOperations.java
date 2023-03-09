package reusableComponents;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	
	String filePath;
	File f;
	Workbook wb;
	Sheet sh;
	
	
	public ExcelOperations(String sheetName) {
		try {
			filePath=System.getProperty("user.dir")+PropertiesOperation.getPropertyDataByKey("testDataLocation");
		}catch (Exception e) {
		}
		f=new File(filePath);
		try {
			wb = WorkbookFactory.create(f);
		}catch (Exception e) {
		}
		sh = wb.getSheet(sheetName);
	}
	
	public HashMap<String, String> getTestDataInMap(int row) throws Exception {
		
		HashMap<String,String> hm=new HashMap<String,String>();
		for(int i=0;i<sh.getRow(0).getLastCellNum();i++) {
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(row).getCell(i).toString());
		}
		return hm;
	}
	
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	public int getCellCount() {
		return sh.getRow(0).getLastCellNum();
	}
	
	
	public static void main(String[] args) {
		ExcelOperations eo=new ExcelOperations("Sheet1");
		System.out.println(eo.getRowCount());
	}
	
}
