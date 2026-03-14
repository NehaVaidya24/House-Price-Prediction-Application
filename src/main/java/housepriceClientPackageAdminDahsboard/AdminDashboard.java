package housepriceClientPackageAdminDahsboard;
import java.util.*;
import housepriceClientPackage.ClientData;
import housepriceModelPackage.StateData;
import housepriceRepositoryPackage.HouseRepository;
import housepriceRepositoryPackage.HouseRepositoryInterface;
import housepriceModelPackage.CityData;
import housepriceModelPackage.HouseData;
import housepriceModelPackage.LocationData;
import housepriceServicePackage.CityManageServiceInterface;
import housepriceServicePackage.HouseManageServiceInterface;
import housepriceServicePackage.LocationManageServiceInterface;
import housepriceServicePackage.StateManageService;
import housepriceServicePackage.StateManagerServiceInterface;
import housepriceServicePackage.CityManageService;
import housepriceServicePackage.LocationManageService;
import housepriceServicePackage.HouseManageService;

public class AdminDashboard {
	StateManageService statemservice = new StateManagerServiceInterface();
	CityManageService citymservice = new CityManageServiceInterface();
	LocationManageService locationmservice = new LocationManageServiceInterface();
	HouseManageService housemservice = new HouseManageServiceInterface();
	
	public AdminDashboard()
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("WELCOME TO ADMIN DASHBOARD : " +ClientData.logUserName);
			System.out.println("\n----------------------------------------------------\n");
			
			System.out.println("1 : State");
			System.out.println("2 : City");
			System.out.println("3 : Location");
			System.out.println("4 : House Management");
			System.out.println("5 : Quit");
			
			System.out.println("Please choose an option from the menu:");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{						
				//State Case
				case 1:
					System.out.println("\nWELCIME TO STATE MANAGEMENT");
					System.out.println("\n----------------------------------------------\n");
					
					System.out.println("1 : Add State");
					System.out.println("2 : View All State");
					System.out.println("3 : Delete State");
					System.out.println("4 : Update State");
					
					System.out.println("Please choose an option from the menu:");
					
					choice = sc.nextInt();
					
					switch(choice)
					{
						case 1 : 
							sc.nextLine();
							System.out.println("Enter State Name");
							String statename = sc.nextLine();
							
							StateData statedata = new StateData();
							
							statedata.setStatename(statename);
							
							boolean check = statemservice.isAddState(statedata);
							
							if(check)
							{
								System.out.println("State Added Successfully");
							}
							else
							{
								System.out.println("State Not Added");
							}
						 break;
						 
						case 2 :
							List<StateData> statelist = statemservice.getAllState();
							
							if(statelist.size() > 0)
							{
								System.out.println("StateId \t\t StateName");
								System.out.println("-----------------------------------\n");
								for(StateData data : statelist)
								{
									System.out.println(data.getStateid() + "\t\t" + data.getStatename());
								}
							}
							else
							{
								System.out.println("State Data Not Found");
							}
							break;
							
						case 3:
							List<StateData> statelists = statemservice.getAllState();
							
							if(statelists != null && statelists.size() > 0)
							{
								System.out.println("StateId \t\t StateName");
								System.out.println("-----------------------------------\n");
								for(StateData data : statelists)
								{
									System.out.println(data.getStateid() + "\t\t" + data.getStatename());
								}
								
								System.out.println("\nEnter State ID to delete State");
								int stateid = sc.nextInt();
								boolean delete = statemservice.isStateDelete(stateid);
								
								if(delete)
								{
									System.out.println("State Deleted Successfully");
								}
								else
								{
									System.out.println("State Not Delete Successfully");
								}
							}
							else
							{
								System.out.println("State Data Not Found");
							}
							break;
							
						case 4:
							List<StateData> statelistupdate = statemservice.getAllState();
							
							if(statelistupdate != null && statelistupdate.size() > 0)
							{
								System.out.println("StateId \t\t StateName");
								System.out.println("-----------------------------------\n");
								for(StateData data : statelistupdate)
								{
									System.out.println(data.getStateid() + "\t\t" + data.getStatename());
								}
								
								System.out.println("\nEnter State ID to update State");
								int stateid = sc.nextInt();
								
								System.out.println("\nEnter State Name");
								String updatestatename = sc.nextLine();
								
								StateData statedatas = new StateData();
								
								statedatas.setStateid(stateid);
								statedatas.setStatename(updatestatename);
								
								boolean update = statemservice.isUpdateStateData(statedatas);
								
								if(update)
								{
									System.out.println("State Updated Successfully");
								}
								else
								{
									System.out.println("State Not Updated Successfully");
								}
							}
							else
							{
								System.out.println("State Data Not Found");
							}
							break;
							
						case 5:
							System.exit(0);
							break;
							
						default:
							System.out.println("You select wrong option, please select correct option");
					}
					break;
				
				//City Case
				case 2 :
					System.out.println("\nWELCIME TO CITY MANAGEMENT");
					System.out.println("\n----------------------------------------------\n");
					
					System.out.println("1 : Add City");
					System.out.println("2 : View All City");
					System.out.println("3 : Delete City");
					System.out.println("4 : Update City");
					System.out.println("5 : Quit");
					
					System.out.println("Please choose an option from the menu:");
					
					choice = sc.nextInt();
					
					switch(choice)
					{
						case 1:
							sc.nextLine();
							List<StateData> statelists = statemservice.getAllState();
							
							if(statelists != null && statelists.size() > 0)
							{
								System.out.println("StateId \t\t StateName");
								System.out.println("-----------------------------------\n");
								for(StateData data : statelists)
								{
									System.out.println(data.getStateid() + "\t\t" + data.getStatename());
								}
								
								System.out.println("--------------------------------");
								System.out.println("\nEnter City Name");
								String cityname = sc.nextLine();
								System.out.println("\nEnter State ID");
								int stateid = sc.nextInt();
								CityData citydata = new CityData();
								citydata.setCityname(cityname);
								citydata.setStateid(stateid);
								boolean city = citymservice.isAddCity(citydata);
								if(city)
								{
									System.out.println("City Added Successfully");
								}
								else
								{
									System.out.println("City Not Added");
								}
							}
							else
							{
								System.out.println("City Data Not Found");
							}
							break;
							
						case 2:
							List<CityData> citylist = citymservice.getCities();
							
							if(citylist != null)
							{
								System.out.println("City Name With State Name");
								System.out.println("------------------------------\n");
								
								for(CityData citydata : citylist)
								{
									System.out.println(citydata.getCityid() + "\t\t" +citydata.getCityname() + "\t\t" +citydata.getStatename());
								}
							}
							else
							{
								System.out.println("City Data Not Found");
							}
							break;
							
						case 3:
							List<CityData> citydata = citymservice.getCities();
							
							if(citydata != null && citydata.size() > 0)
							{
								System.out.println("StateId \t\t StateName");
								System.out.println("-----------------------------------\n");
								for(CityData data : citydata)
								{
									System.out.println(data.getCityid() + "\t\t" + data.getCityname());
								}
								
								System.out.println("\nEnter City ID to delete City");
								int cityid = sc.nextInt();
								boolean delete = citymservice.isCityDelete(cityid);
								
								if(delete)
								{
									System.out.println("City Deleted Successfully");
								}
								else
								{
									System.out.println("City Not Delete");
								}
							}
							else
							{
								System.out.println("City Data Not Found");
							}
							break;
							
						case 4:
							List<CityData> citylistdata = citymservice.getCities();
							
							if(citylistdata != null && citylistdata.size() > 0)
							{
								System.out.println("City ID \t\t City Name");
								System.out.println("-----------------------------------\n");
								for(CityData data : citylistdata)
								{
									System.out.println(data.getCityid() + "\t\t" + data.getCityname());
								}
								
								System.out.println("\nEnter City ID to update City");
								int cityid = sc.nextInt();
								
								System.out.println("\nEnter City Name");
								String updatecityanme = sc.nextLine();
								
								System.out.println("\nEnter State ID");
								int stateid = sc.nextInt();
								
								CityData citydatas = new CityData();
								
								citydatas.setCityid(cityid);
								citydatas.setCityname(updatecityanme);
								citydatas.setStateid(stateid);
								
								boolean update = citymservice.isUpdateCityData(citydatas);
								
								if(update)
								{
									System.out.println("City Updated Successfully");
								}
								else
								{
									System.out.println("City Not Updated Successfully");
								}
							}
							else
							{
								System.out.println("City Data Not Found");
							}
							break;
							
						case 5:
							System.exit(0);
							break;
							
						default:
							System.out.println("You select wrong option, please select correct option");
					}
					break;
				
				//Location Case
				case 3:
					System.out.println("\nWELCIME TO LOCATION MANAGEMENT");
					System.out.println("\n----------------------------------------------\n");
					
					System.out.println("1 : Add Location");
					System.out.println("2 : View All Location");
					System.out.println("3 : Delete Location");
					System.out.println("4 : Update Location");
					System.out.println("5 : Quit");
					
					System.out.println("Please choose an option from the menu:");
					
					choice = sc.nextInt();
					
					switch(choice)
					{
						case 1:
							sc.nextLine();
							List<CityData> citylist = citymservice.getCities();
							
							if(citylist != null && citylist.size() > 0)
							{
								System.out.println("CityID \t\t CityName");
								System.out.println("-----------------------------------\n");
								for(CityData data : citylist)
								{
									System.out.println(data.getCityid() + "\t\t" + data.getCityname());
								}
								
								System.out.println("--------------------------------");
								System.out.println("\nEnter Location Name");
								String locationname = sc.nextLine();
								System.out.println("\nEnter City ID");
								int cityid = sc.nextInt();
								
								LocationData locationdata = new LocationData();
								locationdata.setLocationname(locationname);
								locationdata.setCityid(cityid);

								boolean location = locationmservice.isAddLocation(locationdata);
								if(location)
								{
									System.out.println("Location Added Successfully");
								}
								else
								{
									System.out.println("Location Not Added");
								}
							}
							else
							{
								System.out.println("Location Data Not Found");
							}
							break;
							
						case 2:
							List<LocationData> locationlist = locationmservice.getLocations();
							
							if(locationlist != null)
							{
								System.out.println("Location Name With City Name");
								System.out.println("------------------------------\n");
								
								for(LocationData locationdata : locationlist)
								{
									System.out.println(locationdata.getLocationid() + "\t\t" +locationdata.getLocationname() +"\t\t"+ locationdata.getCityname());
								}
							}
							else
							{
								System.out.println("Location Data Not Found");
							}
							break;
							
						case 3:
							List<LocationData> locatindata = locationmservice.getLocations();
							
							if(locatindata != null && locatindata.size() > 0)
							{
								System.out.println("Location ID \t\t LocationName");
								System.out.println("-----------------------------------\n");
								for(LocationData data : locatindata)
								{
									System.out.println(data.getLocationid() + "\t\t" + data.getLocationname());
								}
								
								System.out.println("\nEnter Location ID to delete Location");
								int locationid = sc.nextInt();
								boolean delete = locationmservice.isLocationDelete(locationid);
								
								if(delete)
								{
									System.out.println("Location Deleted Successfully");
								}
								else
								{
									System.out.println("Location Not Delete");
								}
							}
							else
							{
								System.out.println("Location Data Not Found");
							}
							break;
							
						case 4:
							List<LocationData> locationlists = locationmservice.getLocations();
							
							if(locationlists != null && locationlists.size() > 0)
							{
								System.out.println("Location ID \t\t Location Name");
								System.out.println("-----------------------------------\n");
								for(LocationData data : locationlists)
								{
									System.out.println(data.getLocationid() + "\t\t" + data.getLocationname());
								}
								
								System.out.println("\nEnter Location ID to update Location");
								int locationid = sc.nextInt();
								
								System.out.println("\nEnter Location Name");
								String updatelocationanme = sc.nextLine();
								
								System.out.println("\nEnter city id");
								int cityid = sc.nextInt();
								
								LocationData locationdatas = new LocationData();
								
								locationdatas.setLocationid(locationid);
								locationdatas.setLocationname(updatelocationanme);
								locationdatas.setCityid(cityid);
								
								boolean update = locationmservice.isUpdateLocationData(locationdatas);
								
								if(update)
								{
									System.out.println("Location Updated Successfully");
								}
								else
								{
									System.out.println("Location Not Updated Successfully");
								}
							}
							else
							{
								System.out.println("Location Data Not Found");
							}
							break;
							
						case 5:
							System.exit(0);
							break;
							
						default:
							System.out.println("You select wrong option, please select correct option");
					}
					break;
					
				case 4:
					System.out.println("\nWELCIME TO HOUSE MANAGEMENT");
					System.out.println("\n----------------------------------------------\n");
					
					System.out.println("1 : Add House Details");
					System.out.println("2 : View All House Details");
					System.out.println("3 : Delete House Details");
					System.out.println("4 : Update House details");
					System.out.println("5 : Count State Wise House");
					System.out.println("6 : Count State Wise City");
					System.out.println("7 : Count City Wise Location");
					System.out.println("8 : Count City Wise House");
					System.out.println("9 : Count Location Wise House");
					System.out.println("10 : Search House By City");
					System.out.println("11 : Search House By Location");
					System.out.println("12 : Count Area Wise House");
					System.out.println("13 : Quit");

					
					System.out.println("\nPlease choose an option from the menu:");
					
					choice = sc.nextInt();
				    switch(choice)
				    {
				    	case 1:
				    		sc.nextLine();

						    List<StateData> statelist = statemservice.getAllState();
						    List<CityData> citylist = citymservice.getCities();
						    List<LocationData> locationlist = locationmservice.getLocations();

						    if(statelist != null && statelist.size() > 0)
						    {
						        System.out.println("StateID\t\tStateName");
						        System.out.println("-----------------------------------");

						        for(StateData data : statelist)
						        {
						            System.out.println(data.getStateid() + "\t\t" + data.getStatename());
						        }

						        System.out.println("-----------------------------------");

						        System.out.println("Enter State ID:");
						        int stateid = sc.nextInt();

						        System.out.println("\nCityID\t\tCityName");
						        System.out.println("-----------------------------------");

						        for(CityData data : citylist)
						        {
						            if(data.getStateid() == stateid)
						            {
						                System.out.println(data.getCityid() + "\t\t" + data.getCityname());
						            }
						        }

						        System.out.println("-----------------------------------");
						        System.out.println("Enter City ID:");
						        int cityid = sc.nextInt();

						        System.out.println("\nLocationID\t\tLocationName");
						        System.out.println("-----------------------------------");

						        for(LocationData data : locationlist)
						        {
						            if(data.getCityid() == cityid)
						            {
						                System.out.println(data.getLocationid() + "\t\t" + data.getLocationname());
						            }
						        }

						        System.out.println("-----------------------------------");
						        System.out.println("Enter Location ID:");
						        int locationid = sc.nextInt();

						        sc.nextLine();

						        System.out.println("Enter House Name:");
						        String housename = sc.nextLine();

						        System.out.println("Enter Area:");
						        int area = sc.nextInt();

						        System.out.println("Enter Bedrooms:");
						        int bedroom = sc.nextInt();

						        System.out.println("Enter Bathrooms:");
						        int bathroom = sc.nextInt();

						        System.out.println("Enter House Year:");
						        int houseyear = sc.nextInt();

						        System.out.println("Enter Price:");
						        double price = sc.nextDouble();

						        HouseData housedata = new HouseData();

						        housedata.setHousename(housename);
						        housedata.setStateid(stateid);
						        housedata.setCityid(cityid);
						        housedata.setLocationid(locationid);
						        housedata.setArea(area);
						        housedata.setBedroom(bedroom);
						        housedata.setBathroom(bathroom);
						        housedata.setHouseyear(houseyear);
						        housedata.setPrice(price);

						        boolean house = housemservice.addHouseDetails(housedata);

						        if(house)
						        {
						            System.out.println("House Added Successfully");
						        }
						        else
						        {
						            System.out.println("House Not Added");
						        }
						    }
				    		break;
				    		
				    	case 2:
				    		List<HouseData> houselist = housemservice.getHouseDetails();
							
							if(houselist != null)
							{
								System.out.println("House Details");
								System.out.println("------------------------------\n");
								
								for(HouseData housedata : houselist)
								{
									System.out.println(housedata.getHouseid() + "\t\t" +housedata.getHousename() + "\t\t" +housedata.getArea() + "\t\t" +housedata.getBedroom() +"\t\t" +housedata.getBathroom() + "\t\t" +housedata.getPrice() +"\t\t" +housedata.getStatename() + "\t\t" +housedata.getCityname() + "\t\t" +housedata.getLocationname());;
								}
							}
							else
							{
								System.out.println("House Data Not Found");
							}
							break;
				    		
				    	case 3:
				    		List<HouseData> housedata = housemservice.getHouseDetails();
							
							if(housedata != null && housedata.size() > 0)
							{
								System.out.println("House ID \t\t House Name");
								System.out.println("-----------------------------------\n");
								for(HouseData data : housedata)
								{
									System.out.println(data.getHouseid() + "\t\t" + data.getHousename());
								}
								
								System.out.println("\nEnter House ID to delete House Data");
								int houseid = sc.nextInt();
								boolean delete = housemservice.isDeleteHouseData(houseid);
								
								if(delete)
								{
									System.out.println("House Data Deleted Successfully");
								}
								else
								{
									System.out.println("House Data Not Delete");
								}
							}
							else
							{
								System.out.println("House Data Not Found");
							}
							break;
				    		
				    	case 4:
				    		List<HouseData> houselists = housemservice.getHouseDetails();
							
							if(houselists != null)
							{
								System.out.println("House Details");
								System.out.println("------------------------------\n");
								
								for(HouseData housedat : houselists)
								{
									System.out.println(housedat.getHouseid() + "\t\t" +housedat.getHousename() + "\t\t" +housedat.getArea() + "\t\t" +housedat.getBedroom() +"\t\t" +housedat.getBathroom() + "\t\t" +housedat.getPrice() +"\t\t" +housedat.getStatename() + "\t\t" +housedat.getCityname() + "\t\t" +housedat.getLocationname());;
								}
								
								System.out.println("Enter House Id to Update:");
							    int houseid = sc.nextInt();

							    System.out.println("Enter New House Name:");
							    String housename = sc.next();

							    System.out.println("Enter State Id:");
							    int stateid = sc.nextInt();

							    System.out.println("Enter City Id:");
							    int cityid = sc.nextInt();

							    System.out.println("Enter Location Id:");
							    int locationid = sc.nextInt();

							    System.out.println("Enter Area:");
							    int area = sc.nextInt();

							    System.out.println("Enter Bedroom:");
							    int bedroom = sc.nextInt();

							    System.out.println("Enter Bathroom:");
							    int bathroom = sc.nextInt();

							    System.out.println("Enter House Year:");
							    int houseyear = sc.nextInt();

							    System.out.println("Enter Price:");
							    double price = sc.nextDouble();

							    HouseData h = new HouseData();

							    h.setHouseid(houseid);
							    h.setHousename(housename);
							    h.setStateid(stateid);
							    h.setCityid(cityid);
							    h.setLocationid(locationid);
							    h.setArea(area);
							    h.setBedroom(bedroom);
							    h.setBathroom(bathroom);
							    h.setHouseyear(houseyear);
							    h.setPrice(price);

							    boolean b = housemservice.isUpdateHouseData(h);

							    if(b)
							        System.out.println("House Data Updated Successfully");
							    else
							        System.out.println("House Data Not Updated");
							}
							else
							{
								System.out.println("House Data Not Found");
							}
							break;
						
						//Count State Wise House
				    	case 5:
				    		System.out.println("State Wise House Count");
				    		System.out.println("-------------------------------------------\n");
				    		
				    		int counthouse = housemservice.getStateHouseCount();
				    		break;
				    		
				    	case 6:
				    		System.out.println("State Wise City Count");
				    		System.out.println("---------------------------------------------\n");
				    		
				    		int countcity = housemservice.getStateCityCount();
				    		break;
				    		
				    	case 7:
				    		System.out.println("City Wise Location Count");
				    		System.out.println("-----------------------------------------------\n");
				    		
				    		int countlocation = housemservice.getCityLocationCount();
				    		break;
				    		
				    	case 8:
				    		System.out.println("City Wise House Count");
				    		System.out.println("-------------------------------------------------\n");
				    		
				    		int countHouseCity = housemservice.getCityHouseCount();
				    		break;
				    		
				    	case 9:
				    		System.out.println("Location Wise House Count");
				    		System.out.println("-------------------------------------------------\n");
				    		
				    		int countlocationhouse = housemservice.getLocationHouseCount();
				    		break;
				    		
				    	case 10:
				    		System.out.println("Search House By City");
				    	    System.out.println("---------------------");

				    	    System.out.println("Enter City Id:");
				    	    int cityId = sc.nextInt();

				    	    List<HouseData> houseList = housemservice.searchHouseByCity(cityId);

				    	    if(houseList != null && houseList.size() > 0)
				    	    {
				    	        System.out.println("HouseID\t\tHouseName\t\tArea\t\tPrice");

				    	        for(HouseData h : houseList)
				    	        {
				    	            System.out.println(
				    	                h.getHouseid() + "\t\t" +h.getHousename() + "\t\t" +h.getArea() + "\t\t" +h.getBathroom() +"\t\t" +h.getBedroom() + "\t\t" +h.getPrice());
				    	        }
				    	    }
				    	    else
				    	    {
				    	        System.out.println("No House Found In This City");
				    	    }
				    		break;
				    		
				    	case 11:
				    		System.out.println("Search House By Location");
				    	    System.out.println("---------------------");

				    	    System.out.println("Enter location Id:");
				    	    int locationid = sc.nextInt();

				    	    List<HouseData> houseLists = housemservice.searchHouseByLocation(locationid);

				    	    if(houseLists != null && houseLists.size() > 0)
				    	    {
				    	        System.out.println("HouseID\t\tHouseName\t\tArea\t\tPrice");

				    	        for(HouseData h : houseLists)
				    	        {
				    	            System.out.println(
				    	                h.getHouseid() + "\t\t" +h.getHousename() + "\t\t" +h.getArea() + "\t\t" +h.getBathroom() +"\t\t" +h.getBedroom() + "\t\t" +h.getPrice());
				    	        }
				    	    }
				    	    else
				    	    {
				    	        System.out.println("No House Found In This City");
				    	    }
				    		break;
				    		
				    	case 12:
				    		System.out.println("Area Wise House Count");
				    		System.out.println("-------------------------------------------------\n");
				    		
				    		int areahosuecount = housemservice.getAreaWiseHouse();
				    		break;
				    		
				    	case 13:
				    		System.exit(0);
				    		break;
				    }
					
				case 5:
					System.exit(0);
					break;
					
				default:
					System.out.println("You enter wrong option, please select an correct option");
				
			}
		}while(true);
	}
}
