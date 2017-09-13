package com.example.repository;

import com.example.model.Program;

import java.util.List;

import rx.Observable;

/**
 * Interface implemented by the ProgramDataRepository class.
 */
public interface ProgramRepository {
    Observable<Program> getProgramFromId(int idProgram);

    Observable<List<Program>> retrieveProgramsListByUserId(int userId);
}
