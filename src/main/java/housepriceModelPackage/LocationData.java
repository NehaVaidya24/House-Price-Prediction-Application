package housepriceModelPackage;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LocationData extends CityData{
	private int locationid;
	private String locationname;
}
