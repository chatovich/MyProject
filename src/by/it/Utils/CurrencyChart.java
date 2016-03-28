package by.it.Utils;

import java.util.*;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.chart.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CurrencyChart extends Application {
    final static String[] currencies = {"RUR", "USD", "EUR"};
    final static int DECADES = 3;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setHgap(5);
        CategoryAxis xAxis = new CategoryAxis();
        ArrayList<String> decNames = new ArrayList<>();
        Random rand = new Random();

        ArrayList currList = new ArrayList();
        for(int c=0; c<currencies.length; c++) {
            String curr = currencies[c];
            grid.add(new Label(curr), c+1, 0);
            ArrayList<BarChart.Data<String,Float>> list = new ArrayList<>();
            for(int d=1; d<=DECADES; d++) {
                Float value = new Float(rand.nextInt(90));
                String decName = "Декада "+d;
                BarChart.Data<String,Float> data = new BarChart.Data<>(decName, value);
                Text barText = new Text(data.getYValue().toString());
                data.nodeProperty().addListener((ov,o,n) -> {
                    Node node = (Node)n;
                    node.parentProperty().addListener((ovp,op,np) -> {
                        ((Group)np).getChildren().add(barText);
                    });
                    node.boundsInParentProperty().addListener((ObservableValue<? extends Bounds> ovb, Bounds ob, Bounds nb) -> {
                        barText.setLayoutX(Math.round(nb.getMinX() + (nb.getWidth()-barText.prefWidth(-1))/2));
                        barText.setLayoutY(Math.round(nb.getMinY() - barText.prefHeight(-1)/2));
                    });
                });

                data.YValueProperty().addListener((ObservableValue<? extends Float> ov, Float o, Float n) -> {
                    barText.setText(n.toString());
                });
                list.add(data);

                TextField textField = new TextField(value.toString());
                grid.add(textField, c+1, d);
                textField.setOnAction(e -> {
                    try {
                        data.setYValue(Float.valueOf(textField.getText()));
                    } catch(NumberFormatException ex) {
                        textField.setText(barText.getText());
                    }
                    e.consume();
                });
                if(decNames != null) {
                    decNames.add(decName);
                    grid.add(new Label(decName), 0, d);
                }
            }
            currList.add(new BarChart.Series<String, Float>(curr, FXCollections.<BarChart.Data<String,Float>>observableArrayList(list)));
            if(decNames != null) {
                xAxis.setCategories(FXCollections.<String>observableArrayList(decNames));
                decNames = null;
            }
        }
        BarChart chart = new BarChart(xAxis, new NumberAxis("Курс", 0d, 100d, 20d), FXCollections.observableArrayList(currList), 25d);
        root.setCenter(chart);
        root.setBottom(grid);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}