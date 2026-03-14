package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.StateData;

public interface StateManageService {
	public boolean isAddState(StateData statedata);
	
	public List<StateData> getAllState();

	public boolean isStateDelete(int stateid);

	public boolean isUpdateStateData(StateData statedata);
}
