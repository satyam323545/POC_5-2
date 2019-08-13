package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_manipulation {
	
	
	Data data;
	@SuppressWarnings("rawtypes")
	ArrayList<ArrayList> al;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String[][] get_excel_data() {
		File file=new File("Data.xlsx");
		al =new ArrayList<ArrayList>();
		try {
			data=new Data();
			FileInputStream input=new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(input);
			XSSFSheet sheet=workbook.getSheetAt(0);
			for(int i=1;i<=sheet.getLastRowNum();i++) {
				XSSFRow row=sheet.getRow(i);
				ArrayList ex = new ArrayList();
				ex.add(row.getCell(0));
				ex.add(row.getCell(1));al.add(ex);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String k[][]=new String[al.size()][2];
		for(int i=0;i<al.size();i++) {
			for(int j=0; j<al.get(i).size(); j++) {
				k[i][j] = al.get(i).get(j).toString();
				
			}
		}
		
		return k;
	}
	
//	public String[][] get_excel_data() {
//		File file=new File("Data.xlsx");
//		ArrayList<Data> al=new ArrayList<Data>();
//		try {
//			data=new Data();
//			FileInputStream input=new FileInputStream(file);
//			XSSFWorkbook workbook=new XSSFWorkbook(input);
//			XSSFSheet sheet=workbook.getSheetAt(0);
//			for(int i=1;i<=sheet.getLastRowNum();i++) {
//				XSSFRow row=sheet.getRow(i);
//				data.email=row.getCell(0).getStringCellValue();
//				data.password=row.getCell(1).getStringCellValue();
//				
//				al.add(data);
//			}			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String k[][]=new String[al.size()][2];
//		for(int i=0;i<al.size();i++) {
//			k[i][0]=al.get(i).email;
//			k[i][1]=al.get(i).password;
//			System.out.println(k[i][0]);
//			
//		}
//		return k;
//	}
	
	
}
