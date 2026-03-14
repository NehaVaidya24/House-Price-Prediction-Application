package housepriceServicePackage;

import java.util.List;

import housepriceModelPackage.StateData;
import housepriceRepositoryPackage.StateRepository;
import housepriceRepositoryPackage.StateRepositoryInterface;

public class StateManagerServiceInterface implements StateManageService{
	StateRepository staterepo = new StateRepositoryInterface();
		public boolean isAddState(StateData statedata)
		{
			return staterepo.isAddState(statedata);
			
		}
		@Override
		public List<StateData> getAllState() {
			return staterepo.getAllState();
		}
		
		@Override
		public boolean isStateDelete(int stateid) {
			return staterepo.isStateDelete(stateid);
		}
		
		@Override
		public boolean isUpdateStateData(StateData statedata) {
			return staterepo.isUpdateStateData(statedata);
		}
}
