package edu.tacoma.uw.projectsprint1_group9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests for the Feedback class.
 */
public class FeedbackTest {

    @Test
    public void testFeedbackConstructor() {
        assertNotNull(new Feedback("Enrique Vargas", "Senior", "Great app!"));
    }

    @Test
    public void testFeedbackGetName() {
        Feedback testFeedback = new Feedback("James Lau", "Senior", "Nice app");
        assertEquals("James Lau", testFeedback.getName());
    }

    @Test
    public void testFeedbackSetName() {
        Feedback testFeedback = new Feedback("Michael Tuskan", "Senior", "!");
        testFeedback.setName("Michael Tuskan");
        assertEquals("Michael Tuskan", testFeedback.getName());
    }

    @Test
    public void testFeedbackGetYear() {
        Feedback testFeedback = new Feedback("Enrique Vargas", "Senior", "Great app!");
        assertEquals("Senior", testFeedback.getYear());
    }

    @Test
    public void testFeedbackSetYear() {
        Feedback testFeedback = new Feedback("James Lau", "Sophomore", "Great app!");
        testFeedback.setYear("Sophomore");
        assertEquals("Sophomore", testFeedback.getYear());
    }

    @Test
    public void testFeedbackGetFeedback() {
        Feedback testFeedback = new Feedback("Enrique Vargas", "Senior", "Great app!");
        assertEquals("Great app!", testFeedback.getFeedback());
    }

    @Test
    public void testFeedbackSetFeedback() {
        Feedback testFeedback = new Feedback("Enrique Vargas", "Senior", "Great course!");
        testFeedback.setFeedback("Needs improvement.");
        assertEquals("Needs improvement.", testFeedback.getFeedback());
    }

}
