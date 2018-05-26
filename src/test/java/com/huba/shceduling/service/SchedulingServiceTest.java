package com.huba.shceduling.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SchedulingServiceTest {

    private static final SchedulingService service = new SchedulingService();

    @Test
    public void suggestPossibleMeetingTime() {
        Integer firstSlot = service.getFirstSlot(0, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9)));

        assertEquals(firstSlot, new Integer(0));
    }

    @Test
    public void suggestPossibleMeetingTimeMiddleOfList() {
        Integer firstSlot = service.getFirstSlot(1, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9)));

        assertEquals(firstSlot, new Integer(6));
    }
}
