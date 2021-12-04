package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAsc() {
        int rsl = new AscNameSorter().compare(
                new Job("A", 9),
                new Job("B", 5)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        int rsl = new DescNameSorter().compare(
                new Job("A", 9),
                new Job("B", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        int rsl = new AscPrioritySorter().compare(
                new Job("A", 5),
                new Job("B", 8)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        int rsl = new DescPrioritySorter().compare(
                new Job("A", 5),
                new Job("B", 8)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new DescNameSorter().thenComparing(new DescPrioritySorter());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new AscNameSorter().thenComparing(new AscPrioritySorter());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndNameDesc() {
        Comparator<Job> cmpNamePriority = new DescPrioritySorter().thenComparing(new DescNameSorter());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndNameAsc() {
        Comparator<Job> cmpNamePriority = new AscPrioritySorter().thenComparing(new AscNameSorter());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}