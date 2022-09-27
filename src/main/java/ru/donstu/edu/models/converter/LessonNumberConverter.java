package ru.donstu.edu.models.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ru.donstu.edu.models.LessonNumber;

@Converter(autoApply = true)
public class LessonNumberConverter implements AttributeConverter<LessonNumber, Integer> {

    @Override
    public Integer convertToDatabaseColumn(LessonNumber attribute) {
        return attribute.getId();
    }

    @Override
    public LessonNumber convertToEntityAttribute(Integer dbData) {
        return LessonNumber.findById(dbData);
    }

}
