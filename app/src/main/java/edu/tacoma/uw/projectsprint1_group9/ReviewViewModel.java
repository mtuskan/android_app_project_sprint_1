package edu.tacoma.uw.projectsprint1_group9;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ViewModel for managing  feedback.
 *
 * @author Enrique Vargas
 */
public class ReviewViewModel extends AndroidViewModel {
    private MutableLiveData<JSONObject> mResponse;
    private MutableLiveData<List<Feedback>> mReviewsList;

    /**
     * Constructor for ReviewViewModel.
     *
     * @param application The application context.
     */
    public ReviewViewModel(@NonNull Application application) {
        super(application);
        mResponse = new MutableLiveData<>();
        mResponse.setValue(new JSONObject());
        mReviewsList = new MutableLiveData<>();
        mReviewsList.setValue(new ArrayList<>());
    }

    /**
     * Add an observer to the response.
     *
     * @param owner    The LifecycleOwner.
     * @param observer The observer.
     */
    public void addResponseObserver(@NonNull LifecycleOwner owner,
                                    @NonNull Observer<? super JSONObject> observer) {
        mResponse.observe(owner, observer);
    }

    /**
     * Handle errors from Volley requests.
     *
     * @param error The VolleyError.
     */
    private void handleError(final VolleyError error) {
        if (Objects.isNull(error.networkResponse)) {
            try {
                mResponse.setValue(new JSONObject("{" +
                        "error:\"" + error.getMessage() +
                        "\"}"));
            } catch (JSONException e) {
                Log.e("JSON PARSE", "JSON Parse Error in handleError");
            }
        } else {
            String data = new String(error.networkResponse.data, Charset.defaultCharset())
                    .replace('\"', '\'');
            try {
                mResponse.setValue(new JSONObject("{" +
                        "code:" + error.networkResponse.statusCode +
                        ", data:\"" + data +
                        "\"}"));
            } catch (JSONException e) {
                Log.e("JSON PARSE", "JSON Parse Error in handleError");
            }
        }
    }

    /**
     * Add a review to the database.
     *
     * @param name     The name of the reviewer.
     * @param year     The year of the review.
     * @param feedback The feedback.
     */
    public void addReview(String name, String year, String feedback) {
        String url = "https://students.washington.edu/enriquev/add_review.php";
        JSONObject body = new JSONObject();
        try {
            body.put("name", name);
            body.put("year", year);
            body.put("feedback", feedback);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Request request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                body, //no body for this get request
                mResponse::setValue,
                this::handleError);

        Log.i("ReviewViewModel", request.getUrl().toString());
        request.setRetryPolicy(new DefaultRetryPolicy(
                10_000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //Instantiate the RequestQueue and add the request to the queue
        Volley.newRequestQueue(getApplication().getApplicationContext())
                .add(request);
    }

    /**
     * Add an observer to the feedback list.
     *
     * @param owner    The LifecycleOwner.
     * @param observer The observer.
     */
    public void addFeedbackListObserver(@NonNull LifecycleOwner owner,
                                        @NonNull Observer<? super List<Feedback>> observer) {
        mReviewsList.observe(owner, observer);
    }

    /**
     * Handle the result of the getReviews request.
     *
     * @param result The JSON result.
     */
    private void handleResult(final JSONObject result) {
        try {
            String data = result.getString("review");
            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Feedback review = new Feedback(obj.getString(Feedback.NAME), obj.getString(Feedback.YEAR), obj.getString(Feedback.FEEDBACK));
                mReviewsList.getValue().add(review);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ERROR!", e.getMessage());
        }
        mReviewsList.setValue(mReviewsList.getValue());
    }

    /**
     * Get reviews from the database.
     */
    public void getReviews() {
        String url = "https://students.washington.edu/enriquev/get_reviews.php";

        Request request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, //no body for this get request
                this::handleResult,
                this::handleError);

        request.setRetryPolicy(new DefaultRetryPolicy(
                10_000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        //Instantiate the RequestQueue and add the request to the queue
        Volley.newRequestQueue(getApplication().getApplicationContext())
                .add(request);
    }
}
