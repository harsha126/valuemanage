package com.valuemanage.validation;

import com.valuemanage.domain.NewRetailer;

import java.util.regex.Pattern;

public class Validate {

    public boolean validateRetailer(NewRetailer newRetailer){
        Pattern p = Pattern.compile("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$");

        return ((newRetailer.getName()!=null)&&(newRetailer.getName().trim().length()!=0)&&
                (newRetailer.getCity()!=null)&&(newRetailer.getCity().trim().length()!=0)&&
                (newRetailer.getStreet()!=null)&&(newRetailer.getStreet().trim().length()!=0)&&
                (newRetailer.getCountry()!=null)&&(newRetailer.getCountry().trim().length()!=0)&&
                (newRetailer.getOwner()!=null)&&(newRetailer.getOwner().trim().length()!=0)&&
                (newRetailer.getBusinessName()!=null)&&(newRetailer.getBusinessName().trim().length()!=0)&&
                (newRetailer.getState()!=null)&&(newRetailer.getState().trim().length()!=0)&&
                (newRetailer.getHouseNo()!=null)&&(newRetailer.getHouseNo().trim().length()!=0)&&
                (newRetailer.getPinCode()!=null)&&(newRetailer.getPinCode().trim().length()!=0)&&
                (newRetailer.getPhoneNumber()!=null)&&(newRetailer.getPhoneNumber().trim().length()!=0));
    }
}
