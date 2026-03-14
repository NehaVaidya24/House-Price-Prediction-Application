package housepriceServicePackage;

import housepriceModelPackage.*;
import housepriceRepositoryPackage.ValidateUserDataInterfaceRepo;
import housepriceRepositoryPackage.ValidateUserDataRepository;

public class ValidateUserDataInterface implements ValidateUserData {
	
	ValidateUserDataRepository validateudata = new ValidateUserDataInterfaceRepo();

    public LoginData ValidateInfo(LoginData logindata)
    {
    	if(logindata.getUsername().isEmpty() || logindata.getPassword().isEmpty())
        {
            return null;
        }
        else
        {
            return validateudata.ValidateInfo(logindata);
        }
    }
}