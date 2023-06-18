package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Doctor;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeDoctorValidator implements Validator<Doctor> {

    private final boolean uniqueEmail;
    private final List<Validator<Doctor>> validators = new ArrayList<>();
    private final Map<String, String> validatorErrorList = new HashMap<>();

    public CompositeDoctorValidator(boolean uniqueEmail) {
        this.uniqueEmail = uniqueEmail;
    }

    @Override
    public void validate(Doctor doctor) {
        for (var v : validators) {
            try {
                v.validate(doctor);
            } catch (IncorrectEnteredDataException e) {
                validatorErrorList.put(e.getMessage(), e.getErrorMessage());
            }
        }
        checkUnique();
    }

    private void checkUnique() {
        if (uniqueEmail) {
            validatorErrorList.put("emailError", "This email already exists! Please choose another one!");
        }
    }

    public Map<String, String> getValidatorErrorList() {
        return validatorErrorList;
    }

    public void addValidators(List<Validator<Doctor>> validator) {
        validators.addAll(validator);
    }
}
