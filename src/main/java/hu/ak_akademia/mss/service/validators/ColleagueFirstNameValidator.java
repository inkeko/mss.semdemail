package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.FinancialColleague;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class ColleagueFirstNameValidator implements Validator<FinancialColleague> {

    @Override
    public void validate(FinancialColleague colleague) throws IncorrectEnteredDataException {
        if (colleague.getFirstName() == null || !colleague.getFirstName().matches("^[A-ZÁÉÍÓÖŐÚÜŰ]([a-záéíóöőúüű]+\\s?([A-ZÁÉÍÓÖŐÚÜŰa-záéíóöőúüű]*))$")) {
            throw new IncorrectEnteredDataException("firstNameError", "Incorrect! Correct form is e.g.: Elek");
        }
        MSSUserValidatorFactory.lengthValidation(colleague.getFirstName());
    }

}
