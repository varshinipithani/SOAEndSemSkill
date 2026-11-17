package com.tourist.touristjwt.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tourist.touristjwt.model.Tourist;

@Component
public class TouristData {
    private final List<Tourist> tourists = new ArrayList<>();

    public TouristData() {
        tourists.add(new Tourist(1, "Varshini", "Taj Mahal", "India"));
        tourists.add(new Tourist(2, "Rahul", "Eiffel Tower", "France"));
        tourists.add(new Tourist(3, "Priya", "Goa Beach", "India"));
        tourists.add(new Tourist(4, "Arjun", "Bali", "Indonesia"));
        tourists.add(new Tourist(5, "Sneha", "Swiss Alps", "Switzerland"));
    }

    public List<Tourist> getAllTourists() {
        return tourists;
    }

    public Tourist getTouristById(int id) {
        return tourists.stream()
                .filter(tourist -> tourist.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Tourist addTourist(Tourist tourist) {
        int nextId = tourists.stream()
                .mapToInt(Tourist::getId)
                .max()
                .orElse(0) + 1;
        tourist.setId(nextId);
        tourists.add(tourist);
        return tourist;
    }
}
