package com.ilb.service;

import com.ilb.domain.Bread;

import java.util.ArrayList;
import java.util.List;

public class BreadService {
    public List<Bread> filterBread(List<Bread> breads, BreadPredicator bp) {
        List<Bread> result = new ArrayList<>();
        for (Bread bread : breads) {
            if (bp.test(bread)) {
                result.add(bread);
            }
        }
        return result;
    }
}
