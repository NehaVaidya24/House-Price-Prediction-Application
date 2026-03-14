package housepriceRepositoryPackage;

import java.util.ArrayList;
import java.util.List;
import housepriceDBConfig.DBConfig;
import housepriceModelPackage.StateData;

public class StateRepositoryInterface extends DBConfig implements StateRepository {

    public boolean isAddState(StateData statedata)
    {
        try
        {
            pstmt = connection.prepareStatement("insert into State values(0, ?)");

            pstmt.setString(1, statedata.getStatename());

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
    
    List<StateData> statelist;
    
	public List<StateData> getAllState()
	{
		try
		{
			statelist = new ArrayList<>();
			pstmt = connection.prepareStatement("select *from State order by stateid");
			resultset= pstmt.executeQuery();
			
			while(resultset.next())
			{
				StateData statedata = new StateData(resultset.getInt(1), resultset.getString(2));
				
				statelist.add(statedata);
			}
			return statelist;
		}
		catch(Exception e)
		{
			System.out.println("Error : " +e);
			return null;
		}
		
	}

	@Override
	public boolean isStateDelete(int stateid) {
		try
		{
			pstmt = connection.prepareStatement("delete from State where stateid=?");
			pstmt.setInt(1, stateid);
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
	public boolean isUpdateStateData(StateData statedata) {
		 try
		    {
		        pstmt = connection.prepareStatement("update State set statename=? where stateid=?");
		        pstmt.setString(1, statedata.getStatename());
		        pstmt.setInt(2, statedata.getStateid()); 

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

}