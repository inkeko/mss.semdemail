package hu.ak_akademia.mss.service.validators;

import hu.ak_akademia.mss.model.user.Doctor;
import hu.ak_akademia.mss.service.Validator;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

class DoctorFirstNameValidator implements Validator<Doctor> {

    @Override
    public void validate(Doctor doctor) throws IncorrectEnteredDataException {
        if (doctor.getFirstName() == null || !doctor.getFirstName().matches("^[A-ZÁÉÍÓÖŐÚÜŰ]([a-záéíóöőúüű]+\\s?([A-ZÁÉÍÓÖŐÚÜŰa-záéíóöőúüű]*))$")) {
            throw new IncorrectEnteredDataException("firstNameError", "Incorrect! Correct form is e.g.: Elek");
        }
        MSSUserValidatorFactory.lengthValidation(doctor.getFirstName());
    }

}
