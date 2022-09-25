package com.bar.bartender.bartender.service;

import com.bar.bartender.bartender.entity.Cups;
import com.bar.bartender.bartender.repository.BartenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class BartenderService {

    private final BartenderRepository bartenderRepository;

    public BartenderService(BartenderRepository bartenderRepository) {
        this.bartenderRepository = bartenderRepository;
    }

    public Map<String, String> getArrayResponse(Integer q, Integer id) {
        Map<String, String> responseArray = new HashMap<>();
        int[] p = {2, 3, 5, 7, 11, 13, 17};
        int countArrayA = 0, countArrayB = 0, countQ = 0, countResponse = 0;
        int[] arrayA, arrayB, response;

        Optional<Cups> cupsEntity = bartenderRepository.findById(id);
        if (cupsEntity.isPresent()) {
            int[] cups = java.util
                    .Arrays
                    .stream(cupsEntity.get().getInputArray().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            arrayB = new int[cups.length];
            arrayA = new int[cups.length];
            response = new int[cups.length];

            while (q > countQ) {
                for (int i = cups.length - 1; i >= 0; i--) {
                    if (cups[i] != 0) {
                        if ((cups[i] % p[countQ]) == 0) {
                            arrayB[countArrayB] = cups[i];
                            countArrayB++;
                        } else {
                            arrayA[countArrayA] = cups[i];
                            countArrayA++;
                        }
                    }
                }

                for (int j : arrayB) {
                    if (j != 0) {
                        response[countResponse] = j;
                        countResponse++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i < cups.length; i++) {
                    cups[i] = arrayA[i];
                    arrayA[i] = 0;
                    arrayB[i] = 0;
                }
                countArrayB = 0;
                countArrayA = 0;

                if (q == (countQ + 1) && cups[0] != 0) {
                    for (int cup : cups) {
                        if (cup != 0) {
                            response[countResponse] = cup;
                            countResponse++;
                        } else {
                            break;
                        }
                    }
                }

                countQ++;
            }
            responseArray.put("respuesta", Arrays.toString(response));
        }
        return responseArray;
    }
}
