package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.FinancialColleague;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeColleagueValidator implements Validator<FinancialColleague> {
    private final boolean uniqueEmail;
    private final List<Validator<FinancialColleague>> validators = new ArrayList<>();
    private final Map<String, String> validatorErrorList = new HashMap<>();

    public CompositeColleagueValidator(boolean uniqueEmail) {
        this.uniqueEmail = uniqueEmail;
    }

    @Override
    public void validate(FinancialColleague colleague) {
        for (var v : validators) {
            try {
                v.validate(colleague);
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

    public void addValidators(List<Validator<FinancialColleague>> validator) {
        validators.addAll(validator);
    }
}

