package housepriceRepositoryPackage;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import housepriceDBConfig.DBConfig;
import housepriceModelPackage.HouseData;
import housepriceModelPackage.LocationData;

public class HouseRepositoryInterface extends DBConfig implements HouseRepository{

	@Override
	public boolean addHouseDetails(HouseData housedata) {
		try
		{
		    pstmt = connection.prepareStatement(
		        "insert into House(housename,stateid,cityid,locationid,area,bedroom,bathroom,houseyear,price) values(?,?,?,?,?,?,?,?,?)"
		    );

		    pstmt.setString(1, housedata.getHousename());
		    pstmt.setInt(2, housedata.getStateid());
		    pstmt.setInt(3, housedata.getCityid());
		    pstmt.setInt(4, housedata.getLocationid());
		    pstmt.setInt(5, housedata.getArea());
		    pstmt.setInt(6, housedata.getBedroom());
		    pstmt.setInt(7, housedata.getBathroom());
		    pstmt.setInt(8, housedata.getHouseyear());
		    pstmt.setDouble(9, housedata.getPrice());

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
		    System.out.println("Error : " + e);
		    return false;
		}
	}

	public List<HouseData> getHouseDetails() {
	    List<HouseData> houselist = new ArrayList<>();

	    try {
	        pstmt = connection.prepareStatement(
	            "SELECT House.houseid, House.housename, House.area, House.bedroom, " +
	            "House.bathroom, House.houseyear, House.price, " +
	            "State.statename, City.cityname, Location.locationname " +
	            "FROM State " +
	            "INNER JOIN City ON State.stateid = City.stateid " +
	            "INNER JOIN Location ON Location.cityid = City.cityid " +
	            "INNER JOIN House ON House.locationid = Location.locationid"
	        );

	        resultset = pstmt.executeQuery();

	        while (resultset.next()) {
	            HouseData housedata = new HouseData();

	            housedata.setHouseid(resultset.getInt("houseid"));
	            housedata.setHousename(resultset.getString("housename"));
	            housedata.setArea(resultset.getInt("area"));
	            housedata.setBedroom(resultset.getInt("bedroom"));
	            housedata.setBathroom(resultset.getInt("bathroom"));
	            housedata.setHouseyear(resultset.getInt("houseyear"));
	            housedata.setPrice(resultset.getInt("price"));

	            housedata.setStatename(resultset.getString("statename"));
	            housedata.setCityname(resultset.getString("cityname"));
	            housedata.setLocationname(resultset.getString("locationname"));

	            houselist.add(housedata);
	        }

	    } catch (Exception e) {
	        System.out.println("Error: " + e);
	    }

	    return houselist;
	}

	@Override
	public boolean isDeleteHouseData(int houseid) {
		try
		{
			pstmt = connection.prepareStatement("delete from House where houseid=?");
			pstmt.setInt(1, houseid);
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
	public boolean isUpdateHouseData(HouseData housedata) {
		 try {

		        pstmt = connection.prepareStatement(
		            "update House set housename=?, stateid=?, cityid=?, locationid=?, area=?, bedroom=?, bathroom=?, houseyear=?, price=? where houseid=?"
		        );

		        pstmt.setString(1, housedata.getHousename());
		        pstmt.setInt(2, housedata.getStateid());
		        pstmt.setInt(3, housedata.getCityid());
		        pstmt.setInt(4, housedata.getLocationid());
		        pstmt.setInt(5, housedata.getArea());
		        pstmt.setInt(6, housedata.getBedroom());
		        pstmt.setInt(7, housedata.getBathroom());
		        pstmt.setInt(8, housedata.getHouseyear());
		        pstmt.setDouble(9, housedata.getPrice());
		        pstmt.setInt(10, housedata.getHouseid());

		        int value = pstmt.executeUpdate();

		        if(value > 0)
		            return true;
		        else
		            return false;

		    } catch(Exception e) {
		        System.out.println("Error : " + e);
		    }

		return false;
	}

	//Count State Wise House
	@Override
	public int getStateHouseCount() {
		int count = 0;
		try
		{
			pstmt = connection.prepareStatement("select stateid, count(*) as House_Count from House group by stateid");
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				int stateId = resultset.getInt("stateid");
				count = resultset.getInt("House_Count");
				
				System.out.println("State Id : " +stateId+ " Total Houses : " +count);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		return 0;
	}

	//Count State Wise City
	@Override
	public int getStateCityCount() {
		int count = 0;
		try
		{
			pstmt = connection.prepareStatement("select stateid, count(*) as 'City_Count' from City group by stateid");
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				int stateId = resultset.getInt("stateid");
				count = resultset.getInt("City_Count");
				
				System.out.println("State Id : " +stateId+ " Total City : " +count);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		return 0;
	}

	//Count City Wise Location
	@Override
	public int getCityLocationCount() {
		int count = 0;
		try
		{
			pstmt = connection.prepareStatement("select cityid, count(*) as 'Location_Count' from Location group by cityid");
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				int stateId = resultset.getInt("cityid");
				count = resultset.getInt("Location_Count");
				
				System.out.println("City Id : " +stateId+ " Total Location : " +count);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		return 0;
	}

	//City Wise House Count
	@Override
	public int getCityHouseCount() {
		int count = 0;
		try
		{
			pstmt = connection.prepareStatement("select cityid, count(*) 'House_Count' from House group by cityid");
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				int stateId = resultset.getInt("cityid");
				count = resultset.getInt("House_Count");
				
				System.out.println("City Id : " +stateId+ " Total House : " +count);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		return 0;
	}

	//Location Wise House Count
	@Override
	public int getLocationHouseCount() {
		int count = 0;
		try
		{
			pstmt = connection.prepareStatement("select locationid, count(*) 'House_Count' from House group by locationid");
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				int stateId = resultset.getInt("locationid");
				count = resultset.getInt("House_Count");
				
				System.out.println("Location Id : " +stateId+ " Total House : " +count);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		return 0;
	}

	//Search House By City
	@Override
	public List<HouseData> searchHouseByCity(int cityid) {
		
		List<HouseData> houselist = new ArrayList<>();
		
		try
		{
			pstmt = connection.prepareStatement("select *from house where cityid=?");
			
			pstmt.setInt(1, cityid);
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				HouseData housedata = new HouseData();
				
				housedata.setHouseid(resultset.getInt("houseid"));
				housedata.setHousename(resultset.getString("housename"));
				housedata.setStateid(resultset.getInt("stateid"));
				housedata.setCityid(resultset.getInt("cityid"));
				housedata.setLocationid(resultset.getInt("locationid"));
				housedata.setArea(resultset.getInt("area"));
				housedata.setBedroom(resultset.getInt("bedroom"));
				housedata.setBathroom(resultset.getInt("bathroom"));
				housedata.setHouseyear(resultset.getInt("houseyear"));
				housedata.setPrice(resultset.getDouble("price"));

				houselist.add(housedata);
			}
		}catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		
		return houselist;
	}

	//Search House By Location
	@Override
	public List<HouseData> searchHouseByLocation(int locationid) {
		List<HouseData> houselist = new ArrayList<>();
		
		try
		{
			pstmt = connection.prepareStatement("select *from house where locationid=?");
			
			pstmt.setInt(1, locationid);
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				HouseData housedata = new HouseData();
				
				housedata.setHouseid(resultset.getInt("houseid"));
				housedata.setHousename(resultset.getString("housename"));
				housedata.setStateid(resultset.getInt("stateid"));
				housedata.setCityid(resultset.getInt("cityid"));
				housedata.setLocationid(resultset.getInt("locationid"));
				housedata.setArea(resultset.getInt("area"));
				housedata.setBedroom(resultset.getInt("bedroom"));
				housedata.setBathroom(resultset.getInt("bathroom"));
				housedata.setHouseyear(resultset.getInt("houseyear"));
				housedata.setPrice(resultset.getDouble("price"));

				houselist.add(housedata);
			}
		}catch(Exception e)
		{
			System.out.println("Error : " +e);
		}
		
		return houselist;
	}

	@Override
	public int getAreaWiseHouse() {
		  int count = 0;

		    try
		    {
		        pstmt = connection.prepareStatement(
		            "select area, count(*) as House_Count from House group by area order by area");

		        resultset = pstmt.executeQuery();

		        while(resultset.next())
		        {
		            int area = resultset.getInt("area");
		            count = resultset.getInt("House_Count");

		            System.out.println("Area : " + area + " Total House : " + count);
		        }
		    }
		    catch(Exception e)
		    {
		        System.out.println("Error : " + e);
		    }

		    return count; 
	}

	List<Object[]> houselist;
	@Override
	public List<Object[]> getAreaPrice(int locationid, int area) {
		try
		{
			houselist = new ArrayList<>();
			pstmt = connection.prepareStatement("select House.houseid, House.housename, House.area, House.houseyear, House.price from House where locationid = ?");
			pstmt.setInt(1, locationid);
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				//Get House List
				Object housedatalist[] = new Object[] {
						  resultset.getInt("houseid"),
			                resultset.getString("housename"),
			                resultset.getInt("area"),
			                resultset.getInt("houseyear"),
			                resultset.getInt("price")
				};
				houselist.add(housedatalist);
			}
			if(houselist.size() > 0)
			{
				return houselist;
			}
			else
			{
				return null;
			}
			
		}catch(Exception e)
		{
			System.out.println("Error : " +e);
			return null;
		}
	}

	@Override
	public int getMinValueOfArea(int locationid) {
		try
		{
			int minArea = 0;
			houselist = new ArrayList<>();
			pstmt = connection.prepareStatement("select AVG(area) from House where locationid = ?");
			pstmt.setInt(1, locationid);
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				minArea = resultset.getInt(1);
			}
			return minArea;
		}catch(Exception e)
		{
			System.out.println("Error : " +e);
			return 0;
		}
	}

	@Override
	public int getMinValueOfPrice(int locationid) {
		try
		{
			int minPrice = 0;
			houselist = new ArrayList<>();
			pstmt = connection.prepareStatement("select AVG(price) from House where locationid = ?");
			pstmt.setInt(1, locationid);
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next())
			{
				minPrice = resultset.getInt(1);
			}
			return minPrice;
		}catch(Exception e)
		{
			System.out.println("Error : " +e);
			return 0;
		}
	}

}
