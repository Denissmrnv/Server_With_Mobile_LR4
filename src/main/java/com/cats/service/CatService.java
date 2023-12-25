package com.cats.service;

import com.cats.model.Cat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {
    List<Cat> cats = null;

    public CatService() throws FileNotFoundException {
        cats = new ArrayList<>(new Gson().fromJson(new FileReader("data.json"), new TypeToken<List<Cat>>() {}.getType()));
    }

    public List<Cat> getCats()  {
        return cats;
    }

    public List<Cat> getCatsByName(String name) {
        List<Cat> catsByName = new ArrayList<>();
        cats.forEach(cat -> {
            if (cat.getName().toLowerCase().indexOf(name.toLowerCase()) != -1) {
                catsByName.add(cat);
            }
        });
        return catsByName;
    }
}
