package ru.omgtu.fitiks.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.omgtu.fitiks.practice.model.Box;

import java.util.List;

/**
 * Created by max on 04.07.17.
 * @author Maxim Goncharov
 */
@Mapper
public interface BoxMapper {

    void insertBox(Box box);

    Box getBoxById(long boxId);

    Box getBoxByName(String name);

    List<Box> getAllBoxs();

    void updateBox(Box box);

    void deleteBox(long boxId);

}
