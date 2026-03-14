package housepriceRepositoryPackage;

import housepriceDBConfig.DBConfig;
import housepriceModelPackage.LoginData;

public class ValidateUserDataInterfaceRepo extends DBConfig implements ValidateUserDataRepository {

    public LoginData ValidateInfo(LoginData logindata)
    {
        try
        {
            pstmt = connection.prepareStatement("select *from Users where username=? and password=?");

            pstmt.setString(1, logindata.getUsername());
            pstmt.setString(2, logindata.getPassword());

            resultset = pstmt.executeQuery();

            if(resultset.next())
            {
                logindata.setUsertype(resultset.getString(4));
                logindata.setUserid(resultset.getInt(1));
            }

            return logindata;
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }

        return null;
    }
}