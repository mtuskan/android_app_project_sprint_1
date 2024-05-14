package edu.tacoma.uw.projectsprint1_group9;

import java.io.Serializable;

public class Reviews implements Serializable {

    private String mNames;
    private String mYear;
    private String mFeedback;

    public final static String NAME = "name";
    public final static String YEAR = "year";
    public final static String FEEDBACK = "feedback";

    public Reviews(String name, String year, String feedback) {
        mNames = name;
        mYear = year;
        mFeedback = feedback;
    }

    public String getName() {
        return mNames;
    }

    public void setName(String name) {
        mNames = name;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public void setFeedback(String feedback) {
        mFeedback = feedback;
    }
    public String getFeedback() {
        return mFeedback;
    }


}

