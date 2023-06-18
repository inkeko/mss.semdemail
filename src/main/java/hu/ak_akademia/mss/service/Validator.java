package hu.ak_akademia.mss.service;

import hu.ak_akademia.mss.model.user.Doctor;
import hu.ak_akademia.mss.model.user.MssUser;
import hu.ak_akademia.mss.service.exceptions.IncorrectEnteredDataException;

public interface Validator<T extends MssUser> {

    void validate(T t) throws IncorrectEnteredDataException;

}
