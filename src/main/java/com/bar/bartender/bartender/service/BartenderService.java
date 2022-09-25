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
        Map<String, String> response = new HashMap<>();
        int[] p = {2, 3, 5, 7, 11, 13, 17};
        int auxA = 0;
        int countA = 0, countB = 0, countQ = 0, countArrayResponse = 0;
        int[] a, b, responseArray;

        Optional<Cups> cupsEntity = bartenderRepository.findById(id);
        if (cupsEntity.isPresent()) {
            int[] cups = java.util
                    .Arrays
                    .stream(cupsEntity.get().getInputArray().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            b = new int[cups.length];
            a = new int[cups.length];
            responseArray = new int[cups.length];

            while (q > countQ) {
                for (int i = cups.length - 1; i >= 0; i--) {
                    if (cups[i] != 0) {
                        if ((cups[i] % p[countQ]) == 0) {
                            b[countB] = cups[i];
                            countB++;
                        } else {
                            auxA = cups[i];
                            a[countA] = auxA;
                            countA++;
                        }
                    }
                }

                for (int i = 0; i < b.length; i++) {
                    if (b[i] != 0) {
                        responseArray[countArrayResponse] = b[i];
                        countArrayResponse++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i < cups.length; i++) {
                    cups[i] = a[i];
                    a[i] = 0;
                    b[i] = 0;
                }
                countB = 0;
                countA = 0;
                if (q == (countQ + 1) && cups[0] != 0) {
                    for (int i = 0; i < cups.length; i++) {
                        if (cups[i] != 0) {
                            responseArray[countArrayResponse] = cups[i];
                            countArrayResponse++;
                        } else {
                            break;
                        }
                    }
                }
                countQ++;
            }
            response.put("output", Arrays.toString(responseArray));
        }
        return response;
    }
}
