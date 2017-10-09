package com.example.repository;

import com.example.model.Exercise;
import com.example.model.Program;

import java.util.List;

import rx.Observable;

/**
 * Interface implemented by the ProgramDataRepository class.
 */
public interface ProgramRepository {
    Observable<Program> getProgramFromId(String idProgram);

    Observable<List<Program>> retrieveProgramsListByUserId(String userId);

    Observable<Program> retrieveProgramById(String programId);

    Observable<Program> createProgram(Program program);

    Observable<Boolean> createExercise(List<Exercise> exercise);

    Observable<Boolean> removeProgram(String idExercise);
}
