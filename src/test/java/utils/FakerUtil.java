package utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    private static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    // ✅ Always valid email
    public static String getEmail() {
        return "user" + System.currentTimeMillis() + "@test.com";
    }

    public static String getPassword() {
        return "Test@" + faker.number().digits(4);
    }

    // ✅ Checkout data
    public static String getCity() {
        return faker.address().city();
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getZipCode() {
        String zip = faker.address().zipCode().replaceAll("[^0-9]", "");
        return zip.length() >= 6 ? zip.substring(0, 6) : "600001";
    }

    public static String getPhoneNumber() {
        return "9" + faker.number().digits(9);
    }
}