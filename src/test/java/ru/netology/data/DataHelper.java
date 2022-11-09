package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardNumber {
        private String cardNumber;
        private String status;
    }

    public static CardNumber approvedCardInfo() {
        return new CardNumber("4444 4444 4444 4441", "APPROVED");
    }

    public static CardNumber declinedCardInfo() {

        return new CardNumber("4444 4444 4444 4442", "DECLINED");
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getInvalidCardNumber() {
        Faker faker = new Faker();
        return Long.toString(faker.number().randomNumber(7, true));
    }

    public static String getEmptyCardNumber() {
        return " ";
    }

    public static String getValidMonth() {
        String[] month = {"01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12"};
        int rnd = new Random().nextInt(month.length);
        return month[rnd];
    }

    public static String getInvalidMonth1() {
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        int rnd = new Random().nextInt(month.length);
        return month[rnd];
    }

    public static String getNullMonth() {
        return "00";
    }

    public static String getInvalidMonth2() {
        String[] month = {"13", "15", "17", "19", "21", "23"};
        int rnd = new Random().nextInt(month.length);
        return month[rnd];
    }

    public static String getEmptyMonth() {
        return " ";
    }

    public static String getValidYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getInvalidYear() {
        String[] year = {"1", "2", "3", "4"};
        int rnd = new Random().nextInt(year.length);
        return year[rnd];
    }

    public static String getInvalidLastYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getInvalidFutureYear() {
        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getNullYear() {
        return "00";
    }

    public static String getEmptyYear() {
        return " ";
    }

    public static String getValidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getInvalidOwnerCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getInvalidOwnerNumber() {
        String[] symbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        int rnd = new Random().nextInt(symbols.length);
        return symbols[rnd];
    }

    public static String getInvalidOwnerSpecialCharacter() {
        String[] symbols = {"(", ")", "*", "&", "^", "/", "$", "%", "~"};
        int rnd = new Random().nextInt(symbols.length);
        return symbols[rnd];
    }

    public static String getInvalidOwnerRegister() {
        String[] register = {"vIcTor PetRoV", "IvAn iVanoV", "SeRgey sEdoV"};
        int rnd = new Random().nextInt(register.length);
        return register[rnd];
    }

    public static String getInvalidOwnerUnderLength() {
        String[] character = {"A", "B", "C", "D", "F", "G", "H", "I", "K", "L"};
        int rnd = new Random().nextInt(character.length);
        return character[rnd];
    }

    public static String getInvalidOwnerOverLength() {
        return "WEWRWERWEFWERFWEFWEHFKWGFEEWEFFWERGWGRWGHERWFRWFERFWEFRWFERFWFERWERWEEWVEWCEUWRWEGWECWERWERUWCEWECWVCECWVWEWVCVWEWEWRJHEHWWGEGRJGEWDFAFSDFFQFWFEQWFEQFWDFFWQFYFQYFWETFQWFQFFQWDFQFWFEQFWEASDFAAFUDFADAUFDADFAUFDAFDTAFGDFGFUUDFASFDAFDSFADAFDAFDFAFDAFSDFATDADADFASDAFSDSAFSDF";
    }

    public static String getEmptyOwner() {
        return " ";
    }

    public static String getValidCvc() {
        Faker faker = new Faker();
        String cvc = faker.numerify("###");
        return cvc;
    }

    public static String getInvalidCvc() {
        Faker faker = new Faker();
        String cvc = faker.numerify("#");
        return cvc;
    }

    public static String getNullCvc() {
        return "000";
    }

    public static String getEmptyCvc() {
        return " ";
    }
}