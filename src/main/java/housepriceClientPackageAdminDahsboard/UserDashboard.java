package housepriceClientPackageAdminDahsboard;
import java.util.*;

import housepriceModelPackage.CityData;
import housepriceModelPackage.LocationData;
import housepriceModelPackage.StateData;
import housepriceServicePackage.StateManagerServiceInterface;
import housepriceServicePackage.CityManageService;
import housepriceServicePackage.CityManageServiceInterface;
import housepriceServicePackage.HouseManageService;
import housepriceServicePackage.HouseManageServiceInterface;
import housepriceServicePackage.LocationManageService;
import housepriceServicePackage.LocationManageServiceInterface;
import housepriceServicePackage.StateManageService;
public class UserDashboard {
	StateManageService statemservice = new StateManagerServiceInterface();
	CityManageService citymservice = new CityManageServiceInterface();
	LocationManageService locationmservice = new LocationManageServiceInterface();
	HouseManageService housemservice = new HouseManageServiceInterface();
	public UserDashboard()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("WELCOME TO THE USER DASHBOARD");
			System.out.println("1 : Get Prediction");
			System.out.println("2 : Quit");
			
			System.out.println("\nPlease Press 1 To Get Price Of The House");
			
			int choice = sc.nextInt();
					
			switch(choice)
			{
				case 1:
					sc.nextLine();
					
					List<StateData> statelist = statemservice.getAllState();
					System.out.println("State ID \t\t State Name");
					for(StateData statem : statelist)
					{
						System.out.println(statem.getStateid() + "\t\t" + statem.getStatename());
					}
					
					System.out.println("\nSelect State ID To Get City Data");
					int stateid = sc.nextInt();
					
					List<CityData> citylist = citymservice.getAllCitiesByStateID(stateid);
					
					System.out.println("City ID \t\t City Name");
					for(CityData cdata : citylist)
					{
						System.out.println(cdata.getCityid() + "\t\t" +cdata.getCityname());
					}
					
					System.out.println("\nEnter City ID To Get Location Name");
					int cityid = sc.nextInt();
					
					List<LocationData> locationlist = locationmservice.getLocationByCityId(cityid);
					
					System.out.println("Location ID \t\t Location Name");
					for(LocationData ldata : locationlist)
					{
						System.out.println(ldata.getLocationid() + "\t\t" +ldata.getLocationname());
					}
					
					System.out.println("\nEnter Location ID To Get House Data");
					int locationid = sc.nextInt();
					
					System.out.println("\nPlease Enter Area Of House You Want");
					int area = sc.nextInt();
					
					housemservice.getAreaPrice(locationid,area);
					
					break;
					
				case 2:
					System.exit(0);
					break;
					
				default:
					System.out.println("You Select Wrong Option Please, choose correct option");
			}
		}while(true);
	}
}
