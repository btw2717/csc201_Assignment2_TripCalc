import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Scene;
import java.util.*;
import java.text.DecimalFormat;

public class Acceleration extends Application{

		double distance;
		double mpg;
		double price;
		double fin;
		public static final DecimalFormat decFormat = new DecimalFormat("#.##");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {


		Alert intro = new Alert(Alert.AlertType.INFORMATION);
		intro.setContentText("Hello! Ima help you out...");
		intro.showAndWait();

		Alert milesEntered = new Alert(Alert.AlertType.INFORMATION);
		Alert efficiencyEntered = new Alert(Alert.AlertType.INFORMATION);
		Alert priceEntered = new Alert(Alert.AlertType.INFORMATION);
		Alert finalCost = new Alert(Alert.AlertType.INFORMATION);


		TextInputDialog miles = new TextInputDialog();
		miles.setContentText("Please enter the distance you need to drive in miles.");
		Optional<String> resultMiles = miles.showAndWait();

		if (resultMiles.isPresent()) {
			distance = Double.parseDouble(resultMiles.get());
			milesEntered.setContentText("You entered: \n" + distance);
			milesEntered.showAndWait();
		}

		TextInputDialog efficiency = new TextInputDialog();
		efficiency.setContentText("Please enter the fuel efficiency of your vehicle in miles per gallon(mpg).");
		Optional<String> resultEfficiency = efficiency.showAndWait();

		if (resultEfficiency.isPresent()) {
			mpg = Double.parseDouble(resultEfficiency.get());
			efficiencyEntered.setContentText("You entered: " + mpg);
			efficiencyEntered.showAndWait();
		}
		
		TextInputDialog gasPrice = new TextInputDialog();
		gasPrice.setContentText("Please enter the expected price of gasoline.");
		Optional<String> resultGas = gasPrice.showAndWait();

		if (resultGas.isPresent()) {
			price = Double.parseDouble(resultGas.get());
			priceEntered.setContentText("You entered: $" + price);
			priceEntered.showAndWait();
		}

		fin = (distance / mpg) * price;
		finalCost.setContentText("Alright! Your calculated cost of the trip wil be: $" + decFormat.format(fin));
		finalCost.showAndWait();
	}
}
