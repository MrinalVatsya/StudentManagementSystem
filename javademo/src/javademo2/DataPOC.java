/**
 * 
 */
package javademo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author mrinalvatsya
 *
 */
public class DataPOC {

	private static final String FILE_NAME = "C://Users//mrinalvatsya//Desktop//Copy of Countries_Cities_Data_Final.xlsx";

	public static void main(String[] args) {

		try {

			Map<String,Integer> countryIdMap = new HashMap<>();
			Integer countryId = 322;

			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));

			Workbook workbook = new XSSFWorkbook(excelFile);
			System.out.println("///////////////////////////////////////////////////////////");
			for(int i = 0 ; i < 1 ; i++ )
			{
				Sheet datatypeSheet = workbook.getSheetAt(i);//getting first sheet
				Iterator<Row> iterator = datatypeSheet.iterator();
				while (iterator.hasNext()) {

					Row currentRow = iterator.next();

					Iterator<Cell> cellIter = currentRow.iterator();
					while(cellIter.hasNext())
					{
						
						
						
						Cell cell1 = cellIter.next();
						 if (cell1== null || cell1.getCellType() == Cell.CELL_TYPE_BLANK) {
							    System.out.println("khali hai");
							 }
						 else
						System.out.println(cell1.toString());
					}
					}
					
				}

			

			System.out.println("///////////////////////////////////////////////////////////");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
