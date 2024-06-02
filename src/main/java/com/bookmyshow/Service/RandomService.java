package com.bookmyshow.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    public Long generateRandomNumber() {
        Random random = new Random();
        Long sixDigitNumber = (long) (100000 + random.nextInt(900000));

        return sixDigitNumber;
    }
}