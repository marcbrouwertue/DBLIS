package gui;

import dblis.SportData2;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Brouwer M.R.
 */
public class Marc {
    
    public static Scene drawBarChart(FXPanel panel) {
        Runnable runner = () -> {
            final ObservableList<XYChart.Series<String, Number>> series = FXCollections.observableArrayList();

            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Event");
            yAxis.setLabel("Popularity");

            final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis, series);

            final List<String> events = SportData2.getInstance().getSelected();
            events.stream().forEach(e -> series.addAll(getSerie(e, true)));

            Scene scene = new Scene(barChart, 800, 600);
            panel.setScene(scene);
        };
        
        Thread t = new Thread(runner);
        t.start();
        return null;
    }
    
    public static Scene drawBarChartHashtags(FXPanel panel) {
        Runnable runner = () -> {
            final ObservableList<XYChart.Series<String, Number>> series = FXCollections.observableArrayList();

            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Hashtags");
            yAxis.setLabel("Popularity");

            final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis, series);

            final List<String> selected = SportData2.getInstance().getSelected();
            final long starttime = SportData2.getInstance().getStartDate().getTime();
            final long endtime = SportData2.getInstance().getEndDate().getTime();
            
            final Map<String, Double> pop = SportData2.getInstance().getMostCommonHashtags(selected, starttime, endtime);
            final XYChart.Series<String, Number> serie = new XYChart.Series();
            
            selected.stream().forEach(hashtag -> {
                serie.getData().add(new XYChart.Data("", pop.get(hashtag)));
                serie.setName(hashtag);
                series.add(serie);
            });
            
            Scene scene = new Scene(barChart, 800, 600);
            panel.setScene(scene);
        };
        
        Thread t = new Thread(runner);
        t.start();
        return null;
    }
    
    /** COPIED NOT CHANGED */
    private static XYChart.Series<String, Number> getSerie(String event, boolean pop_user) {
        //Getting the selected information from the GUI
        final Date startdate = SportData2.getInstance().getStartDate();
        final Date enddate = SportData2.getInstance().getEndDate();
        
        //Creating variables required
        final XYChart.Series<String, Number> serie = new XYChart.Series();
        
        final String sep = ";&;";
        int pop = 0;
        
        if (pop_user) {
            if (event.contains(sep)) {
                String[] teams = event.split(sep);
                pop += SportData2.getInstance().getPopularity(
                            teams[0], startdate.getTime(), enddate.getTime());
                pop += SportData2.getInstance().getPopularity(
                            teams[1], startdate.getTime(), enddate.getTime());
                serie.setName(teams[0] + " - " + teams[1]);
            } else { 
                pop = SportData2.getInstance().getPopularity(
                            event, startdate.getTime(), enddate.getTime());
                serie.setName(event);
            }
        } else {
            if (event.contains(sep)) {
                String[] teams = event.split(sep);
                pop += SportData2.getInstance().getNumberUsers(
                            teams[0], startdate.getTime(), enddate.getTime());
                pop += SportData2.getInstance().getNumberUsers(
                            teams[1], startdate.getTime(), enddate.getTime());
                serie.setName(teams[0] + " - " + teams[1]);
            } else { 
                pop = SportData2.getInstance().getNumberUsers(
                            event, startdate.getTime(), enddate.getTime());
                serie.setName(event);
            }
        }
        
        serie.getData().add(new XYChart.Data("", pop));
        
        return serie;
    }
    
}