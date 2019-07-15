package javademo2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.common.*;


/**
 * 
 */

/**
 * @author MRINAL VATS
 *
 */

class CountryInfo{
	String countryName ;
	String countryId;
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @return the countryId
	 */
	public String getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryInfo [countryName=" + countryName + ", countryId=" + countryId + "]";
	}



}
public class CountryExcelPOC {

	private static final String FILE_NAME = "C://Users//mrinalvatsya//Desktop//Copy of Countries_Cities_Data_Final.xlsx";

	public static void main(String[] args) {

		try {

			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					String cellValue = currentCell.getStringCellValue();
					//getCellTypeEnum shown as deprecated for version 3.15
					//getCellTypeEnum ill be renamed to getCellType starting from version 4.0
					if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.print(currentCell.getStringCellValue() + "--");
					}
					
					if(currentCell == null)
					{
						//
					}
					
				}
				System.out.println();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	private static CountryInfo extractInfoFromCell(List<Cell> cells) {
		CountryInfo info = new CountryInfo();
		Cell nameCell = cells.get(0);
		if (nameCell != null) {
			nameCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setCountryName(nameCell.getStringCellValue());
		}
		Cell mobileCell = cells.get(1);
		if (mobileCell != null) {
			mobileCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setCountryId(mobileCell.getStringCellValue());
		}

		return info;
	}
}
