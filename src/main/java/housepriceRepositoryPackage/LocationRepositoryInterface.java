package housepriceRepositoryPackage;

import java.util.ArrayList;
import java.util.List;

import housepriceDBConfig.DBConfig;
import housepriceModelPackage.CityData;
import housepriceModelPackage.LocationData;

public class LocationRepositoryInterface extends DBConfig implements LocationRepository{

	@Override
	public boolean isAddLocation(LocationData locationdata) {
		try
		{
			pstmt = connection.prepareStatement("insert into Location values('0',?,?)");
			pstmt.setString(1, locationdata.getLocationname());
			pstmt.setInt(2, locationdata.getCityid());
			int value = pstmt.executeUpdate();
			if(value > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Error : " +e);
			return false;
		}
	}

	List<LocationData> locationlist;
	@Override
	public List<LocationData> getLocations() {
		   try {
		        locationlist = new ArrayList<>();
		        pstmt = connection.prepareStatement(
		            "select Location.locationid, Location.locationname, Location.cityid, City.cityname " +
		            "from City inner join Location on Location.cityid = City.cityid"
		        );
		        resultset = pstmt.executeQuery();
		        while(resultset.next()) {
		            LocationData locationdata = new LocationData();
		            locationdata.setLocationid(resultset.getInt("locationid"));
		            locationdata.setLocationname(resultset.getString("locationname"));
		            locationdata.setCityid(resultset.getInt("cityid"));  // ✅ set cityid
		            locationdata.setCityname(resultset.getString("cityname"));
		            locationlist.add(locationdata);
		        }
		        if(locationlist.size() > 0) {
		            return locationlist;
		        } else {
		            return null;
		        }
		    } catch(Exception e) {
		        System.out.println("Error : " + e);
		        return null;
		    }
	}

	@Override
	public boolean isLocationDelete(int locationid) {
		try
		{
			pstmt = connection.prepareStatement("delete from Location where locationid=?");
			pstmt.setInt(1, locationid);
			int value = pstmt.executeUpdate();
			if(value > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
			return false;
		}
	}

	@Override
	public boolean isUpdateLocationData(LocationData locationdata) {
		try
	    {
	        pstmt = connection.prepareStatement("update Location set locationname=?, cityid=? where locationid=?");
	        pstmt.setString(1, locationdata.getLocationname());
	        pstmt.setInt(2, locationdata.getCityid());
	        pstmt.setInt(3, locationdata.getLocationid()); 

	        int value = pstmt.executeUpdate();
	        if(value > 0)
	        {
	            return true;
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error : " + e);
	    }
		return false;
	}

	@Override
	public List<LocationData> getLocationByCityId(int cityid) {
		try
		{
			locationlist = new ArrayList<>();
			pstmt = connection.prepareStatement("select Location.locationid, Location.locationname from Location where cityid = ?");
			
			pstmt.setInt(1, cityid);
			
			resultset = pstmt.executeQuery();
	        while(resultset.next()) {
	        	LocationData locationdata = new LocationData();

	        	locationdata.setLocationid(resultset.getInt("locationid"));
	        	locationdata.setLocationname(resultset.getString("locationname"));

	        	locationlist.add(locationdata);
	        }
	        if(locationlist.size() > 0) {
	            return locationlist;
	        } else {
	            return null;
	        }
			
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		return null;
	}

}
