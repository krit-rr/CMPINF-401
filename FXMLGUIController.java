package fxmlprojectpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLGUIController implements Initializable {

    @FXML
    private ImageView imageCar;
    @FXML
    private TextArea textDescription;
    @FXML
    private Label textPrice;
    @FXML
    private Button buttonExit;
    @FXML
    private ChoiceBox<String> choiceModel;
    @FXML
    private ChoiceBox<String> choiceColor;

    private NumberFormat nf;

    private List<Car> cars;

    private List<String> models;
    @FXML
    private ToggleGroup toggleInsurance;
    @FXML
    private CheckBox powerLocks;
    @FXML
    private CheckBox powerWindows;
    @FXML
    private CheckBox airConditioner;
    @FXML
    private RadioButton insuranceThree;
    @FXML
    private RadioButton insuranceOne;
    @FXML
    private RadioButton insuranceNone;

    private double threeYearInsurance = 3000;
    private double oneYearInsurance = 1000; 
    private double powerLocksPrice = 100;
    private double powerWindowsPrice = 200;
    private double airConditionerPrice = 300;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cars = new ArrayList<Car>();
        String[] optsMirai = {"Power Windows", "Power Locks", "Air-Conditioning"};
        String[] colorsMirai = {"Black", "Blue", "Metal", "Red"};
        cars.add(new Car("Mirai", optsMirai, "Mirai description",
                20000.0, colorsMirai));

        String[] optsPrius = {"Power Windows", "Power Locks"};
        String[] colorsPrius = {"Black", "Blue", "Pearl", "Red"};
        cars.add(new Car("Prius", optsPrius, "Prius description",
                30000.0, colorsPrius));

        String[] optsSienna = {"Power Windows", "Air-Conditioning"};
        String[] colorsSienna = {"Black", "Blue", "Cyprus", "Red"};
        cars.add(new Car("Sienna", optsSienna, "Sienna description",
                40000.0, colorsSienna));

        models = new ArrayList<>();
        for (Car c : cars) {
            models.add(c.carType);
        }

        choiceModel.setItems(FXCollections.observableList(models));
        choiceModel.getSelectionModel().selectFirst();

        ChangeListener listener = new MyChangeListener();
        choiceColor.valueProperty().addListener(listener);

        ChangeListener listenerTwo = new MyChangeListenerTwo();
        choiceModel.valueProperty().addListener(listenerTwo);

        updateModelSelection(null);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void updateSelection(ActionEvent event) {
        Car currentCar = cars.get(models.indexOf(choiceModel.getValue()));
        textDescription.setText(currentCar.description);

        imageCar.setImage(Car.getImage(currentCar.carType, choiceColor.getValue()));

        double totalPrice = 0;
        if (insuranceThree.isSelected()) {
            totalPrice = currentCar.basicPrice + threeYearInsurance;
        } else if (insuranceOne.isSelected()) {
            totalPrice = currentCar.basicPrice + oneYearInsurance;
        } else {
            totalPrice = currentCar.basicPrice;
        }

        if (powerLocks.isSelected()) {
            totalPrice = totalPrice + powerLocksPrice;
        }
        if (powerWindows.isSelected()) {
            totalPrice = totalPrice + powerWindowsPrice;
        }
        if (airConditioner.isSelected()) {
            totalPrice = totalPrice + airConditionerPrice;
        }

        textPrice.setText(String.valueOf(totalPrice));
    }

    private void updateModelSelection(ActionEvent event) {
        Car currentCar = cars.get(models.indexOf(choiceModel.getValue()));
        powerLocks.setSelected(false);
        powerWindows.setSelected(false);
        airConditioner.setSelected(false);
        
        insuranceThree.setSelected(false);
        insuranceOne.setSelected(false);
        insuranceNone.setSelected(false);

        choiceColor.setItems(FXCollections.observableList(Arrays.asList(currentCar.availableColors)));
        choiceColor.getSelectionModel().selectFirst();

        powerLocks.setDisable(!(Arrays.asList(currentCar.standardFeatures).contains("Power Locks")));
        powerWindows.setDisable(!(Arrays.asList(currentCar.standardFeatures).contains("Power Windows")));
        airConditioner.setDisable(!(Arrays.asList(currentCar.standardFeatures).contains("Air-Conditioning")));

    }

    private class MyChangeListener implements ChangeListener {

        @Override
        public void changed(ObservableValue ov, Object t, Object t1) {
            updateSelection(null);
        }
    }

    private class MyChangeListenerTwo implements ChangeListener {

        @Override
        public void changed(ObservableValue ov, Object t, Object t1) {
            updateModelSelection(null);
        }
    }
}
