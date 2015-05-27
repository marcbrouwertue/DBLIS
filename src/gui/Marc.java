package gui;

import dblis.SportData2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Brouwer M.R.
 */
public class Marc {
    
    public static Scene drawLineChart() {
        ObservableList<XYChart.Series<Date, Number>> series = FXCollections.observableArrayList();

        final NumberAxis numberAxis = new NumberAxis();
        final DateAxis dateAxis = new DateAxis();
        final LineChart<Date, Number> lineChart = new LineChart<>(dateAxis, numberAxis, series);
        
        series.addAll(FXPanel.getSeries());
        
        series.stream().forEach(serie -> {
            serie.getData().stream().forEach(data -> {
                data.getNode().setOnMousePressed((MouseEvent mouseEvent) -> {
                    System.out.println(serie.getName() + ", "
                            + data.getXValue() + ", " + data.getYValue());
                });
            });
        });

        Scene scene = new Scene(lineChart, 800, 600);
        
        return scene;
    }
    
    private static void makePieChart(String sport, Date date) {
        Group root = new Group();
        
        final List<PieChart.Data> list = new ArrayList<>();
        
        final Date startdate = SportData2.getInstance().getStartDate();
        final Date enddate = SportData2.getInstance().getEndDate();
        final List<String> sports = SportData2.getInstance().getSelected();
        
        final Map<String, Double> sportPop = SportData2.getInstance()
                .getPopularitySportsAsPercentage(sports, startdate.getTime(), 
                        enddate.getTime());
        
        sportPop.entrySet().stream().forEach(entry -> {
            list.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        });
        
        PieChart pie = new PieChart(
                FXCollections.observableArrayList(list));
        pie.setTitle("Popularity");

        root.getChildren().add(pie);
    }
    
}