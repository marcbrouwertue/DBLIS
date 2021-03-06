package dblis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

public class ServerAccess {

    //Convert an inputstream to a string
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            //Log.e("PHP Client","Error : "+e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e1) {
                //Log.e("PHP Client","Error : "+e1.getMessage());
            }
        }
        return sb.toString();
    }

    private Object getResponseObject(String method, Map<String, Object> params) {
        return getResponseObject(1, 3, method, params);
    }
    
    //Get the response form the server as an object
    private Object getResponseObject(int t, int max, String method, Map<String, Object> params) {
        while (t <= max) {
            try {
                //Create a HTTP Client
                HttpClient httpclient = new DefaultHttpClient();
                
                //Create and object to Post values to the server
                //The url is specified in the Constants class to increase modifiability
                HttpPost httppost = new HttpPost("http://www.externalhost.nl/ws/"
                        + "dblis/webservice.php?method=" + method);

                JSONObject holder = new JSONObject(params);

                //convert parameters into JSON object
                //JSONObject holder = getJsonObjectFromMap(params);

                //passes the results to a string builder/entity
                StringEntity se = new StringEntity(holder.toString(), Charset.forName("UTF-8"));

                //sets the post request as the resulting string
                httppost.setEntity(se);

                //sets a request header so the page receving the request
                //will know what to do with it
                httppost.setHeader("Accept", "application/json");
                httppost.setHeader("Content-type", "application/json; charset=utf-8");

                //Handles what is returned from the page 
                ResponseHandler responseHandler = new BasicResponseHandler();
                return httpclient.execute(httppost, responseHandler);
            } catch (Exception e) {
                System.out.println("PHP Client - Error in http connection "
                        + "(" + t + "/" + max + ") " + e.toString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                }
                return getResponseObject(t + 1, max, method, params);
            }
        }
        return null;
    }
    
    public final boolean addTweet(TweetEntity entity) {
        final Map<String, Object> params = new HashMap();
        params.put("tweetid", "[" + entity.getID() + "]");
        params.put("retweetid", "[" + entity.getRetweetID() + "]");
        params.put("retweets", entity.getRetweets());
        params.put("favourites", entity.getFavourites());
        params.put("text", entity.getText());
        params.put("creationtime", entity.getTime());
        params.put("countrycode", entity.getCountry());
        params.put("language", entity.getLanguage());
        params.put("userid", "[" + entity.getUserID() + "]");
        params.put("keywords", entity.getKeywords());
        
        final Object obj = getResponseObject("addTweet", params);
        if (!obj.equals("true") && !obj.equals("false")) {
            System.out.println(obj);
        }
        return obj.equals("true");
    }
    
    public final boolean addUser(UserEntity entity) {
        final Map<String, Object> params = new HashMap();
        params.put("userid", "[" + entity.getID() + "]");
        params.put("name", entity.getName());
        params.put("followers", entity.getFollowers());
        params.put("favourites", entity.getFavourites());
        params.put("friends", entity.getFriends());
        
        final Object obj = getResponseObject("addUser", params);
        if (!obj.equals("true") && !obj.equals("false")) {
            System.out.println(obj);
        }
        return obj.equals("true");
    }
    
    public final Set<Long> getTweetsIDs() {
        final Set<Long> set = new HashSet();
        try {
            final JSONArray json = 
                    new JSONArray(getResponseObject("getTweetsIDs", null).toString());
            for (int i = 0; i < json.length(); i++) {
                set.add(json.getJSONObject(i).getLong("id"));
            }
        } catch (Exception ex) {
            System.out.println("DBLIS - getTweetsIDs - " + ex);
        }
        return set;
    }
    
    public final JSONArray getSports() throws JSONException {
        return new JSONArray(getResponseObject("getSports", null).toString());
    }
    
    public final List<String> getSportsGB() {
        final List<String> list = new ArrayList<>();
        try {
            final JSONArray json = 
                    new JSONArray(getResponseObject("getSportsGB", null).toString());
            for (int i = 0; i < json.length(); i++) {
                list.add(json.getJSONObject(i).getString("sport"));
            }
        } catch (Exception ex) {
            System.out.println("DBLIS - getSports - " + ex);
        }
        return list;
    }
    
    @Deprecated
    public final JSONArray getCommonSports(String countryCode, int top) 
            throws JSONException {
        final Map<String, Object> params = new HashMap();
        params.put("countrycode", countryCode);
        params.put("number", top);
        return new JSONArray(
                getResponseObject("getCommonSports", params).toString());
    }
    
    @Deprecated
    public final JSONArray getPopularSportCountries(String sport, int top) 
            throws JSONException {
        final Map<String, Object> params = new HashMap();
        params.put("sport", sport);
        params.put("number", top);
        final String response = 
                getResponseObject("getPopularSportCountries", params).toString();
        return new JSONArray(response);
    }
    
    public final JSONArray getGeolocations() throws JSONException {
        return new JSONArray(getResponseObject("getGeolocations", null).toString());
    }
    
    public final JSONArray getMostCommonSports(String countryCode) 
            throws JSONException {
        final Map<String, Object> params = new HashMap();
        params.put("countrycode", countryCode);
        final String response =
                getResponseObject("getMostCommonSports", params).toString();
        return new JSONArray(response);
    }
    
    public final JSONArray getMostCommonCountries(String sport, int top) 
            throws JSONException {
        final Map<String, Object> params = new HashMap();
        params.put("sport", sport);
        params.put("number", top);
        final String response = 
                getResponseObject("getMostCommonCountries", params).toString();
        return new JSONArray(response);
    }
   
    public final Map<String, String> getAlternatives(String sport) {
        final Map<String, String> alts = new HashMap();
        
        try {
            final Map<String, Object> params = new HashMap();
            params.put("sport", sport);
            final String response
                    = getResponseObject("getAlternatives", params).toString();
            final JSONArray json = new JSONArray(response);

            JSONObject obj;
            String alt, type;
            for (int i = 0; i < json.length(); i++) {
                try {
                    obj = json.getJSONObject(i);
                    alt = obj.getString("keyword");
                    type = obj.getString("type");
                    alts.put(alt, type);
                } catch (JSONException ex) {
                    System.out.println("getAlternatives - " + ex);
                }
            }
        } catch (JSONException ex) {
            System.out.println("getAlternatives - " + ex);
        }
        
        return alts;
    }
    
    public final List<String> getCountryCodes() {
        final List<String> list = new ArrayList<>();
        
        try {
            final JSONArray json = 
                    new JSONArray(getResponseObject("getCountryCodes", null).toString());
            String code;
            
            for (int i = 0; i < json.length(); i++) {
                try {
                    code = json.getJSONObject(i).getString("countryCode");
                    list.add(code);
                } catch (Exception ex) {
                    System.out.println("getCountryCodes - " + ex);
                }
            }

        } catch (Exception ex) {
            System.out.println("getCountryCodes - " + ex);
        }
        
        return list;
    }
    
    public final int getRelatedTweetsCountryCount(String country, String sport, 
            String type, long starttime, long endtime) {
        try {
            final Map<String, Object> params = new HashMap();
            params.put("countrycode", country);
            params.put("sport", sport);
            params.put("type", type);
            params.put("starttime", starttime);
            params.put("endtime", endtime);
            final String response = 
                    getResponseObject("getRelatedTweetsCountryCount", params).toString();
            final JSONArray json = new JSONArray(response);
            if (json.getJSONObject(0).isNull("sum")) {
                return 0;
            }
            return json.getJSONObject(0).getInt("sum");
        } catch (JSONException ex) {
            System.out.println("getRelatedTweetsCountryCount - " + ex);
            return 0;
        }
    }
    
    public final ChartData getRelatedTweetsCountryCountSingle(String country, 
            String sport, String type, long starttime, long endtime) {
        try {
            final Map<String, Object> params = new HashMap();
            params.put("sport", sport);
            params.put("countrycode", country);
            params.put("type", type);
            params.put("starttime", starttime);
            params.put("endtime", endtime);
            final String response = getResponseObject(
                    "getRelatedTweetsCountryCountSingle", params)
                    .toString();
            final JSONArray json = new JSONArray(response);
           
            int sum;
            JSONObject obj = json.getJSONObject(0);
            if (obj.isNull("sum")) {
                sum = 0;
            } else {
                sum = obj.getInt("sum");
            }
            return new ChartData(sport, sum);
        } catch (Exception ex) {
            System.out.println("getRelatedTweetsCountryCountSingle - " + ex);
        }
        
        return null;
    }
    
    public final int getArea(String country) {
        try {
            final Map<String, Object> params = new HashMap();
            params.put("countrycode", country);
            final JSONArray json
                    = new JSONArray(getResponseObject("getArea", params).toString());
            if (json.getJSONObject(0).isNull("area")) {
                return 0;
            }
            return json.getJSONObject(0).getInt("area");
        } catch (JSONException ex) {
            //System.out.println("getArea - " + ex);
            return 0;
        }
    }
    
    public final List<ChartData> getKeywordsPopularityCount(String country, 
            String sport, String type, long starttime, long endtime) {
        final List<ChartData> list = new ArrayList<>();
        
        try {
            final Map<String, Object> params = new HashMap();
            params.put("sport", sport);
            params.put("countrycode", country);
            params.put("type", type);
            params.put("starttime", starttime);
            params.put("endtime", endtime);
            final String response = getResponseObject(
                    "getKeywordsPopularityCount", params)
                    .toString();
            final JSONArray json = new JSONArray(response);
            
            JSONObject obj;
            String keywords;
            int sum;
            for (int i = 0; i < json.length(); i++) {
                try {
                    obj = json.getJSONObject(i);
                    keywords = obj.getString("keywords");
                    if (obj.isNull("sum")) {
                        sum = 0;
                    } else {
                        sum = obj.getInt("sum");
                    }
                    list.add(new ChartData(keywords, sum));
                } catch (Exception ex) {
                    System.out.println("getKeywordsPopularityCount - " + ex);
                }
            }

        } catch (Exception ex) {
            System.out.println("getKeywordsPopularityCount - " + ex);
        }
        
        return list;
    }
    
    public final List<ChartData> getRelatedTweetsCountAll(List<String> sports, 
            String type) {
        return getRelatedTweetsCountAll(1, 3, sports, type);
    }
    
    public final List<ChartData> getRelatedTweetsCountAll(int t, int max,
            List<String> sports, String type) {
        final List<ChartData> list = new ArrayList<>();
        
        String response = "";
        final Map<String, Object> params = new HashMap();
        params.put("type", type);
        
        while (t <= max) {
            try {
                response = getResponseObject(
                        "getRelatedTweetsCountAll", params).toString();
                final JSONArray json = new JSONArray(response);

                JSONObject obj = json.getJSONObject(0);
                int sum;
                for (String sport : sports) {
                    try {
                        if (obj.isNull(sport)) {
                            sum = 0;
                        } else {
                            sum = obj.getInt(sport);
                        }
                        list.add(new ChartData(sport, sum));
                    } catch (Exception ex) {
                        System.out.println("getRelatedTweetsCountAll - "
                                + "(" + t + "/" + max + ") " + ex);
                        return getRelatedTweetsCountAll(t + 1, max, sports, type);
                    }
                }

            } catch (Exception ex) {
                System.out.println("getRelatedTweetsCountAll - "
                        + "(" + t + "/" + max + ") " + ex);
                System.out.println("getRelatedTweetsCountAll - "
                        + "(" + t + "/" + max + ") response: "+ response);
                return getRelatedTweetsCountAll(t + 1, max, sports, type);
            }
        }
        
        return list;
    }
    
    
    // Get all tweets first
    
    public final int getTweetsCountNL() {
        try {
            final String response = 
                    getResponseObject("getTweetsCountNL", null).toString();
            final JSONArray json = new JSONArray(response);
            if (json.getJSONObject(0).isNull("count")) {
                return 0;
            }
            return json.getJSONObject(0).getInt("count");
        } catch (JSONException ex) {
            System.out.println("getTweetsCountNL - " + ex);
            return 0;
        }
    }
    
    public final Set<TweetEntity> getTweetsNL(int numberTweets) {
        final int part = 50000;
        final Set<TweetEntity> tweets = new HashSet();
        
        int tries = 0;
        int limitlow = 0;
        int limithigh = part;
        if (limithigh > numberTweets) {
            limithigh = numberTweets;
        }
        
        while (limithigh <= numberTweets && limitlow < limithigh) {
            try {
                final Map<String, Object> params = new HashMap();
                params.put("limitlow", limitlow);
                params.put("limithigh", limithigh);
                final String response = getResponseObject(
                        "getTweetsNL", params)
                        .toString();
                final JSONArray json = new JSONArray(response);

                JSONObject obj;
                TweetEntity te;
                for (int i = 0; i < json.length(); i++) {
                    try {
                        obj = json.getJSONObject(i);
                        te = new TweetEntity(
                                obj.getLong("id"), 
                                obj.getLong("retweetid"), 
                                obj.getInt("retweets"), 
                                obj.getInt("favourites"), 
                                obj.getString("text"), 
                                obj.getLong("creationTime"), 
                                obj.getString("countryCode"), 
                                obj.getString("language"), 
                                obj.getLong("userID"), 
                                obj.getString("keywords"));
                        tweets.add(te);
                    } catch (JSONException ex) {
                        System.out.println("getTweetsNL - " + ex);
                    }
                }
                
                limitlow += part;
                limithigh += part;
                if (limithigh > numberTweets) {
                    limithigh = numberTweets;
                }
                tries = 0;
            } catch (JSONException ex) {
                tries++;
                System.out.println("getTweetsNL - " + ex);
            }
            
        }
        
        return tweets;
    }
    
    public final Set<TweetEntity> getTweetsPartNL(int limitlow, int limithigh)
            throws JSONException {
        final Set<TweetEntity> tweets = new HashSet();
        
        final Map<String, Object> params = new HashMap();
        params.put("limitlow", limitlow);
        params.put("limithigh", limithigh);
        final String response = getResponseObject(
                "getTweetsNL", params)
                .toString();
        final JSONArray json = new JSONArray(response);

        JSONObject obj;
        TweetEntity te;
        for (int i = 0; i < json.length(); i++) {
            try {
                obj = json.getJSONObject(i);
                te = new TweetEntity(
                        obj.getLong("id"),
                        obj.getLong("retweetid"),
                        obj.getInt("retweets"),
                        obj.getInt("favourites"),
                        obj.getString("text"),
                        obj.getLong("creationTime"),
                        obj.getString("countryCode"),
                        obj.getString("language"),
                        obj.getLong("userID"),
                        obj.getString("keywords"));
                tweets.add(te);
            } catch (JSONException ex) {
                System.out.println("getTweetsNL - " + ex);
            }
        }

        return tweets;
    }
    
}