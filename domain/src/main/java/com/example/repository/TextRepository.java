package com.example.repository;

import com.example.model.Text;

import rx.Observable;

/**
 * Interface implemented by the TextDataRepository class.
 */
public interface TextRepository {

    Observable<Text> getApplicationAboutInformation();
}
