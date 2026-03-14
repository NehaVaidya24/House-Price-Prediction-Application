package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.CityData;
import housepriceRepositoryPackage.CityRepositoryInterface;
import housepriceRepositoryPackage.CityRepository;

public class CityManageServiceInterface implements CityManageService{

	CityRepository cityrepo = new CityRepositoryInterface();
	@Override
	public boolean isAddCity(CityData citydata) {
		return cityrepo.isAddCity(citydata);
	}
	@Override
	public List<CityData> getCities() {
		return cityrepo.getCities();
	}
	@Override
	public boolean isCityDelete(int cityid) {
		return cityrepo.isCityDelete(cityid);
	}
	
	@Override
	public boolean isUpdateCityData(CityData citydata) {
		return cityrepo.isUpdateCityData(citydata);
	}
	
	@Override
	public List<CityData> getAllCitiesByStateID(int stateid) {
		// TODO Auto-generated method stub
		return cityrepo.getAllCitiesByStateID(stateid);
	}

}
