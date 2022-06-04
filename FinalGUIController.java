package final_krr92;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FinalGUIController implements Initializable {

    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private Label title;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField numberOfTerms;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CheckBox appendPlot;
    @FXML
    private TextArea summary;

    //StringBuilder taylorSeriesValues;
    private String taylorSeriesValues;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(-1.5);
        yAxis.setUpperBound(1.5);
    }

    @FXML
    private void onButtonClicked(ActionEvent event) {
        lineChart.getData().clear();
        summary.clear();
        taylorSeriesValues = "";
        sinFunction();
        

        int terms = Integer.parseInt(numberOfTerms.getText());
        taylorSeries(terms, false);

        if (appendPlot.isSelected()) {
            for (int c = terms - 1; c > 0; c--) {
                taylorSeries(c, true);
            }
        }
    }

    private void sinFunction() {
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("True Sin Wave");

        int initalX = Integer.parseInt(from.getText());
        int finalX = Integer.parseInt(to.getText());

        for (int x = initalX; x < finalX; x++) {
            dataSeries.getData().add(new XYChart.Data(x, Math.sin(Math.toRadians(x))));
        }
        lineChart.getData().add(dataSeries);
    }

    private void taylorSeries(int i, boolean checked) {
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("Taylor Series " + i);

        int initalX = Integer.parseInt(from.getText());
        int finalX = Integer.parseInt(to.getText());

        for (int x = initalX; x <= finalX; x++) {
            double y = computeTaylorSeries(i - 1, Math.toRadians(x));
            dataSeries.getData().add(new XYChart.Data(x, y));

            if (!checked) {
                summary.appendText("Sine(" + x + "): " + taylorSeriesValues.toString() + " = " + y + "\n");
                taylorSeriesValues = "";
            }
        }
        lineChart.getData().add(dataSeries);
        summary.textProperty().concat(i);
    }

    private double computeTaylorSeries(int i, double x) {
        double value = Math.pow(-1, i) / factorial(2 * i + 1) * Math.pow(x, 2 * i + 1);
        if (value > 0) {
            taylorSeriesValues = "+" + value + " " + taylorSeriesValues;
        } else {
            taylorSeriesValues = value + " " + taylorSeriesValues;
        }

        if (i == 0) {
            return value;
        } else {
            return value + computeTaylorSeries(i - 1, x);
        }
    }

    private long factorial(long number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
