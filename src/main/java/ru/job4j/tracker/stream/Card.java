package ru.job4j.tracker.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card: "
                + suit
                + " "
                + value;
    }

    public static List<Card> getCards() {
        return Stream.of(Suit.values())
                .flatMap(x -> Stream.of(Value.values())
                        .map(y -> new Card(x, y)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Card.getCards().forEach(System.out::println);
    }
}
