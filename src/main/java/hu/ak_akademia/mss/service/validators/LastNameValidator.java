package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Client;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class LastNameValidator implements Validator<Client> {
    private static final String LAST_NAME_REGEX = "^[A-ZÁÉÍÓÚÖÜŐŰa-záéíóúöüőű]" + //Username consists of  characters (a-zA-Z), lowercase, or uppercase
            "([. -_](?![. -_])" + // follow by a dot, hyphen, or underscore, negative lookahead to ensures dot, hyphen, and underscore does not appear consecutively
            "|[A-ZÁÉÍÓÚÖÜŐŰa-záéíóúöüőű])" +  // or  character
            "{1,29}[A-ZÁÉÍÓÚÖÜŐŰa-záéíóúöüőű]$";  // ensures the length of (group 1) between 1 and 1 end with  character

    @Override
    public void validate(Client client) throws IncorrectEnteredDataException {
        if (client.getLastName() == null || !client.getLastName().matches(LAST_NAME_REGEX)) {
            throw new IncorrectEnteredDataException("lastNameError", "Incorrect! Correct form is e.g.: Teszt");
        }
        MSSUserValidatorFactory.lengthValidation(client.getLastName());
    }
}
