import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private Button leftbin;
    @FXML private Button leftdec;
    @FXML private Button lefthex;

    @FXML
    public void initialize() {
        disableLeftBin = new SimpleBooleanProperty();
        disableLeftDec = new SimpleBooleanProperty();
        disableLeftHex = new SimpleBooleanProperty();

        leftbin.disableProperty().bind(disableLeftBin);
        leftdec.disableProperty().bind(disableLeftDec);
        lefthex.disableProperty().bind(disableLeftHex);
    }

    private DBHCalculator calc = new DBHCalculator();

    private SimpleBooleanProperty disableLeftBin, disableLeftDec, disableLeftHex;
    private SimpleBooleanProperty curDisabled;

    @FXML
    private TextField textfield;

    @FXML
    private CheckBox padding;

    @FXML protected void handleClear() {
        textfield.setText("");
    }

    @FXML protected void handleLeftBinary() {
        disable(disableLeftBin);
        calc.setInType(DBHCalculator.Type.BIN);
    }

    @FXML protected void handleLeftDecimal() {
        disable(disableLeftDec);
        calc.setInType(DBHCalculator.Type.DEC);
    }

    @FXML protected void handleLeftHex() {
        disable(disableLeftHex);
        calc.setInType(DBHCalculator.Type.HEX);
    }

    @FXML protected void handleRightBinary() {
        calc.setOutType(DBHCalculator.Type.BIN);
        calc.setToPad(padding.isSelected());
        textfield.setText(calc.calculate(textfield.getText()));
    }

    @FXML protected void handleRightDecimal() {
        calc.setOutType(DBHCalculator.Type.DEC);
        calc.setToPad(padding.isSelected());
        textfield.setText(calc.calculate(textfield.getText()));
    }

    @FXML protected void handleRightHex() {
        calc.setOutType(DBHCalculator.Type.HEX);
        calc.setToPad(padding.isSelected());
        textfield.setText(calc.calculate(textfield.getText()));
    }

    private void disable(SimpleBooleanProperty toDisable) {
        if (curDisabled != null) {
            curDisabled.setValue(false);
        }
        curDisabled = toDisable;
        curDisabled.setValue(true);
    }
}
