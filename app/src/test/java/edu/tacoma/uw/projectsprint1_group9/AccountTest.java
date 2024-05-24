package edu.tacoma.uw.projectsprint1_group9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static edu.tacoma.uw.projectsprint1_group9.Account.EMAIL_PATTERN;
import static edu.tacoma.uw.projectsprint1_group9.Account.isValidEmail;
import static edu.tacoma.uw.projectsprint1_group9.Account.isValidPassword;

import org.junit.Test;

public class AccountTest {

    @Test
    public void testAccountConstructor() {
        assertNotNull(new Account("mm8@uw.edu",
                "!Test2"));
    }

    @Test
    public void testAccountConstructorBadEmail() {
        try {
            new Account("mm8@uw", "!Test2");
            fail("Account created with invalid email");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testAccountGetEmail() {
        Account testAccount = new Account("NewEmail@uw.edu",
                "!NewEmail2");
        assertEquals("NewEmail@uw.edu", testAccount.getEmail());
    }

    @Test
    public void testAccountGetPassword() {
        Account testAccount = new Account("newPassword@uw.edu",
                "!Password1");
        assertEquals("!Password1", testAccount.getPassword());
    }

    @Test
    public void testAccountSetEmail() {
        Account testAccount = new Account("newEmail@uw.edu",
                "!Email2");
        testAccount.setEmail("editMyEmail@uw.edu");
        assertEquals("editMyEmail@uw.edu", testAccount.getEmail());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAccountSetEmailException() {
        Account testAccount = new Account("newUser2@uw.edu",
                "!Email2");
        testAccount.setEmail("wrongEmailFormat@uwedu"); //Will throw Exception

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAccountSetPasswordException() {
        Account testAccount = new Account("newPassword@uw.edu",
                "!Password2");
        testAccount.setPassword("Password"); //Will throw Exception

    }

    @Test
    public void testAccountSetPassword() {
        Account testAccount = new Account("newPassword@uw.edu",
                "!Password40");
        testAccount.setPassword("!Password50");
        assertEquals("!Password50", testAccount.getPassword());
    }

    @Test
    public void testAccountIsValidPassword() {
        assertTrue(isValidPassword("!NewPassword2"));
        assertFalse(isValidPassword(null));    //test password if (null)
        assertFalse(isValidPassword("1abc!")); //test password if (length < 6)
        assertFalse(isValidPassword("abcdef")); //test password if (isDigit)
        assertFalse(isValidPassword("123456")); //test password if (isLetterOrDigit)
    }

    @Test
    public void testAccountIsValidEmail() {
        assertTrue(isValidEmail("VaildEmail@uw.edu")); // test email pattern matches
        assertFalse(isValidEmail("InvaildEmail@"));      // test email "\\."
        assertFalse(isValidEmail("InvaildEmail.edu")); //test email "\\@"
    }

    @Test
    public void testAccountPattern() {
        Account testAccount = new Account("TestPattern@uw.edu",
                "!PasswordPattern4");
        assertTrue(EMAIL_PATTERN.matcher(testAccount.getEmail()).matches());
    }
}