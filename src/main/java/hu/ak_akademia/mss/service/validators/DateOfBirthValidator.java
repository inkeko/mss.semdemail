package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Client;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

import java.time.LocalDate;
import java.time.Period;

class DateOfBirthValidator implements Validator<Client> {

    @Override
    public void validate(Client mssUsers) throws IncorrectEnteredDataException {
        if (mssUsers.getDateOfBirth() == null) {
            throw new IncorrectEnteredDataException("dateOfBirthError", "The given date of birth is invalid!");
        }
        if (Period.between(mssUsers.getDateOfBirth(), LocalDate.now()).getYears() < 18) {
            throw new IncorrectEnteredDataException("dateOfBirthError", "Only adult clients can use the services of the clinic!");
        }
    }

}
