package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.CityData;
import housepriceModelPackage.HouseData;

public interface HouseManageService {
	//Add House Details
	public boolean addHouseDetails(HouseData housedata);
	
	//View House details
	public List<HouseData> getHouseDetails();
	
	//Delete House details
	public boolean isDeleteHouseData(int houseid);
	
	//Update house details
	public boolean isUpdateHouseData(HouseData housedata);
	
	//Count State wise House
	public int getStateHouseCount();

	//Count State wise City
	public int getStateCityCount();
	
	//Count City Wise Location
	public int getCityLocationCount();
	
	//Count City Wise House
	public int getCityHouseCount();
	
	//Count Location Wise House
	public int getLocationHouseCount();
	
	//Search House By City
	public List<HouseData> searchHouseByCity(int cityid);
	
	//Search House By Location
	public List<HouseData> searchHouseByLocation(int locationid);
	
	//Count Area wise house
	public int getAreaWiseHouse();
	
	//Get area wise price
	public List<Object[]> getAreaPrice(int locationid, int area);
	
	//Calculate min value of area
	public int getMinValueOfArea(int locationid);
	
	//Calculate min value of price
	public int getMinValueOfPrice(int locationid);
}
