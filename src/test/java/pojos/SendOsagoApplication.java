package pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public  class SendOsagoApplication {

    @Data @NoArgsConstructor
    public static class CarData{
        private boolean hasNoLicensePlate;
        private String licensePlate;
        private int carPower;
        private DiagnosticCard diagnosticCard;
        private int modelId;
        private int productionYear;
        private CarDocument carDocument;
        private CarIdentificators carIdentificators;
    }

    @Data @NoArgsConstructor
    public   static  class CarDocument{
        private  String documentIssueDate;
        private  String documentNumber;
        private  String documentSeries;
        private  String documentType;
    }

    @Data @NoArgsConstructor
    public   static  class CarIdentificators{
        private  String bodyNumber;
    }

    @Data @NoArgsConstructor
    public   static  class DiagnosticCard{
        private  boolean hasNoCard;
    }

    @Data @NoArgsConstructor
    public   static  class Driver{
        private  String birthDate;
        private  DriverLicense driverLicense;
        private  String experienceStartDate;
        private  String firstName;
        private  String gender;
        private  String lastName;
        private  String middleName;
    }

    @Data @NoArgsConstructor
    public   static class DriverLicense{
        private  boolean isForeignLicense;
        private  String licenseIssueDate;
        private  String licenseNumber;
        private  String licenseSeries;
    }

    @Data @NoArgsConstructor
    public   static  class Owner{
        private  String birthDate;
        private  String firstName;
        private  String gender;
        private  String lastName;
        private  String middleName;
        private  boolean ownerIsInsured;
        private  Passport passport;
        private  String phone;
        private  String email;
    }

    @Data @NoArgsConstructor
    public   static  class Passport{
        private  String departmentCode;
        private  String passportIssueDate;
        private  String passportIssuer;
        private  String passportNumber;
        private  String passportSeries;
        private  RegistrationAddressData registrationAddressData;
    }

    @Data @NoArgsConstructor
    public   static  class PolicyParameters{
        private  int osagoUtilisationPeriod;
        private  String policyStartDate;
    }

    @Data @NoArgsConstructor
    public   static  class RegistrationAddressData{
        private  String addressAsString;
        private  boolean hasNoApartment;
    }

    @Data @NoArgsConstructor
    public   static class Root{
        private  String apiKey;
        private  String applicationId;
        private  CarData carData;
        private  boolean hasDriversRestriction;
        private List<Driver> drivers;
        private  PolicyParameters policyParameters;
        private  Owner owner;
    }
}
