package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.FinancialColleague;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;


class ColleagueEmailValidator implements Validator<FinancialColleague> {

    @Override
    public void validate(FinancialColleague colleague) throws IncorrectEnteredDataException {
        if (colleague.getEmail() == null || !colleague.getEmail().matches(".+@\\w+\\.[a-z]+")) {
            throw new IncorrectEnteredDataException("emailError", "Incorrect! Correct form is e.g.: teszt@mail.hu");
        }
    }
}