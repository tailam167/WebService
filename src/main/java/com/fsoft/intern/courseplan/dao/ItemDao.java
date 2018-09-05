package com.fsoft.intern.courseplan.dao;

import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;

import java.util.List;

public interface ItemDao  {

     List<Item> getItemById(int id);

     List<Item> getItemById(int id, DATA_TYPE data_type);
}
