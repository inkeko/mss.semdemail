package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Assistant;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class AssistantFirstNameValidator implements Validator<Assistant> {

    @Override
    public void validate(Assistant assistant) throws IncorrectEnteredDataException {
        if (assistant.getFirstName() == null || !assistant.getFirstName().matches("^[A-ZÁÉÍÓÖŐÚÜŰ]([a-záéíóöőúüű]+\\s?([A-ZÁÉÍÓÖŐÚÜŰa-záéíóöőúüű]*))$")) {
            throw new IncorrectEnteredDataException("firstNameError", "Incorrect! Correct form is e.g.: Elek");
        }
        MSSUserValidatorFactory.lengthValidation(assistant.getFirstName());
    }

}
