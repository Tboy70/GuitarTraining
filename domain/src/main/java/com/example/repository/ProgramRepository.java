package com.example.repository;

import com.example.model.Program;

import rx.Observable;

/**
 * Created by Thomas on 04/05/2017.
 */

public interface ProgramRepository {
    Observable<Program> getProgramFromId(int idProgram);
}
