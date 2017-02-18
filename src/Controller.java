import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Ryan on 2/18/2017.
 */
public class Controller {
    DBHCalculator calc = new DBHCalculator();

    @FXML
    private TextField textfield;

    @FXML protected void handleClear(ActionEvent event) {
        textfield.setText("");
    }

    @FXML protected void handleLeftBinary(ActionEvent event) {
        calc.setInType(DBHCalculator.Type.BIN);
    }

    @FXML protected void handleLeftDecimal(ActionEvent event) {
        calc.setInType(DBHCalculator.Type.DEC);
    }

    @FXML protected void handleLeftHex(ActionEvent event) {
        calc.setInType(DBHCalculator.Type.HEX);
    }

    @FXML protected void handleRightBinary(ActionEvent event) {
        calc.setOutType(DBHCalculator.Type.BIN);
        textfield.setText(calc.calculate(textfield.getText()));
    }

    @FXML protected void handleRightDecimal(ActionEvent event) {
        calc.setOutType(DBHCalculator.Type.DEC);
        textfield.setText(calc.calculate(textfield.getText()));
    }

    @FXML protected void handleRightHex(ActionEvent event) {
        calc.setOutType(DBHCalculator.Type.HEX);
        textfield.setText(calc.calculate(textfield.getText()));
    }
}
