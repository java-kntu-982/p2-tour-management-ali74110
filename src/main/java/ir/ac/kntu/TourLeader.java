package ir.ac.kntu;


import java.util.Arrays;

/**
 * @author Seyed Ali Toliat
 */
public class TourLeader {
    private String firstName ;
    private String lastName ;
    private long nationalCode;
    private long identityNum;
    private Date birthDate = new Date();
    private boolean married;
    private String[] placesKnew = new String[100];
    /*---------------------------------------------------*/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setIdentityNum(long identityNum) {
        this.identityNum = identityNum;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setPlacesKnew(String[] placesKnew) {
        this.placesKnew = placesKnew;
    }
    /*---------------------------------------------------*/

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode=" + nationalCode +
                ", identityNum=" + identityNum +
                ", birthDate=" + birthDate +
                ", married=" + married +
                ", placesKnew=" + Arrays.toString(placesKnew) +
                '}';
    }

}

