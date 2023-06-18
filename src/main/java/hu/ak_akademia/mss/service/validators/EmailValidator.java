package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Client;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;


class EmailValidator implements Validator<Client> {

    @Override
    public void validate(Client client) throws IncorrectEnteredDataException {
        if (client.getEmail() == null || !client.getEmail().matches(".+@\\w+\\.[a-z]+")) {
            throw new IncorrectEnteredDataException("emailError", "Incorrect! Correct form is e.g.: teszt@mail.hu");
        }
    }

}
