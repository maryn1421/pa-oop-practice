package com.practice.app.dao;

import com.practice.app.model.Exercise;

import java.sql.SQLException;
import java.util.List;

public interface ExerciseDao {

    List<Exercise> getAll() throws SQLException;
}
