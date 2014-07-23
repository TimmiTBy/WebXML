package com.epam.XMLweb.entity.bathroom;

import com.epam.XMLweb.entity.abstractdevice.Device;
import org.apache.log4j.Logger;

public class HairDryer extends Device {

    public static final Logger LOG = Logger.getLogger(HairDryer.class);

    public static final int MIN_WIND_SPEED = 60 ;
    public static final int MEDIUM_WIND_SPEED = 80;
    public static final int MAX_WIND_SPEED = 100;


    private EHairDryerMode mode;
    private int windSpeed;

    public HairDryer() {
        LOG.info("HairDryer has been created");
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        if (windSpeed > 0) {
            this.windSpeed = windSpeed;
        } else {
            LOG.warn("Negative windSpeed is meaningless");
        }
    }

    public EHairDryerMode getMode() {
        return mode;
    }

    public void setMode(EHairDryerMode mode) {
        this.mode = mode;
    }

    public void dry() {
       setMode(EHairDryerMode.HGHT);
       setWindSpeed(MAX_WIND_SPEED);
       LOG.info("Dry is going on" + EHairDryerMode.HGHT  + " mode with windspeed = " + windSpeed);
    }

    public void blowOn() {
        setMode(EHairDryerMode.MEDIUM);
        setWindSpeed(MEDIUM_WIND_SPEED);
        LOG.info("HairDryer working on "+ EHairDryerMode.MEDIUM +" mode, windspeed  = " + windSpeed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HairDryer other = (HairDryer) obj;
        if (windSpeed != other.windSpeed) {
            return false;
        }
        if(this.getPower() != other.getPower()) {
            return false;
        }
        if(this.getCost() != other.getCost()) {
            return false;
        }
        if(this.getWeight() != other.getWeight()) {
            return false;
        }
        if(this.isOn() != other.isOn()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + windSpeed;
        return result;
    }

    @Override
    public String toString() {
        return "HairDryer with " + getPower() + " power, status " +  isOn()  + "; ";
    }
}
