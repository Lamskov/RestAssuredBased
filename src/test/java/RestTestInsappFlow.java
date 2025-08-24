import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.NewPojo;
import pojos.SendOsagoApplication;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestTestInsappFlow {
    private static final String URL_NEW = "https://test-api.insapp.pro/app/new";
    private static final String API_KEY = "b90352835097480fa062713bf706f6b1";


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = URL_NEW;
    }


    @Test
    public void testNew() {

       NewPojo response = given()
                .contentType("application/json")
                .body("{ \"apiKey\": \"" + API_KEY + "\", \"productType\": \"Osago\" }")
        .when()
                .post(URL_NEW)
        .then()
               .log().all()
                .statusCode(200)
                .extract().as(NewPojo.class);


        String appId = "08ddde1f-4da7-1c0e-bee7-4335ac05fdce";
        /*String appId2 = response.getValue().getAbTestingGroups();*/

        assertNotNull(appId, "applicationId должен быть заполнен");
        assertTrue(appId.matches("^[0-9a-fA-F\\-]{36}$"), "applicationId должен быть UUID");


        SendOsagoApplication.Root requestSendOsagoApplication = new SendOsagoApplication.Root();
        requestSendOsagoApplication.setApiKey(API_KEY);
        requestSendOsagoApplication.setApplicationId(appId);

        SendOsagoApplication.CarData carData = new SendOsagoApplication.CarData();
        carData.setHasNoLicensePlate(false);
        carData.setLicensePlate("У395МН03");
        carData.setCarPower(110);
        carData.setModelId(1280);
        carData.setProductionYear(2008);


        SendOsagoApplication.CarDocument carDocument = new SendOsagoApplication.CarDocument();
        carDocument.setDocumentIssueDate("05.10.2023");
        carDocument.setDocumentNumber("012269");
        carDocument.setDocumentSeries("9954");
        carDocument.setDocumentType("STS");
        carData.setCarDocument(carDocument);

        SendOsagoApplication.CarIdentificators carIdentificators = new SendOsagoApplication.CarIdentificators();
        carIdentificators.setBodyNumber("NZE1419116396");
        carData.setCarIdentificators(carIdentificators);

        SendOsagoApplication.DiagnosticCard diagnosticCard = new SendOsagoApplication.DiagnosticCard();
        diagnosticCard.setHasNoCard(false);
        carData.setDiagnosticCard(diagnosticCard);

        SendOsagoApplication.Driver driver = new SendOsagoApplication.Driver();
        driver.setBirthDate("31.03.1988");
        driver.setExperienceStartDate("15.02.2011");
        driver.setFirstName("Алексей");
        driver.setMiddleName("Петрович");
        driver.setLastName("Лосев");
        driver.setGender("Male");

        SendOsagoApplication.DriverLicense driverLicense = new SendOsagoApplication.DriverLicense();
        driverLicense.setForeignLicense(false);
        driverLicense.setLicenseIssueDate("11.07.2019");
        driverLicense.setLicenseNumber("002735");
        driverLicense.setLicenseSeries("9911");
        driver.setDriverLicense(driverLicense);

        SendOsagoApplication.Owner owner = new SendOsagoApplication.Owner();
        owner.setBirthDate("31.03.1988");
        owner.setFirstName("Алексей");
        owner.setMiddleName("Петрович");
        owner.setLastName("Лосев");
        owner.setGender("Female");
        owner.setOwnerIsInsured(true);
        owner.setPhone("79190000000");
        owner.setEmail("test@test.ru");

        SendOsagoApplication.Passport passport = new SendOsagoApplication.Passport();
        passport.setDepartmentCode("671410");
        passport.setPassportIssueDate("02.12.2008");
        passport.setPassportIssuer("ОВД города Москвы");
        passport.setPassportNumber("236312");
        passport.setPassportSeries("8108");

        SendOsagoApplication.PolicyParameters policyParameters = new SendOsagoApplication.PolicyParameters();
        policyParameters.setOsagoUtilisationPeriod(12);
        policyParameters.setPolicyStartDate("25.08.2025");
        requestSendOsagoApplication.setPolicyParameters(policyParameters);

        SendOsagoApplication.RegistrationAddressData registrationAddressData = new SendOsagoApplication.RegistrationAddressData();
        registrationAddressData.setAddressAsString("Респ Бурятия, село Хоринск, ул Восточная, д 28");
        registrationAddressData.setHasNoApartment(false);
        passport.setRegistrationAddressData(registrationAddressData);

     requestSendOsagoApplication.setHasDriversRestriction(true);
     requestSendOsagoApplication.setDrivers(java.util.List.of(driver));
     owner.setPassport(passport);
     requestSendOsagoApplication.setOwner(owner);
     requestSendOsagoApplication.setCarData(carData);

     given()
             .contentType("application/json")
             .body(requestSendOsagoApplication)
             .when()
             .post("https://test-api.insapp.pro/app/SendOsagoApplication")
             .then()
             .statusCode(200)
             .log().body();

    }


}
