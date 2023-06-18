package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Client;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class FirstNameValidator implements Validator<Client> {

    @Override
    public void validate(Client client) throws IncorrectEnteredDataException {
        if (client.getFirstName() == null || !client.getFirstName().matches("^[A-ZÁÉÍÓÖŐÚÜŰ]([a-záéíóöőúüű]+\\s?([A-ZÁÉÍÓÖŐÚÜŰa-záéíóöőúüű]*))$")) {
            throw new IncorrectEnteredDataException("firstNameError", "Incorrect! Correct form is e.g.: Elek");
        }
        MSSUserValidatorFactory.lengthValidation(client.getFirstName());
    }

}
