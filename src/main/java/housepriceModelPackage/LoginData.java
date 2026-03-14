//Represent Users table from database
package housepriceModelPackage;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LoginData {
	private int userid;
	private String username;
	private String password;
	private String usertype;
	
	
}
