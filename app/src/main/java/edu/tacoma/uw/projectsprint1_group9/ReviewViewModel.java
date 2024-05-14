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

public class ReviewViewModel extends AndroidViewModel {
    private MutableLiveData<JSONObject> mResponse;

    private MutableLiveData<List<Reviews>> mReviewsList;

    public ReviewViewModel(@NonNull Application application) {
        super(application);
        mResponse = new MutableLiveData<>();
        mResponse.setValue(new JSONObject());
        mReviewsList = new MutableLiveData<>();
        mReviewsList.setValue(new ArrayList<>());

    }

    public void addResponseObserver(@NonNull LifecycleOwner owner,
                                    @NonNull Observer<? super JSONObject> observer) {
        mResponse.observe(owner, observer);
    }

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

    public void addReviewListObserver(@NonNull LifecycleOwner owner,
                                      @NonNull Observer<? super List<Reviews>> observer) {
        mReviewsList.observe(owner, observer);
    }

    private void handleResult(final JSONObject result) {
        try {
            String data = result.getString("review");
            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Reviews review = new Reviews(obj.getString(Reviews.NAME), obj.getString(Reviews.YEAR), obj.getString(Reviews.FEEDBACK));
                mReviewsList.getValue().add(review);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ERROR!", e.getMessage());
        }
        mReviewsList.setValue(mReviewsList.getValue());
    }

    public void getReviews() {

        String url =

                "https://students.washington.edu/enriquev/get_reviews.php";

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
