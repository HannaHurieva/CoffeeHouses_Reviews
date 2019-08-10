package com.alevel.project.coffee.service;

import com.alevel.project.coffee.model.Contact;
import com.alevel.project.coffee.model.Place;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlaceService {
    void createNewPlace(Place place, Contact contact, Map<String, String> form);

    List<Place> findAll();

    Optional<Place> findByTitle(String title);

    List<Place> findByContact_Location(String location);

    List<Place> findByCuisineType(String cuisineType);

    List<Place> findByPlaceCategory(String placeCategory);

    boolean isTitleExist(Place place);

    void updatePlace(Place place,
                     String title, String description,
                     int timeOpening, int timeClosing,
                     Contact contact,
                     String address, String location, String phone, String website,
                     Map<String, String> form);

    void deletePlace(Place place);

}
