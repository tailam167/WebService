package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.config.AbstractServiceImpl;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl extends AbstractServiceImpl<Item> {
    @Autowired
    private ItemDaoIpml itemIpml;



    public List<Item> getItemById(int id) {
        return itemIpml.getItemById(id);
    }




}
