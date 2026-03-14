package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.LocationData;
import housepriceRepositoryPackage.LocationRepository;
import housepriceRepositoryPackage.LocationRepositoryInterface;

public class LocationManageServiceInterface implements LocationManageService{

	LocationRepository locationrepo = new LocationRepositoryInterface();
	
	@Override
	public boolean isAddLocation(LocationData locationdata) {
		return locationrepo.isAddLocation(locationdata);
	}

	@Override
	public List<LocationData> getLocations() {
		return locationrepo.getLocations();
	}

	@Override
	public boolean isLocationDelete(int locationid) {
		return locationrepo.isLocationDelete(locationid);
	}

	@Override
	public boolean isUpdateLocationData(LocationData locationdata) {
		return locationrepo.isUpdateLocationData(locationdata);
	}

	@Override
	public List<LocationData> getLocationByCityId(int cityid) {
		// TODO Auto-generated method stub
		return locationrepo.getLocationByCityId(cityid);
	}

}
