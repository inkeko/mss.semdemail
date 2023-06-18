package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Doctor;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;


class DoctorEmailValidator implements Validator<Doctor> {

    private boolean isUnique;

    @Override
    public void validate(Doctor doctor) throws IncorrectEnteredDataException {
        if (doctor.getEmail() == null || !doctor.getEmail().matches(".+@\\w+\\.[a-z]+")) {
            throw new IncorrectEnteredDataException("emailError", "Incorrect! Correct form is e.g.: teszt@mail.hu");
        }
    }
}