package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;
@Service
public class MealService {
    @Autowired
    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, Integer userId) {
        return repository.save(meal,userId);
    }

    public void delete(int id,Integer userId) {
        checkNotFoundWithId(repository.delete(id,userId), id);
    }

    public Meal get(int id,Integer userId) {
        return checkNotFoundWithId(repository.get(id,userId), id);
    }

    public List<MealTo> getAll(Integer userId) {
        return MealsUtil.getTos(repository.getAll(userId), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }
    public List<MealTo> getAllFiltered(LocalDateTime startTime, LocalDateTime endTime,Integer userId) {
        if (startTime == null || endTime == null)
            return getAll(userId);
        return MealsUtil.getFilteredTos(repository.getAll(userId), MealsUtil.DEFAULT_CALORIES_PER_DAY,startTime,endTime.plusMinutes(1));
    }

    public void update(Meal meal,Integer userId) {
        checkNotFoundWithId(repository.save(meal,userId), meal.getId());
    }

}