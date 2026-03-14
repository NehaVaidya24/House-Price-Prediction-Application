package housepriceClientPackage;
import java.util.*;
import housepriceClientPackageAdminDahsboard.AdminDashboard;
import housepriceClientPackageAdminDahsboard.UserDashboard;
import housepriceModelPackage.LoginData;
import housepriceServicePackage.ValidateUserData;
import housepriceServicePackage.ValidateUserDataInterface;
public class ClientData {
	public static String logUserName;
	static ValidateUserData validateuser = new ValidateUserDataInterface();
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("WECLOME TO HOUSE PRICE DETECTION APPLICATION");
			System.out.println("1 : Sign In");
			System.out.println("2 : Sign Up");
			System.out.println("3 : Quit");
			System.out.println("\nPlease choose an option from the menu:");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case 1 : 
					System.out.println("Enter User Name");
					String username = sc.nextLine();

					System.out.println("Enter User Password");
					String password = sc.nextLine();
					
					LoginData modeldata = new LoginData();
					modeldata.setUsername(username);
					modeldata.setPassword(password);
					
					modeldata = validateuser.ValidateInfo(modeldata);
					
					if(modeldata != null)
					{
					    System.out.println("Usertype from DB: " + modeldata.getUsertype());

					    if(modeldata.getUsertype().equals("Admin"))
					    {
					        logUserName = modeldata.getUsername();
					        AdminDashboard admindashboard = new AdminDashboard();
					    }
					    else
					    {
					        UserDashboard userdashboard = new UserDashboard();
					    }
					}
					
					break;
				
				case 2:
					break;
					
				case 3:
					System.exit(0);
					break;
					
				default: 
					System.out.println("You are selecting wrong option, Please select correct option");
			}
		}while(true);
	}
}
