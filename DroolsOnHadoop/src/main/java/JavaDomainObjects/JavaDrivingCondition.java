package JavaDomainObjects;

import JavaEnumerations.JavaDrivingAction;
import JavaEnumerations.JavaDrivingType;
import JavaEnumerations.JavaLightColor;

import java.io.Serializable;

/**
 * Created by nahag on 11/3/2016.
 */
public class JavaDrivingCondition implements Serializable {

    public String cityName;
    public JavaLightColor lightColor;
    public JavaDrivingType drivingType;
    public JavaDrivingAction drivingActionType;

    public JavaDrivingCondition(String cityName,
                                JavaLightColor lightColor,
                                JavaDrivingType drivingType,
                                JavaDrivingAction drivingAction) {
        this.cityName = cityName;
        this.lightColor = lightColor;
        this.drivingType = drivingType;
        this.drivingActionType = drivingAction;
    }
}
