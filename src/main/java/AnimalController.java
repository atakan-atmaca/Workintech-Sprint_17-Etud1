package com.workintech.fsswebs17d1.controller;

import com.workintech.fsswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestParam Integer id, @RequestParam String name) {
        Animal animal = new Animal(id, name);
        animals.put(id, animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal updatedAnimal) {
        animals.put(id, updatedAnimal);
        return updatedAnimal;
    }

    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
        return "Animal with ID " + id + " removed.";
    }
}
