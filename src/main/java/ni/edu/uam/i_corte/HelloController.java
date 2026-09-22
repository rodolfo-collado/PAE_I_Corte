package ni.edu.uam.i_corte;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class HelloController {
    @FXML private VBox stepPatient, stepAppointment, stepSummary;

    @FXML private TextField patientName, patientPhone;

    @FXML private DatePicker appointmentDate;

    @FXML private ComboBox<String> appointmentTime;

    @FXML private TextArea reason;

    @FXML private Label formTitle, stepLabel, errorLabel, summaryLabel, successLabel;

    @FXML private Button backButton, nextButton, confirmButton;


    private static final Pattern NAME = Pattern.compile("^[\\p{L}][\\p{L} .'-]{2,49}$");
    private static final Pattern PHONE = Pattern.compile("^[+()\\d\\s-]{8,20}$");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int step = 1;


    @FXML private void initialize() {
        appointmentTime.setItems(FXCollections.observableArrayList(
                "08:00 a. m.",
                "09:00 a. m.",
                "10:00 a. m.",
                "11:00 a. m.",
                "02:00 p. m.",
                "03:00 p. m.",
                "04:00 p. m.",
                "05:00 p. m."));
        appointmentDate.setValue(LocalDate.now().plusDays(1));
        appointmentTime.getSelectionModel().selectFirst();
        showStep(1);
    }


    @FXML private void goNext() {
        if (step == 1 && !validPatient()) return;
        if (step == 2 && !validAppointment()) return;
        showStep(step + 1);
    }

    @FXML private void goBack() { if (step > 1) showStep(step - 1); }

    @FXML private void confirmAppointment() {
        if (!validPatient() || !validAppointment()) return;
        summaryLabel.setText("Paciente: " + patientName.getText().trim() + "\nTeléfono: " + patientPhone.getText().trim() + "\nFecha: " + appointmentDate.getValue().format(DATE_FORMAT) + "  ·  Hora: " + appointmentTime.getValue() + "\nMotivo: " + reason.getText().trim());
        successLabel.setText("✓ Cita registrada correctamente");
        confirmButton.setDisable(true);
        clearError();
    }

    private boolean validPatient() {
        String name = patientName.getText() == null ? "" : patientName.getText().trim();
        String phone = patientPhone.getText() == null ? "" : patientPhone.getText().trim();
        if (!NAME.matcher(name).matches()) { showError("Escribe un nombre válido (mínimo 3 caracteres).", patientName); return false; }
        long digits = phone.chars().filter(Character::isDigit).count();
        if (!PHONE.matcher(phone).matches() || digits < 8 || digits > 15) { showError("Escribe un teléfono válido con al menos 8 dígitos.", patientPhone); return false; }
        clearError(); return true;
    }

    private boolean validAppointment() {
        if (appointmentDate.getValue() == null || appointmentDate.getValue().isBefore(LocalDate.now())) { showError("Selecciona una fecha igual o posterior a hoy.", appointmentDate); return false; }
        if (appointmentTime.getValue() == null) { showError("Selecciona una hora para la cita.", appointmentTime); return false; }
        if (reason.getText() == null || reason.getText().trim().length() < 5) { showError("Indica brevemente el motivo de la consulta.", reason); return false; }
        clearError(); return true;
    }

    private void showStep(int target) {
        step = target;
        stepPatient.setVisible(target == 1); stepPatient.setManaged(target == 1);
        stepAppointment.setVisible(target == 2); stepAppointment.setManaged(target == 2);
        stepSummary.setVisible(target == 3); stepSummary.setManaged(target == 3);
        stepLabel.setText("PASO " + target + " DE 3");
        formTitle.setText(target == 1 ? "Datos del paciente" : target == 2 ? "Datos de la cita" : "Confirmar cita");
        backButton.setDisable(target == 1);
        nextButton.setVisible(target < 3); nextButton.setManaged(target < 3);
        confirmButton.setVisible(target == 3); confirmButton.setManaged(target == 3);
        if (target == 3) { confirmButton.setDisable(false); successLabel.setText(""); summaryLabel.setText("Revisa la información y confirma para registrar la cita."); }
        clearError();
    }

    private void showError(String message, Node field) { errorLabel.setText(message); field.requestFocus(); }
    private void clearError() { errorLabel.setText(""); }

    @FXML private void startNew() {
        patientName.clear(); patientPhone.clear(); reason.clear();
        appointmentDate.setValue(LocalDate.now().plusDays(1)); appointmentTime.getSelectionModel().selectFirst();
        showStep(1);
    }
}
