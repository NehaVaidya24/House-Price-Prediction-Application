package housepriceRepositoryPackage;
import java.util.*;
import housepriceModelPackage.CityData;
import housepriceModelPackage.HouseData;

public interface CityRepository {
	public boolean isAddCity(CityData citydata);
	public List<CityData> getCities();
	public boolean isCityDelete(int cityid);
	public boolean isUpdateCityData(CityData citydata);
	public List<CityData> getAllCitiesByStateID(int stateid);
}
