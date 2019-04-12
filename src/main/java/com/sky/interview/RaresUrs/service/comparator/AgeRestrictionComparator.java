package com.sky.interview.RaresUrs.service.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AgeRestrictionComparator implements Comparator<String> {

    private List<String> ageOrder = Arrays.asList("U", "PG", "12", "15", "18");

    @Override
    public int compare(final String o1, final String o2) {
        if (o1.equals(o2)) {
            return 1;
        } else {
            return Integer.compare(ageOrder.indexOf(o1), ageOrder.indexOf(o2));
        }
    }
}
