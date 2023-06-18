package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Client;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class PlaceOfBirthValidator implements Validator<Client> {
    @Override
    public void validate(Client client) throws IncorrectEnteredDataException {
        if (client.getPlaceOfBirth() == null || !client.getPlaceOfBirth().matches("^(\\p{L}" + //must start with a letter
                "[\\p{L}\\p{Mn}\\s'-.]{0,98}" +
                "[\\p{L}.])$")) { //must end with a letter or a dot(for cities like Washington D.C.)
            throw new IncorrectEnteredDataException("birthplaceError", "Invalid! Correct form is e.g.: Budapest");
        }
    }

}
