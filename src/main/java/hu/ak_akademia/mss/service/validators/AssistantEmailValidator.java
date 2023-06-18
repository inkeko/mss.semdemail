package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Assistant;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;


class AssistantEmailValidator implements Validator<Assistant> {

    @Override
    public void validate(Assistant assistant) throws IncorrectEnteredDataException {
        if (assistant.getEmail() == null || !assistant.getEmail().matches(".+@\\w+\\.[a-z]+")) {
            throw new IncorrectEnteredDataException("emailError", "Incorrect! Correct form is e.g.: teszt@mail.hu");
        }
    }
}