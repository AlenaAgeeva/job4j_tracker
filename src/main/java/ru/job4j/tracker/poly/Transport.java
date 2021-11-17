package ru.job4j.tracker.poly;

public interface Transport {
    void ride();

    void passengers(int num);

    double refuel(int amount);
}
