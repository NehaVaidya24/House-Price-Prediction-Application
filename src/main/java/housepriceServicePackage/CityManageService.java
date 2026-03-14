package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.CityData;
import housepriceModelPackage.StateData;

public interface CityManageService {
	public boolean isAddCity(CityData citydata);
	public List<CityData> getCities();
	public boolean isCityDelete(int cityid);
	public boolean isUpdateCityData(CityData citydata);
	public List<CityData> getAllCitiesByStateID(int stateid);
}
