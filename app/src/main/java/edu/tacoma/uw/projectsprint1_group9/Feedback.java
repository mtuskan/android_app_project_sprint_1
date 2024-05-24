package edu.tacoma.uw.projectsprint1_group9;

import java.io.Serializable;


/**
 * A class representing feedback information. Implements Serializable.
 * This class encapsulates the details of feedback, including the name, year, and feedback text.
 *
 * @author Enrique Vargas
 */
public class Feedback implements Serializable {

        /**
         * The name of the person giving the feedback.
         */
        private String mNames;

        /**
         * The year of study of the person giving the feedback.
         */
        private String mYear;

        /**
         * The feedback text.
         */
        private String mFeedback;

        /**
         * Key for the name field in serialized data.
         */
        public final static String NAME = "name";

        /**
         * Key for the year field in serialized data.
         */
        public final static String YEAR = "year";

        /**
         * Key for the feedback field in serialized data.
         */
        public final static String FEEDBACK = "feedback";

        /**
         * Constructor to create a Feedback object.
         *
         * @param name     The name of the person giving the feedback.
         * @param year     The year of study of the person giving the feedback.
         * @param feedback The feedback text.
         */
        public Feedback(String name, String year, String feedback) {
            mNames = name;
            mYear = year;
            mFeedback = feedback;
        }

        /**
         * Gets the name of the person giving the feedback.
         *
         * @return The name.
         */
        public String getName() {
            return mNames;
        }

        /**
         * Sets the name of the person giving the feedback.
         *
         * @param name The name to set.
         */
        public void setName(String name) {
            mNames = name;
        }

        /**
         * Gets the year of study of the person giving the feedback.
         *
         * @return The year.
         */
        public String getYear() {
            return mYear;
        }

        /**
         * Sets the year of study of the person giving the feedback.
         *
         * @param year The year to set.
         */
        public void setYear(String year) {
            mYear = year;
        }

        /**
         * Gets the feedback text.
         *
         * @return The feedback.
         */
        public String getFeedback() {
            return mFeedback;
        }

        /**
         * Sets the feedback text.
         *
         * @param feedback The feedback text to set.
         */
        public void setFeedback(String feedback) {
            mFeedback = feedback;
        }
    }
