package com.solvd.tests;

import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.model.User;
import com.travel.booking.service.impl.UserServiceImpl;
import com.travel.booking.service.interfaces.UserService;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserTests {

    private UserService userService;

    @BeforeClass
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john" + System.currentTimeMillis() + "@gmail.com");
        user.setPhoneNumber("123456");
        user.setBirthDate(LocalDate.of(2000, 1, 1));
        user.setCreatedAt(LocalDateTime.now());

        TravelBookingSystem system = new TravelBookingSystem();
        system.setId(1L);
        user.setTravelBookingSystem(system);

        userService.save(user);

        User saved = userService.findById(user.getId());

        Assert.assertNotNull(saved, "Saved user should not be null.");
        Assert.assertEquals(saved.getFirstName(), "John",
                "First name should match.");
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userService.findAll();

        Assert.assertNotNull(users,
                "User list should not be null.");
    }

    @Test
    public void testFindUserById() {
        User user = new User();
        user.setFirstName("Kate");
        user.setLastName("Smith");
        user.setEmail("kate" + System.currentTimeMillis() + "@gmail.com");
        user.setPhoneNumber("111111");
        user.setBirthDate(LocalDate.of(1999, 5, 5));

        TravelBookingSystem system = new TravelBookingSystem();
        system.setId(1L);
        user.setTravelBookingSystem(system);

        user.setCreatedAt(LocalDateTime.now());

        userService.save(user);

        User found = userService.findById(user.getId());

        Assert.assertEquals(found.getId(), user.getId(),
                "Retrieved user id should match.");
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setFirstName("Old");
        user.setLastName("Name");
        user.setEmail("old" + System.currentTimeMillis() + "@gmail.com");
        user.setPhoneNumber("999");
        user.setBirthDate(LocalDate.now());
        user.setCreatedAt(LocalDateTime.now());

        TravelBookingSystem system = new TravelBookingSystem();
        system.setId(1L);
        user.setTravelBookingSystem(system);

        userService.save(user);

        user.setFirstName("New");
        userService.update(user);

        User updated = userService.findById(user.getId());

        Assert.assertEquals(updated.getFirstName(), "New",
                "User first name should be updated.");
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setFirstName("Delete");
        user.setLastName("Me");
        user.setEmail("delete" + System.currentTimeMillis() + "@gmail.com");
        user.setPhoneNumber("123");
        user.setBirthDate(LocalDate.now());
        user.setCreatedAt(LocalDateTime.now());

        TravelBookingSystem system = new TravelBookingSystem();
        system.setId(1L);
        user.setTravelBookingSystem(system);

        userService.save(user);

        userService.delete(user.getId());

        User deleted = userService.findById(user.getId());

        Assert.assertNull(deleted,
                "Deleted user should not exist.");
    }
}