package housepriceModelPackage;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class HouseData {

    private int houseid;
    private String housename;

    private int stateid;
    private int cityid;
    private int locationid;

    private int area;
    private int bedroom;
    private int bathroom;
    private int houseyear;
    private double price;
    
    private String statename;
    private String cityname;
    private String locationname;
}