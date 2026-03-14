package housepriceRepositoryPackage;

import java.util.List;

import housepriceModelPackage.CityData;
import housepriceModelPackage.HouseData;
import housepriceModelPackage.StateData;

public interface StateRepository {
	//Add State
	public boolean isAddState(StateData statedata);
	
	//View All State
	public List<StateData> getAllState();
	
	//Delete State
	public boolean isStateDelete(int stateid);
	
	//Update State
	public boolean isUpdateStateData(StateData statedata);
	
}
