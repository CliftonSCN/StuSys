package com.clifton.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取excel
 * 
 * @author Clifton
 * @date 2019年8月6日 上午8:18:35
 * @project stusys
 */
public class ReadExcelUtils {

	private static Logger logger= LoggerFactory.getLogger(ReadExcelUtils.class);

	@SuppressWarnings("deprecation")
	public static String getCell(XSSFCell cell) {
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC: // 数字
			return String.valueOf(cell.getNumericCellValue()).trim();
		case HSSFCell.CELL_TYPE_STRING: // 字符串
			return cell.getStringCellValue().trim();
		case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
			return String.valueOf(cell.getBooleanCellValue()).trim();
		case HSSFCell.CELL_TYPE_FORMULA: // 公式
			return String.valueOf(cell.getCellFormula()).trim();
		case HSSFCell.CELL_TYPE_BLANK: // 空值
			return "";
		case HSSFCell.CELL_TYPE_ERROR: // 故障
			System.out.println("ERROR");
			return "error";
		default:
			System.out.print("未知类型  ");
			return "未知";
		}
	}

	public static Map<String, List<String>> readXlse(String realPath) {
		Map<String, List<String>> map = new HashMap<>();
		InputStream stream = null;
		XSSFWorkbook xssfWorkbook = null;
		try {
			stream = new FileInputStream(realPath);
			xssfWorkbook = new XSSFWorkbook(stream);
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
			int rowstart = xssfSheet.getFirstRowNum();
			int rowEnd = xssfSheet.getLastRowNum();
			XSSFRow row0 = xssfSheet.getRow(0);
			int cellStart = row0.getFirstCellNum();
			int cellEnd = row0.getLastCellNum();
			for (int i = cellStart; i < cellEnd; i++) {
				List<String> column = new ArrayList<>();
				map.put(getCell(row0.getCell(i)), column);
				try {
				} catch (Exception e) {
 					return map;
				}
				for (int j = rowstart + 1; j < rowEnd; j++) {
					XSSFRow row = xssfSheet.getRow(j);
					try {
						column.add(getCell(row.getCell(i)));
					} catch (NullPointerException e) {
	 					return map;
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.debug("文件找不到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stream.close();
				xssfWorkbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		String path = "C:\\\\Users\\\\lenovo\\\\Desktop\\\\信息学院学校B软件161.xlsx";
		Map<String, List<String>> map = readXlse(path);
		System.out.println(map);
	}
}
