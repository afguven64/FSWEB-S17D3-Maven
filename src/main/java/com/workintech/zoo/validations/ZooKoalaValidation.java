package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import java.util.Map;

public class ZooKoalaValidation {
    public static void isIdValid(Integer id) {
        if(id == null || id < 0) {
            throw new ZooException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }

    }

    public static void checkKoalaExistence(Map<Integer, Koala> koalas,
                                              Integer id, boolean existence) {
        if(existence){
            if(!koalas.containsKey(id)) {
                throw new ZooException("Result is not exist: " + id, HttpStatus.NOT_FOUND);
            }
        }
        else {
            if(koalas.containsKey(id)) {
                throw new ZooException("Result is already exist: " + id, HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static void checkKoalaWeight(Double weight) {
        if (weight == null || weight < 0) {
            throw new ZooException("Weight is not valid: " + weight, HttpStatus.BAD_REQUEST);
        }
    }
}
