package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Client;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class TAJNumberValidator implements Validator<Client> {

    @Override
    public void validate(Client client) throws IncorrectEnteredDataException {
        if (client.getTAJNumber() == null || !client.getTAJNumber().matches("^\\d{3}-\\d{3}-\\d{3}$")) { // valid TAJ e.g.: 123-456-789
            throw new IncorrectEnteredDataException("tajError", "It is Wrong! Correct form is 123-456-789");
        }
    }
}
