package com.example.data.entity.db.converter;

import com.example.data.entity.ExerciseEntity;
import com.example.data.entity.db.ProgramDBEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;

@com.raizlabs.android.dbflow.annotation.TypeConverter
public class StringListTypeConverter extends TypeConverter<String, List> {

    @Override
    public String getDBValue(List model) {
        return new Gson().toJson(model);
    }

    @Override
    public List getModelValue(String data) {
        return new Gson().fromJson(data, new TypeToken<List<ExerciseEntity>>(){{}}.getType());
    }
}
