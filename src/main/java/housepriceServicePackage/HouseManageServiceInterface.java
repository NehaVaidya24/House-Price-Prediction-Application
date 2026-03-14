package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.HouseData;
import housepriceRepositoryPackage.HouseRepositoryInterface;
import housepriceRepositoryPackage.HouseRepository;

public class HouseManageServiceInterface implements HouseManageService{
	HouseRepository houserepo = new HouseRepositoryInterface();

	@Override
	public boolean addHouseDetails(HouseData housedata) {
		return houserepo.addHouseDetails(housedata);
	}

	@Override
	public List<HouseData> getHouseDetails() {
		return houserepo.getHouseDetails();
	}

	@Override
	public boolean isDeleteHouseData(int houseid) {
		return houserepo.isDeleteHouseData(houseid);
	}

	@Override
	public boolean isUpdateHouseData(HouseData housedata) {
		return houserepo.isUpdateHouseData(housedata);
	}

	@Override
	public int getStateHouseCount() {
		return houserepo.getStateHouseCount();
	}

	@Override
	public int getStateCityCount() {
		return houserepo.getStateCityCount();
	}

	@Override
	public int getCityLocationCount() {
		return houserepo.getCityLocationCount();
	}

	@Override
	public int getCityHouseCount() {
		return houserepo.getCityHouseCount();
	}

	@Override
	public int getLocationHouseCount() {
		return houserepo.getLocationHouseCount();
	}

	@Override
	public List<HouseData> searchHouseByCity(int cityid) {
		return houserepo.searchHouseByCity(cityid);
	}

	@Override
	public List<HouseData> searchHouseByLocation(int locationid) {
		return houserepo.searchHouseByLocation(locationid);
	}

	@Override
	public int getAreaWiseHouse() {
		return houserepo.getAreaWiseHouse();
	}

	@Override
	public List<Object[]> getAreaPrice(int locationid,int area) {
		List<Object[]> houselist = houserepo.getAreaPrice(locationid,area);
		
		//House Data
		System.out.println("House ID \t House Name \t House Area \t House Year \t House Price");
		for(Object housedatalist[] : houselist)
		{
			System.out.printf("%-10s %-25s %-12s %-12s %-12s\n",
		            housedatalist[0],
		            housedatalist[1],
		            housedatalist[2],
		            housedatalist[3],
		            housedatalist[4]);
		}		
		int minArea = houserepo.getMinValueOfArea(locationid);
		
		int minPrice = houserepo.getMinValueOfPrice(locationid);
		
		//System.out.println("\nMin Value of Area : " +minArea);
		//System.out.println("\nMin Value of Price : " +minPrice);
		
		//Deviation of Area
		int DeviationArea[] = new int[houselist.size()];
		
		//Deviation of Price
		int DeviationPrice[] = new int[houselist.size()];
		
		//Product of Deviations of both area and price
		int ProductDeviationAP[] = new int[houselist.size()];
		
		//Square of Deviation of Area
		int SquareDeviationArea[] = new int[houselist.size()];
		
		int index = 0;
		
		int SumOfProductDeviation = 0;
		
		int SumOfSquareOfDeviation = 0;
		
		//Calculate Deviations of Area and Price
		for(Object housedatalist[] : houselist)
		{
			DeviationArea[index] = (int)housedatalist[2] - minArea;
			
			DeviationPrice[index] = (int)housedatalist[4] - minPrice;
			
			ProductDeviationAP[index] = (int)DeviationArea[index] * (int)DeviationPrice[index];
			
			SumOfProductDeviation = SumOfProductDeviation + (int)ProductDeviationAP[index];
			
			SquareDeviationArea[index] = DeviationArea[index]*DeviationArea[index];
			
			SumOfSquareOfDeviation = SumOfSquareOfDeviation + SquareDeviationArea[index];
			
			//System.out.println(DeviationArea[index] + "\t" +DeviationPrice[index] + "\t" +ProductDeviationAP[index] + "\t" +SquareDeviationArea[index]);
		}
		
		float MValue = ((float) SumOfProductDeviation/SumOfSquareOfDeviation);
		
		float BValue = ((float)minPrice - (MValue * minArea));
		
		float PredictPrice = MValue * area + BValue;
		
		System.out.println("\nPrice Of The House : " +PredictPrice);
		
		//System.out.println(BValue);
		//System.out.println(MValue);
		
		//System.out.println("Sum of Product Of Deviation : " +SumOfProductDeviation);
		return houselist;
	}
	
	@Override
	public int getMinValueOfArea(int locationid) {
	    return houserepo.getMinValueOfArea(locationid);
	}

	@Override
	public int getMinValueOfPrice(int locationid) {
	    return houserepo.getMinValueOfPrice(locationid);
	}

}
