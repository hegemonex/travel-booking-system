package com.solvd.tests;

import com.travel.booking.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;

public class UserTests extends BaseTests {

    @Test
    public void shouldSetFirstName() {
        User user = new User();
        user.setFirstName("John");

        Assert.assertEquals(user.getFirstName(), "John");
    }

    @Test
    public void shouldSetLastName() {
        User user = new User();
        user.setLastName("Doe");

        Assert.assertEquals(user.getLastName(), "Doe");
    }

    @Test
    public void shouldSetEmail() {
        User user = new User();
        user.setEmail("john@gmail.com");

        Assert.assertEquals(user.getEmail(), "john@gmail.com");
    }

    @Test
    public void shouldSetBirthDate() {
        User user = new User();
        LocalDate date = LocalDate.of(1990, 1, 1);

        user.setBirthDate(date);

        Assert.assertEquals(user.getBirthDate(), date);
    }

    @Test
    public void shouldVerifyUserWithSoftAssert() {
        User user = new User();

        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@gmail.com");

        SoftAssert soft = new SoftAssert();

        soft.assertEquals(user.getFirstName(), "John");
        soft.assertEquals(user.getLastName(), "Doe");
        soft.assertEquals(user.getEmail(), "john@gmail.com");

        soft.assertAll();
    }
}