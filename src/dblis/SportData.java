package dblis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import twitter4j.JSONException;

/**
 *
 * @author Brouwer M.R.
 */
public class SportData {
    
    // Instance declaration 
    
    /**
     * SportData instance
     */
    private static final SportData instance = new SportData();

    /**
     * Don't let anyone else instantiate this class
     */
    private SportData() {
    }

    /**
     * Gets the SportData instance
     *
     * @return SportData instance
     * @deprecated use {@link SportData2} instead
     */
    @Deprecated
    public synchronized static final SportData getInstance() {
        return instance;
    }
    
    // Variables
    
    /** Temporary country code to pass to chart title */
    private static String countryCode;
    
    /** countryCode => [{sport, popularity}] */
    private static final Map<String, List<ChartData>> retweetCounts = new HashMap();
    
    /** countryCode => [{sport, popularity}] */
    private static final Map<String, List<ChartData>> favCounts = new HashMap();
    
    /** countryCode => [sport => [{keyword, popularity}] ]*/
    private static final Map<String, Map<String, List<ChartData>>> keywordsCountRT = new HashMap();
    
    /** countryCode => [sport => [{keyword, popularity}] ]*/
    private static final Map<String, Map<String, List<ChartData>>> keywordsCountFav = new HashMap();
    
    /** countryCode => area (# geo or radius) */
    @Deprecated
    private static final Map<String, Integer> areas = new HashMap();
    
    // Initialization
    
    public final void init() {
        init(0, 0);
    }
    
    /**
     * Initializes SportData
     */
    public final void init(long starttime, long endtime) {
        System.out.println("SportData - init - start");
        clear();
        
        SportData.getInstance().setCountryCode("NL");
        final ServerAccess sa = new ServerAccess();
        //final List<String> countries = sa.getCountryCodes();
        final List<String> sports = 
                Arrays.asList("football", "hockey", "cycling", "tennis", "skating");//sa.getSportsGB();
        
        /*System.out.println("SportData - init - getRTCount");
        final List<ChartData> sportRTpop = 
                sa.getRelatedTweetsCountAll(sports, "retweets");
        
        System.out.println("SportData - init - getFavCount");
        final List<ChartData> sportFavpop = 
                sa.getRelatedTweetsCountAll(sports, "favourites");*/
        
        //countries.stream().forEach(country -> {
        String country = "NL";
            //SportData.getInstance().addArea(country, sa.getArea(country));
            sports.stream().forEach(sport -> {
                //addRetweetCount(country, sportRTpop);
                //addRetweetCount(country, sportFavpop);
                    System.out.println("SportData - init - get for sport: " + sport);
                    addRetweetCount(country, 
                            new ChartData(sport, 
                                    sa.getRelatedTweetsCountryCount(
                                            country, sport, "retweets", starttime, endtime)
                            )
                    );
                    addFavCount(country, 
                            new ChartData(sport, 
                                    sa.getRelatedTweetsCountryCount(
                                            country, sport, "favourites", starttime, endtime)
                            )
                    );
                    //System.out.println("SportData - init - getKeyCountRT - " + sport);
                    addKeywordsCountRT(country, sport, 
                            sa.getKeywordsPopularityCount(
                                    country, sport, "retweets", starttime, endtime));
                    
                    //System.out.println("SportData - init - getKeyCountFav - " + sport);
                    addKeywordsCountFav(country, sport, 
                            sa.getKeywordsPopularityCount(
                                    country, sport, "favourites", starttime, endtime));
            });
        //});
            
        System.out.println("SportData - init - done");
    }
    
    public final void initPlayOff() {
        initPlayOff(0, 0);
    }
    
    public final void initPlayOff(long starttime, long endtime) {
        clear();
        final ServerAccess sa = new ServerAccess();
        final List<String> sports = Arrays.asList("FC Eindhoven", "FC Volendam", "VVV Venlo", 
            "NAC Breda", "FC Emmen", "Roda JC", "Go Ahead Eagles", "De Graafschap");
        final String country = "NL";
        
        sports.stream().forEach(sport -> {
            addRetweetCount(country,
                    sa.getRelatedTweetsCountryCountSingle(
                            country, sport, "retweets", starttime, endtime));
            addFavCount(country,
                    sa.getRelatedTweetsCountryCountSingle(
                            country, sport, "favourites", starttime, endtime));
        });
    }
    
    // Private Methods
    
    private void clear() {
        retweetCounts.clear();
        favCounts.clear();
        keywordsCountRT.clear();
        keywordsCountFav.clear();
    }
    
    /**
     * Adds list of popularity for some country to some map
     * 
     * @param chartdata map to add data to
     * @param country country code
     * @param list list with popularity
     */
    private void addChartDataCountry(Map<String, List<ChartData>> chartdata,
            String country, List<ChartData> list) {
        list.stream().forEach(elem -> addChartDataSport(chartdata, country, elem));
    }
    
    /**
     * Adds some sports popularity for some country to some map
     * 
     * @param chartdata map to add data to
     * @param country country code
     * @param sport sport with popularity
     */
    private void addChartDataSport(Map<String, List<ChartData>> chartdata, 
            String country, ChartData sport) {
        if (!chartdata.containsKey(country)) {
            chartdata.put(country, new ArrayList<>());
        }
        chartdata.get(country).add(sport);
    }
    
    /**
     * Gets popularity as percentage
     * 
     * @param map map with popularity
     * @return map with popularity as percentage
     */
    private Map<String, Double> getAsPercentage(Map<String, Double> map) {
        final Map<String, Double> perc = new HashMap();
        final double total = map.values().stream().mapToDouble(v -> v).sum();
        
        map.entrySet().stream().forEach(entry -> {
            perc.put(entry.getKey(), entry.getValue() * 100.0 / total);
        });
        
        return perc;
    }
    
    /**
     * Gets popularity as percentage
     * 
     * @param map map with popularity
     * @return map with popularity as percentage
     */
    private Map<Date, Double> getAsPercentageDate(Map<Date, Double> map) {
        final Map<Date, Double> perc = new HashMap();
        final double total = map.values().stream().mapToDouble(v -> v).sum();
        
        map.entrySet().stream().forEach(entry -> {
            perc.put(entry.getKey(), entry.getValue() * 100.0 / total);
        });
        
        return perc;
    }
    
    /**
     * Gets the popularity for a country depending on the search area
     * 
     * @param country country code
     * @param popularity popularity
     * @return popularity depending on search area
     */
    @Deprecated
    private double getPopularityInArea(String country, int popularity) {
        if (!areas.containsKey(country)) {
            return 0;
        }
        if (areas.get(country) <= 0 || popularity <= 0) {
            return 0;
        }
        return popularity / (double) areas.get(country);
    }
    
    /**
     * For some sport, get popularity (as percentage) of that sport in all 
     * countries
     * 
     * @param chartdata map to get popularity from
     * @param sport sport for which the popularity should be returned
     * @return map with countryCode =&gt; popularity of sport (as percentage)
     */
    private Map<String, Double> getPopularityInCountries(
            Map<String, List<ChartData>> chartdata, String sport) {
        final Map<String, Double> pop = new HashMap();
        
        chartdata.entrySet().stream().forEach(entry -> {
            if (!pop.containsKey(entry.getKey())) {
                pop.put(entry.getKey(), 0.0);
            }
            pop.put(entry.getKey(), pop.get(entry.getKey()) + 
                    getPopularityOfSport(entry.getValue(), entry.getKey(), sport));
        });
        
        return getAsPercentage(pop);
    }
    
    /**
     * Returns the popularity of some sport
     * 
     * @param list list from which popularity is used
     * @param sport sport for which popularity is requested
     * @return popularity of sport
     */
    private double getPopularityOfSport(List<ChartData> list, String country, String sport) {
        int pop = 0;
        
        for (ChartData cd : list) {
            if (cd.getName().equals(sport)) {
                pop = cd.getValue();
                break;
            }
        }
        
        return pop;
    }
    
    /**
     * Gets combined popularity of sport for all countries
     * 
     * @param chartdata map to get popularity from
     * @return popularity of all sports as percentage, map sport =&gt; popularity
     */
    private Map<String, Double> getSportsByPopularity(
            Map<String, List<ChartData>> chartdata, boolean asPercentage) {
        final Map<String, Double> pop = new HashMap();
        
        chartdata.entrySet().stream().forEach(entry -> {
            entry.getValue().stream().forEach(sport -> {
                if (!pop.containsKey(sport.getName())) {
                    pop.put(sport.getName(), 0.0);
                }
                pop.put(sport.getName(), pop.get(sport.getName()) + sport.getValue());
            });
        });
        
        if (asPercentage) {
            return getAsPercentage(pop);
        }
        return pop;
    }
    
    // Public Methods
    
    /**
     * Adds an area for a given country
     * 
     * @param country country code
     * @param area area
     */
    @Deprecated
    public final void addArea(String country, int area) {
        areas.put(country, area);
    }
    
    /**
     * Adds favourite counts for a given country
     * 
     * @param country country code
     * @param list list of sports with favourite counts
     */
    public final void addFavCount(String country, List<ChartData> list) {
        addChartDataCountry(favCounts, country, list);
    }
    
    /**
     * Adds favourite count for a given country and sport
     * 
     * @param country country code
     * @param sport sport with favourite count
     */
    public final void addFavCount(String country, ChartData sport) {
        addChartDataSport(favCounts, country, sport);
    }
    
    /**
     * Adds retweet counts for a given country
     * 
     * @param country country code
     * @param list list of sports with retweet counts
     */
    public final void addRetweetCount(String country, List<ChartData> list) {
        addChartDataCountry(retweetCounts, country, list);
    }
    
    /**
     * Adds retweet count for a given country and sport
     * 
     * @param country country code
     * @param sport sport with retweet count
     */
    public final void addRetweetCount(String country, ChartData sport) {
        addChartDataSport(retweetCounts, country, sport);
    }
    
    public final void addKeywordsCountRT(String country, String sport, 
            List<ChartData> chartdata) {
        if (!keywordsCountRT.containsKey(country)) {
            keywordsCountRT.put(country, new HashMap());
        }
        keywordsCountRT.get(country).put(sport, chartdata);
    }
    
    public final void addKeywordsCountFav(String country, String sport, 
            List<ChartData> chartdata) {
        if (!keywordsCountFav.containsKey(country)) {
            keywordsCountFav.put(country, new HashMap());
        }
        keywordsCountFav.get(country).put(sport, chartdata);
    }
    
    /**
     * Gets country code
     * 
     * @return country code
     */
    public final String getCountryCode() {
        return countryCode;
    }
    
    /** 
     * For some sport, get popularity (as percentage) of that sport in all 
     * countries using favourite counts
     * 
     * @param sport sport
     * @return map with country =&gt; popularity
     */
    public final Map<String, Double> getCountryPopFavourites(String sport) {
        return getPopularityInCountries(favCounts, sport);
    }
    
    /** 
     * For some sport, get popularity (as percentage) of that sport in all 
     * countries using retweet counts
     * 
     * @param sport sport
     * @return map with country =&gt; popularity
     */
    public final Map<String, Double> getCountryPopRetweets(String sport) {
        return getPopularityInCountries(retweetCounts, sport);
    }
    
    /**
     * Gets map of all favourite counts
     * 
     * @return map of all favourite counts
     */
    public final Map<String, List<ChartData>> getFavouriteCountPopularity() {
        return favCounts;
    }
    
    /**
     * Gets map of all retweet counts
     * 
     * @return map of all retweet counts
     */
    public final Map<String, List<ChartData>> getRetweetCountPopularity() {
        return retweetCounts;
    }
    
    public final Map<String, Double> getKeywordCountRT(String country, String sport) {
        final Map<String, Double> pop = new HashMap();
        
        keywordsCountRT.get(country).get(sport).stream()
                .forEach(data -> pop.put(data.getName(), (double) data.getValue()));
        
        return getAsPercentage(pop);
    }
    
    public final Map<String, Double> getKeywordCountFav(String country, String sport) {
        final Map<String, Double> pop = new HashMap();
        
        keywordsCountFav.get(country).get(sport).stream()
                .forEach(data -> pop.put(data.getName(), (double) data.getValue()));
        
        return getAsPercentage(pop);
    }
    
    /**
     * Gets combined popularity (as percentage) of sport for all countries 
     * using favourite counts
     * 
     * @return map with country =&gt; popularity
     */
    public final Map<String, Double> getSportPopFavourites() {
        return getSportsByPopularity(favCounts, true);
    }
    
    /**
     * Gets combined popularity (as percentage) of sport for all countries 
     * using retweet counts
     * 
     * @return map with country =&gt; popularity
     */
    public final Map<String, Double> getSportPopRetweets() {
        return getSportsByPopularity(retweetCounts, true);
    }
    
    public final Map<String, Double> getSportPop(boolean asPercentage) {
        final Map<String, List<ChartData>> counts = new HashMap();
        counts.putAll(retweetCounts);
        
        favCounts.entrySet().forEach(country -> {
            if (!counts.containsKey(country.getKey())) {
                counts.put(country.getKey(), new ArrayList<>());
            }
            
            final Set<String> existing = new HashSet();
            counts.get(country.getKey()).stream()
                    .forEach(sport -> existing.add(sport.getName()));
            
            country.getValue().stream().forEach(sport -> {
                if (existing.contains(sport.getName())) {
                    counts.get(country.getKey()).stream()
                            .filter(data -> data.getName().equals(sport.getName()))
                            .forEach(exist -> {
                                if (exist.getName().equals(sport.getName())) {
                                    exist.addValue(sport.getValue());
                                }
                            });
                } else {
                    counts.get(country.getKey()).add(sport);
                }
            });
        });
        
        return getSportsByPopularity(counts, asPercentage);
    }
    
    public final Map<String, Double> getSportPopMatch() {
        final Map<String, List<ChartData>> counts = new HashMap();
        counts.putAll(retweetCounts);
        
        favCounts.entrySet().forEach(country -> {
            if (!counts.containsKey(country.getKey())) {
                counts.put(country.getKey(), new ArrayList<>());
            }
            
            final Set<String> existing = new HashSet();
            counts.get(country.getKey()).stream()
                    .forEach(sport -> existing.add(sport.getName()));
            
            country.getValue().stream().forEach(sport -> {
                if (existing.contains(sport.getName())) {
                    counts.get(country.getKey()).stream()
                            .filter(data -> data.getName().equals(sport.getName()))
                            .forEach(exist -> {
                                if (exist.getName().equals(sport.getName())) {
                                    exist.addValue(sport.getValue());
                                }
                            });
                } else {
                    counts.get(country.getKey()).add(sport);
                }
            });
        });
        
        final Map<String, Double> combined = getSportsByPopularity(counts, true);
        List<String> matches = Arrays.asList(
                "De Graafschap - Go Ahead Eagles",
                "FC Volendam - FC Eindhoven", 
                "VVV Venlo - NAC Breda",
                "FC Emmen - Roda JC");
        
        final Map<String, Double> matchPop = new HashMap();
        matches.stream().forEach(match -> {
            final String[] teams = match.split(" - ");
            final double pop = combined.get(teams[0]) + combined.get(teams[1]);
            matchPop.put(match, pop);
        });
        
        return matchPop;
    }
    
    /**
     * Sets country code
     * 
     * @param countryCode country code
     */
    public final void setCountryCode(String countryCode) {
        SportData.countryCode = countryCode;
    }
    

    
    /**
     * 
     * @param startdate = tweets should be within startdate and enddate
     * @param enddate = read startdate
     * @param sport = which sport we are actually looking for at the moment
     * @param timeinterval = How many days the interval is.
     *                  Day =1 , week = 7, month = 30
     *                  note: a month is not always 30 days..
     * @return Map<Date, Double>. Date stands for the first day
     *                  Double stands for the amount of tweets.
     * @example : <01-01-15, 53>
     *            <01-02-15, 50>
     *            <01-03-15, 25>
     */
    public final Map<Date, Double> getSportsForDate(Date startdate,
            Date enddate, String sport, int timeinterval){
        final Map<Date, Double> count = new HashMap();
        final ServerAccess sa = new ServerAccess();
        final long dayInMilliseconds = 86400000L;
        final long starttime = startdate.getTime();
        final long endtime = enddate.getTime();
        
        long timeS = starttime;
        long timeE = starttime;
        long timeM = 0;
        
        if (timeinterval == 30) {
            timeM = getMonthTimeIncr(starttime);
            timeE += timeM;
        } else {
            timeE += dayInMilliseconds * timeinterval;
        }
        
        if (timeE > endtime) {
            timeE = endtime;
        }
        
        ChartData cd0;
        ChartData cd1;
        while (timeS < endtime) {
            cd0 = new ChartData(sport, sa.getRelatedTweetsCountryCount(
                    "NL", sport, "retweets", timeS, timeE));
            cd1 = new ChartData(sport, sa.getRelatedTweetsCountryCount(
                    "NL", sport, "favourites", timeS, timeE));
            cd0.addValue(cd1.getValue());
            count.put(new Date(timeS), (double) cd0.getValue());
            
            if (timeinterval == 30) {
                timeM = getMonthTimeIncr(starttime);
                timeS += timeE;
                timeE += timeM;
            } else {
                timeS += dayInMilliseconds * timeinterval;
                timeE += dayInMilliseconds * timeinterval;
            }
            
            if (timeE > endtime) {
                timeE = endtime;
            }
        }
        
        return count;
    }
    
    private long getMonthTimeIncr(long starttime) {
        Calendar calS = Calendar.getInstance();
        calS.setTimeInMillis(starttime);
        
        Calendar calE = Calendar.getInstance();
        calE.clear();
        calE.set(calS.get(Calendar.YEAR), calS.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
        
        return calE.getTimeInMillis() - starttime;
    }
    
}