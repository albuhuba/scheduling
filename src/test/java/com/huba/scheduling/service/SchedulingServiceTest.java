package com.huba.scheduling.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SchedulingServiceTest {

    private static final SchedulingService service = new SchedulingService();

    @Test
    public void suggestPossibleMeetingTime() {
        Integer firstSlot = service.getFirstSlot(1, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9)));
        List<Integer> emptySlots = service.getEmptySlots(1, new Object[]{null, 1, 2, 3, 4, 5, null, 7, 8, 9, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});

        assertEquals(new Integer(6), firstSlot);
        assertTrue(emptySlots.containsAll(Arrays.asList(6, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23)));
    }

    @Test
    public void timeMiddleOfList() {
        Integer firstSlot = service.getFirstSlot(1, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9)));

        assertEquals(new Integer(6), firstSlot);
    }

    @Test
    public void timeNoTimeSet() {
        Integer firstSlot = service.getFirstSlot(1, new TreeSet<>());
        List<Integer> emptySlots = service.getEmptySlots(0, new Object[]{null, null, null, null,null,null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null});

        assertTrue(emptySlots.containsAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23)));
        assertEquals(new Integer(1), firstSlot);
    }

    @Test
    public void allTimeSlotsUsed() {
        Integer firstSlot = service.getFirstSlot(1, new TreeSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23)));

        assertEquals(new Integer(-1), firstSlot);
    }

}
