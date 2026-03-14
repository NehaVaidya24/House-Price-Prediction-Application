package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.LocationData;

public interface LocationManageService {
	public boolean isAddLocation(LocationData locationdata);
	public List<LocationData> getLocations();
	public boolean isLocationDelete(int locationid);
	public boolean isUpdateLocationData(LocationData locationdata);
	public List<LocationData> getLocationByCityId(int cityid);
}
