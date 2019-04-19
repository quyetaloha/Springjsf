package ExcelFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import entity.Emp;

public class Excel {
	public static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}
	
	public static HSSFWorkbook makeHSSFWorkbook(List<Emp> list) throws ParseException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Employees sheet");

		

		int rownum = 0;
		Cell cell;
		Row row;
		//
		HSSFCellStyle style = createStyleForTitle(workbook);

		row = sheet.createRow(rownum);

		// EmpNo
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("tên nhân viên");
		cell.setCellStyle(style);
		// EmpName
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("tên phòng ban");
		cell.setCellStyle(style);
		// Salary
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Ngày vào");
		cell.setCellStyle(style);
		// Grade
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Lương");
		cell.setCellStyle(style);
		// Bonus
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Công việc");
		cell.setCellStyle(style);

		// Data
		for (Emp emp : list) {
			rownum++;
			row = sheet.createRow(rownum);
			System.out.println(emp.toString());
			// EmpNo (A)
			cell = row.createCell(0, CellType.STRING);
			if (emp.getEname() != null)
				cell.setCellValue(emp.getEname());
			else
				cell.setCellValue("");
			// EmpName (B)
			cell = row.createCell(1, CellType.STRING);
			if (emp.getDept() != null)
				cell.setCellValue(emp.getDept().getDname());
			else
				cell.setCellValue("");
			// Salary (C)
			
			cell = row.createCell(2, CellType.STRING);
			
			if (emp.getHiredate() != null) {
				System.out.println(emp.getHiredate());
				SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy");
				String s=dt.format(emp.getHiredate());
				cell.setCellValue(s);
			}
				
			else
				cell.setCellValue("");
			// Grade (D)

			cell = row.createCell(3, CellType.STRING);
			if (emp.getSal() != null)
				cell.setCellValue(emp.getSal().toString());
			else
				cell.setCellValue("");
			// Bonus (E)

			cell = row.createCell(4, CellType.STRING);
			if (emp.getJob() != null)
				cell.setCellValue(emp.getJob());
			else
				cell.setCellValue("");

			/*
			 * cell = row.createCell(4, CellType.STRING); if(emp.getSal()!=null)
			 * cell.setCellValue(emp.getSal().toString()); else cell.setCellValue("");
			 */
		}
		return workbook;
	}
}
