package systemOfLinearEquations;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Objects;

public class Controller {

    @FXML
    private TextField textField1 = new TextField();

    @FXML
    private TextField textField2 = new TextField();

    @FXML
    private TextField textField3 = new TextField();

    @FXML
    private TextField textField4 = new TextField();

    @FXML
    private TextField textField5 = new TextField();

    @FXML
    private TextField textField6 = new TextField();

   @FXML
   private Button buttonCalculate;

    @FXML
    private Button buttonReset;

    @FXML
    private Button buttonDrawChart;

    @FXML
    private Label label;

    @FXML
    private CategoryAxis xGr;

    @FXML
    private NumberAxis yGr;

    @FXML
    private LineChart<String,Number> lineChart;

    private double a1, b1, c1, a2, b2, c2;

    @FXML
    public void calculationEquations() {

        String textFromTextField1 = textField1.getText();
        String textFromTextField2 = textField2.getText();
        String textFromTextField3 = textField3.getText();
        String textFromTextField4 = textField4.getText();
        String textFromTextField5 = textField5.getText();
        String textFromTextField6 = textField6.getText();


        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setHeaderText("Data entry error");
        alert.setContentText("The field can not be empty");

        if ((Objects.equals(textFromTextField1, ""))
            || (Objects.equals(textFromTextField2, ""))
            || (Objects.equals(textFromTextField3, ""))
            || (Objects.equals(textFromTextField4, ""))
            || (Objects.equals(textFromTextField5, ""))
            || (Objects.equals(textFromTextField6, ""))) {
            alert.showAndWait();
        }

        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Warning");
        alert1.setHeaderText("Data entry error");
        alert1.setContentText("The value must be a number!");

        try {
            a1 = Double.parseDouble(textFromTextField1);
        }
        catch (NumberFormatException ex) {
            alert1.showAndWait();
            textField1.clear();
        }

        try {
            b1 = Double.parseDouble(textFromTextField2);
        } catch (NumberFormatException ex) {
            alert1.showAndWait();
            textField2.clear();
        }

        try {
            c1 = Double.parseDouble(textFromTextField3);
        }
        catch (NumberFormatException ex) {
            alert1.showAndWait();
            textField3.clear();
        }

        try {
            a2 = Double.parseDouble(textFromTextField4);
        }
        catch (NumberFormatException ex) {
            alert1.showAndWait();
            textField4.clear();
        }

        try {
            b2 = Double.parseDouble(textFromTextField5);
        }
        catch (NumberFormatException ex) {

            alert1.showAndWait();
            textField5.clear();
        }

        try {
            c2 = Double.parseDouble(textFromTextField6);
        }
        catch (NumberFormatException ex) {
            alert1.showAndWait();
            textField6.clear();
        }

        double w = a1 * b2 - a2 * b1;
        double wX = c1 * b2 - c2 * b1;
        double wY = a1 * c2 - a2 * c1;

        if (w == 0.0D) {
            if (wX == 0.0D) {
                label.setText("RESULT:  Infinitely many solutions.");
            } else {
                label.setText("RESULT:  A system of contradictory equations.");
            }
        } else {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMinimumFractionDigits(2);
            decimalFormat.setMaximumFractionDigits(2);

            double x = wX / w;
            double y = wY / w;

            String xString = decimalFormat.format(x);
            String yString = decimalFormat.format(y);

            label.setText("RESULT:  x = " + xString + "  ,  y = " + yString);
        }
    }

    @FXML
    public void resetData() {

        textField1.clear();
        textField2.clear();
        textField3.clear();
        textField4.clear();
        textField5.clear();
        textField6.clear();
        label.setText("RESULT: ");
        lineChart.getData().clear();
    }

    @FXML
    public void chartsDraw() {

        double xGrpom1 = 0;
        double xGrpom2 = 5;
        double xGrpom3 = 10;
        double xGrpom4 = 15;
        double yGrpom1, yGrpom12;
        double yGrpom2, yGrpom22;
        double yGrpom3, yGrpom32;
        double yGrpom4, yGrpom42;

        yGrpom1 = (c1 - a1 * xGrpom1) / b1;
        yGrpom2 = (c1 - a1 * xGrpom2) / b1;
        yGrpom3 = (c1 - a1 * xGrpom3) / b1;
        yGrpom4 = (c1 - a1 * xGrpom4) / b1;

        yGrpom12 = (c2 - a2 * xGrpom1) / b2;
        yGrpom22 = (c2 - a2 * xGrpom2) / b2;
        yGrpom32 = (c2 - a2 * xGrpom3) / b2;
        yGrpom42 = (c2 - a2 * xGrpom4) / b2;

        lineChart.getData().clear();

        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("0",yGrpom1));
        series.getData().add(new XYChart.Data<>("5",yGrpom2));
        series.getData().add(new XYChart.Data<>("10",yGrpom3));
        series.getData().add(new XYChart.Data<>("15",yGrpom4));
        lineChart.getData().add(series);
        series.setName("Equation: " + a1 + "*x + " + b1 + "*y = " + c1);

        XYChart.Series<String,Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("0",yGrpom12));
        series1.getData().add(new XYChart.Data<>("5",yGrpom22));
        series1.getData().add(new XYChart.Data<>("10",yGrpom32));
        series1.getData().add(new XYChart.Data<>("15",yGrpom42));
        lineChart.getData().add(series1);
        series1.setName("Equation: " + a2 + "*x + " + b2 + "*y = " + c2);


    }
}
