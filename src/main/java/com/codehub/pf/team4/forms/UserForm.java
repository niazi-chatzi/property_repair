package com.codehub.pf.team4.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserForm {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&!]*$";
    private static final String AFM_PATTERN = "^[0-9]*$";
    private static final String PHONE_NUMBER_PATTERN = "^[0-9]*$";

    private static final int EMAIL_MIN_SIZE = 3;
    private static final int EMAIL_MAX_SIZE = 40;
    private static final int PASSWORD_MIN_SIZE = 8;
    private static final int PASSWORD_MAX_SIZE = 50;
    private static final int AFM_SIZE = 9;
    private static final int PHONE_NUMBER_MIN_SIZE = 10;
    private static final int PHONE_NUMBER_MAX_SIZE = 10;

    @Pattern(regexp = EMAIL_PATTERN, message = "Email pattern doesn't match")
    @Size(min = EMAIL_MIN_SIZE, max = EMAIL_MAX_SIZE, message = "Email must be between 3 and 40 characters")
    @NotEmpty(message = "Email can't be empty")
    private String email;

    @Pattern(regexp = AFM_PATTERN, message = "Afm pattern doesn't match")
    @Size(min = AFM_SIZE, max = AFM_SIZE, message = "Afm length must be 9")
    @NotEmpty(message = "Afm can't be empty")
    private String afm;

    @Pattern(regexp = PASSWORD_PATTERN, message = "Password pattern doesn't match")
    @Size(min = PASSWORD_MIN_SIZE, message = "Password length can't be less than 8")
    @NotEmpty(message = "Password can't be empty")
    private String password;

    @Pattern(regexp = PHONE_NUMBER_PATTERN, message  = "Phone Number pattern doesn't match")
    @Size(min = PHONE_NUMBER_MIN_SIZE, max = PHONE_NUMBER_MAX_SIZE, message = "Phone Number length must be 10")
    @NotEmpty(message = "Phone Number can't be empty")
    private String phoneNumber;

    //Validation on UserValidator
    private String id;

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    private String houseType;

    private String address;
    private String firstName;
    private String lastName;


}
