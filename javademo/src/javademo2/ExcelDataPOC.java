package javademo2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */

/**
 * @author MRINAL VATS
 *
 */
class StateInfo{
	String countryName ;
	String countryId;
	String stateName;
	String stateId;
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
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * @return the stateId
	 */
	public String getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Info [countryName=" + countryName + ", countryId=" + countryId + ", stateName=" + stateName
				+ ", stateId=" + stateId + "]";
	}

}
class Info{
	String name ;
	String id;

	@Override
	public String toString() {
		return "Info [name=" + name + ", id=" + id + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
class CityInfo{
	String countryName;
	String countryId;
	String stateId;
	String stateName;
	String cityName;
	String cityId;
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
	/**
	 * @return the stateId
	 */
	public String getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityInfo [countryName=" + countryName + ", countryId=" + countryId + ", stateId=" + stateId
				+ ", stateName=" + stateName + ", cityName=" + cityName + ", cityId=" + cityId + "]";
	}
	
	
}
public class ExcelDataPOC {
	private static final String FILE_NAME = "C://Users//mrinalvatsya//Desktop//CountryList.xlsx";

	public static void main(String[] args) {
		Path path = Paths.get("C:/Users/mrinalvatsya/Desktop/StateQuery.txt");
		Map<String,Map<String,String>> countryStateMap = new HashMap<>();
		try(BufferedWriter writer = Files.newBufferedWriter(path)) {
			Integer countryId = 322;
			int i;
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			List<Info> infoList = new ArrayList<Info>();
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Map<String,String> countryMap = new HashMap<>();
			Boolean skipHeader = true;
			for(Row row: datatypeSheet)
			{
				if(skipHeader)
				{
					skipHeader = false;
					continue;
				}

				List<Cell> list = new ArrayList<>();
				for(int cn = 0 ; cn < 2; cn++)
				{
					Cell c = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
					list.add(c);
				}
				Info info = extractInfoFromCell(list);
				infoList.add(info);
			}	
			for(i = 0; i < infoList.size(); i++)
			{
				Info item = infoList.get(i);
				if(item.getId() == null)
				{
					//System.out.println("insert into Country_Mst (Country_ID,Name,Description,Region_ID,Status_ID,IP_Address,C_User_ID,C_Date,U_User_ID,U_Date) "
					//							+ "values ("+countryId+",'"+item.getName()+"','"+item.getName()+"',1,10,'1.1.1.1',3014,GETDATE(),3014,GETDATE());");
					
					writer.write("insert into Country_Mst (Country_ID,Name,Description,Region_ID,Status_ID,IP_Address,C_User_ID,C_Date,U_User_ID,U_Date) "
														+ "values ("+countryId+",'"+item.getName()+"','"+item.getName()+"',1,10,'1.1.1.1',3014,GETDATE(),3014,GETDATE());");
					writer.write('\n');
					countryMap.put(item.getName(), countryId.toString());
					countryId++;
				}
				else if(item.getId() != null)
				{
					countryMap.put(item.getName(), item.getId());
				}
			}
			
			
		/*	countryMap.forEach((k,v)->{
				if(v == null || v.length() == 0)
				{
					System.out.println(k + "is empty");
				}
			}); */
			datatypeSheet = workbook.getSheetAt(1);
			skipHeader = true;
			List<StateInfo> stateInfoList = new ArrayList<>();
			Map<String,String> stateMap = new HashMap<>();
			Integer stateId = 1349;
			for(Row row: datatypeSheet)
			{
				if(skipHeader)
				{
					skipHeader = false;
					continue;
				}

				List<Cell> stateList = new ArrayList<>();
				for(int cn = 0 ; cn < 4; cn++)
				{
					Cell c = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
					stateList.add(c);
				}
				StateInfo info = extractInfoFromCountryStateCell(stateList);
				stateInfoList.add(info);
			}	
			int recordCount = 1;

			
			//System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
			Integer count = 0;
			for(i = 0; i < stateInfoList.size() ; i++)
			{
				StateInfo item = stateInfoList.get(i);
				
				
				if(!(item.getCountryId() != null && item.getStateId() != null)) {
					count ++;
					String countryIdPrint = item.getCountryId();
					if(countryIdPrint == null || countryIdPrint.length() == 0) {
						countryIdPrint = countryMap.get(item.getCountryName());
					}
					
					
					if(countryIdPrint == null) {
						System.out.println(item.getCountryName());
					}
					String stateIdPrint = stateId.toString();
					
					Map<String,String> stateMapData = countryStateMap.get(countryIdPrint);
					if(stateMapData == null) {
						stateMapData = new HashMap<>();
					}
					
					stateMapData.put(item.getStateName(), stateIdPrint);
					countryStateMap.put(countryIdPrint, stateMapData);
					
					//System.out.println("insert into State_Mst (State_ID, Name , Description, Country_ID, Status_ID , IP_Address, C_User_ID, C_Date, U_User_ID, U_Date)" 
					//		+ "values ("+stateIdPrint +", '"+item.getStateName()+"' , '"+item.getStateName()+"' , "+countryIdPrint+" , 10 , '1.1.1.1' , 0 , GETDATE(), -1, GETDATE());");
					
					writer.write("insert into State_Mst (State_ID, Name , Description, Country_ID, Status_ID , IP_Address, C_User_ID, C_Date, U_User_ID, U_Date)" 
							+ "values ("+stateIdPrint +", '"+item.getStateName()+"' , '"+item.getStateName()+"' , "+countryIdPrint+" , 10 , '1.1.1.1' , 0 , GETDATE(), -1, GETDATE());");
					writer.write('\n');
					
					stateId++;
				}else {
					System.out.println("item.getCountryName() " + item.getCountryName() + " item.getStateName() " + item.getStateName());
					Map<String,String> stateMapData = countryStateMap.get(item.getCountryId());
					if(stateMapData == null) {
						stateMapData = new HashMap<>();
					}
					
					stateMapData.put(item.getStateName(), item.getStateId());
					countryStateMap.put(item.getCountryId(), stateMapData);
				}
/*				if(item.getCountryId() == null && item.getStateId() == null)
				{
					writer.write("insert into State_Mst (State_ID, Name , Description, Country_ID, Status_ID , IP_Address, C_User_ID, C_Date, U_User_ID, U_Date)" 
							+ "values ("+stateId +", '"+item.getStateName()+"' , '"+item.getStateName()+"' , "+countryMap.get(item.getCountryName())+" , 10 , '1.1.1.1' , 0 , GETDATE(), -1, GETDATE());");
//					System.out.println("insert into State_Mst (State_ID, Name , Description, Country_ID, Status_ID , IP_Address, C_User_ID, C_Date, U_User_ID, U_Date)" 
//					+ "values ("+stateId +", '"+item.getStateName()+"' , '"+item.getStateName()+"' , "+countryMap.get(item.getCountryName())+" , 10 , '1.1.1.1' , 0 , GETDATE(), -1, GETDATE());");
					writer.write('\n');

					stateMap.put(item.getStateName(), stateId.toString());
					stateId++;
					recordCount++;
				}
				

				if(item.getCountryId() != null && item.getStateId() == null)
				{

					writer.write("insert into State_Mst (State_ID, Name , Description, Country_ID, Status_ID , IP_Address, C_User_ID, C_Date, U_User_ID, U_Date)" 
							+ "values ("+stateId +", '"+item.getStateName()+"' , '"+item.getStateName()+"' , "+item.getCountryId()+" , 10 , '1.1.1.1' , 0 , GETDATE(), -1, GETDATE());");
//					System.out.println("insert into State_Mst (State_ID, Name , Description, Country_ID, Status_ID , IP_Address, C_User_ID, C_Date, U_User_ID, U_Date)" 
//					+ "values ("+stateId +", '"+item.getStateName()+"' , '"+item.getStateName()+"' , "+item.getCountryId()+" , 10 , '1.1.1.1' , 0 , GETDATE(), -1, GETDATE());");
					writer.write('\n');
					stateMap.put(item.getStateName(), stateId.toString());
					stateId++;
					recordCount++;
				}
				
				if(item.getCountryId() != null && item.getStateId() != null)
				{
					stateMap.put(item.getStateName(), item.getStateId());
				}
*/
			}
			System.out.println("count " + count);
//			stateMap.forEach((k,v)->{
//				System.out.println(k +"\t\t\t\t" + v);
//			});
			//for city list..................
			skipHeader = true;
			datatypeSheet = workbook.getSheetAt(2);
			List<CityInfo> cityInfoList = new ArrayList<>();
			Map<String, String> cityListMap = new HashMap<>();
			Integer cityId = 4512;
			stateId = 1349;
			String presentStateName = "";
			for(Row row: datatypeSheet)
			{
				if(skipHeader)
				{
					skipHeader = false;
					continue;
				}

				List<Cell> cityList = new ArrayList<>();
				for(int cn = 0 ; cn < 6; cn++)
				{
					Cell c = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
					cityList.add(c);
				}
				CityInfo info = extractCityInfoFromCell(cityList);
				cityInfoList.add(info);
			}	
			for(i = 0; i < cityInfoList.size() ; i++)
			{
				CityInfo item = cityInfoList.get(i);
				
				if(item.getCityId() == null || item.getCityId().length() == 0) {
					String countryIdPrint = item.getCountryId();
					if(countryIdPrint == null || countryIdPrint.length() == 0) {
						countryIdPrint = countryMap.get(item.getCountryName());
					}
					
					String stateIdPrint = item.getStateId();
					Map<String,String> stateMapData = countryStateMap.get(countryIdPrint);
					if(stateMapData != null) {
						stateIdPrint = stateMapData.get(item.getStateName());
					} 
					
				/*	String stateIdPrint = "";
					if(!presentStateName.equals(item.getStateName())) {
						presentStateName = item.getStateName();
						stateIdPrint = stateId.toString();
						stateId++;
					}else {
						stateIdPrint = stateId.toString();
					} */
					
					
					if(stateIdPrint == null) {
						System.out.println(item.getCityName() + " " + item.getStateName() + " " + item.getCountryName());
					}
					
					writer.write("insert into City_Mst (City_ID, Name, Description , State_ID, Status_ID, IP_Address, C_User_ID , C_Date , U_User_ID, U_Date)" +  
							"values("+cityId+", '"+item.getCityName()+"', '"+item.getCityName()+"', "+stateIdPrint+", 10, '1.1.1.1' , 0, GETDATE(), -1, GETDATE());");
								writer.write('\n');
								
								cityId++;
				}
			/*	if(item.getCountryId() == null && item.getStateId() == null && item.getCityId() == null)
				{
					writer.write("insert into City_Mst (City_ID, Name, Description , State_ID, Status_ID, IP_Address, C_User_ID , C_Date , U_User_ID, U_Date)" +  
				"values("+cityId+", '"+item.getCityName()+"', '"+item.getCityName()+"', "+stateMap.get(item.getStateName())+", 10, '1.1.1.1' , 0, GETDATE(), -1, GETDATE());");
					writer.write('\n');
					cityListMap.put(item.getCityName(), cityId.toString());
					cityId++;
				}
				
				else if(item.getCountryId() != null && item.getStateId() != null && item.getCityId() == null)
				{
					writer.write("insert into City_Mst (City_ID, Name, Description , State_ID, Status_ID, IP_Address, C_User_ID , C_Date , U_User_ID, U_Date)" +  
							"values("+cityId+", '"+item.getCityName()+"', '"+item.getCityName()+"', "+item.getStateId()+", 10, '1.1.1.1' , 0, GETDATE(), -1, GETDATE());");
					writer.write('\n');
					cityListMap.put(item.getCityName(), cityId.toString());
					cityId++;
				}
				
				else if(item.getCountryId() != null && item.getStateId() == null && item.getCityId() == null)
				{
					writer.write("insert into City_Mst (City_ID, Name, Description , State_ID, Status_ID, IP_Address, C_User_ID , C_Date , U_User_ID, U_Date)" +  
							"values("+cityId+", '"+item.getCityName()+"', '"+item.getCityName()+"', "+stateMap.get(item.getStateName())+", 10, '1.1.1.1' , 0, GETDATE(), -1, GETDATE());");
					writer.write('\n');
					cityListMap.put(item.getCityName(), cityId.toString());
					cityId++;
				}
				
				else if(item.getCountryId() == null && item.getStateId() == null && item.getCityId() != null)
				{
					cityListMap.put(item.getCityName(), item.getCityId());
				}
				else if(item.getCountryId() == null && item.getStateId() != null && item.getCityId() == null)
				{
					cityListMap.put(item.getCityName(), cityId.toString());
					cityId++;
				}
				else if(item.getCountryId() == null && item.getStateId() != null && item.getCityId() != null)
				{
					cityListMap.put(item.getCityName(), item.getCityId());
				}
				else if(item.getCountryId() != null && item.getStateId() == null && item.getCityId() != null)
				{
					cityListMap.put(item.getCityName(), item.getCityId());
				} */
				
			}
			

			System.out.println(cityInfoList.size());
			System.out.println(cityListMap.size());
			System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	private static StateInfo extractInfoFromCountryStateCell(List<Cell> cells) {
		StateInfo info = new StateInfo();
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

		Cell stateNameCell = cells.get(2);
		if(stateNameCell != null)
		{
			stateNameCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setStateName(stateNameCell.getStringCellValue());
		}

		Cell stateIdCell = cells.get(3);
		if(stateIdCell != null)
		{
			stateIdCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setStateId(stateIdCell.getStringCellValue());
		}
		return info;
	}

	private static Info extractInfoFromCell(List<Cell> cells) {
		Info info = new Info();
		Cell nameCell = cells.get(0);
		if (nameCell != null) {
			nameCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setName(nameCell.getStringCellValue());
		}
		Cell mobileCell = cells.get(1);
		if (mobileCell != null) {
			mobileCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setId(mobileCell.getStringCellValue());
		}

		return info;
	}
	
	private static CityInfo extractCityInfoFromCell(List<Cell> cells) {
		CityInfo info = new CityInfo();
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
		
		Cell stateIdCell = cells.get(2);
		if(stateIdCell != null)
		{
			stateIdCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setStateId(stateIdCell.getStringCellValue());
		}
		
		Cell stateNameCell = cells.get(3);
		if(stateNameCell != null)
		{
			stateNameCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setStateName(stateNameCell.getStringCellValue());
		}
		
		Cell cityIdCell = cells.get(4);
		if(cityIdCell != null)
		{
			cityIdCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setCityId(cityIdCell.getStringCellValue());

		}
		
		Cell cityNameCell = cells.get(5);
		if(cityNameCell != null)
		{
			cityNameCell.setCellType(Cell.CELL_TYPE_STRING);
			info.setCityName(cityNameCell.getStringCellValue());
		}
		return info;
	} 
}