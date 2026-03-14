package housepriceRepositoryPackage;

import java.util.ArrayList;
import java.util.List;

import housepriceDBConfig.DBConfig;
import housepriceModelPackage.CityData;

public class CityRepositoryInterface extends DBConfig implements CityRepository{

	public boolean isAddCity(CityData citydata) {
		try
		{
			pstmt = connection.prepareStatement("insert into city values('0',?,?)");
			pstmt.setString(1, citydata.getCityname());
			pstmt.setInt(2, citydata.getStateid());
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

	List<CityData> citylist;
	@Override
	public List<CityData> getCities() {
		 try {
		        citylist = new ArrayList<>();
		        pstmt = connection.prepareStatement(
		            "select City.cityid, City.cityname, City.stateid, State.statename " +
		            "from State inner join city on State.stateid = City.stateid"
		        );
		        resultset = pstmt.executeQuery();
		        while(resultset.next()) {
		            CityData citydata = new CityData();
		            citydata.setCityid(resultset.getInt("cityid"));
		            citydata.setCityname(resultset.getString("cityname"));
		            citydata.setStateid(resultset.getInt("stateid"));   // ✅ add this line
		            citydata.setStatename(resultset.getString("statename"));
		            citylist.add(citydata);
		        }
		        if(citylist.size() > 0) {
		            return citylist;
		        } else {
		            return null;
		        }
		    } catch(Exception e) {
		        System.out.println("Error : " + e);
		        return null;
		    }
	}
	
	@Override
	public boolean isCityDelete(int cityid) {
		try
		{
			pstmt = connection.prepareStatement("delete from City where cityid=?");
			pstmt.setInt(1, cityid);
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
	public boolean isUpdateCityData(CityData citydata) {
		try
	    {
	        pstmt = connection.prepareStatement("update City set cityname=?, stateid=? where cityid=?");
	        pstmt.setString(1, citydata.getCityname());
	        pstmt.setInt(2, citydata.getStateid());
	        pstmt.setInt(3, citydata.getCityid()); 

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
	public List<CityData> getAllCitiesByStateID(int stateid) {
		try
		{
			citylist = new ArrayList<>();
			pstmt = connection.prepareStatement("select City.cityid, City.cityname from City where stateid = ?");
			
			pstmt.setInt(stateid, stateid);
			
			resultset = pstmt.executeQuery();
	        while(resultset.next()) {
	        	  CityData citydata = new CityData();

	              citydata.setCityid(resultset.getInt("cityid"));
	              citydata.setCityname(resultset.getString("cityname"));

	              citylist.add(citydata);
	        }
	        if(citylist.size() > 0) {
	            return citylist;
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
