package com.ing.ing.view;

import com.ing.ing.models.ATM;
import com.ing.ing.models.Task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class AtmView {
    private static class TaskComparator implements Comparator<Task> {
        public int compare(Task s1, Task s2) {
            var region = s1.getRegion() - s2.getRegion();
            if(region != 0) return region;
            return s1.getRequestType().compareTo(s2.getRequestType());
        }
    }
    public List<ATM> calculateOrder(Task[] tasks) {
        Arrays.parallelSort(tasks, new TaskComparator());
        return Arrays.stream(tasks).distinct().collect(Collectors.toList());
    }
}
