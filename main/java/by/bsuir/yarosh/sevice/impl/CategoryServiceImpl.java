package by.bsuir.yarosh.sevice.impl;

import by.bsuir.yarosh.dao.*;
import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private BasicDAO<NotesCategory, Integer> dao;

    @Override
    public long getCategoryAmountByUser(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", user.getUserId());
        return dao.getCount("select count(*) from NotesCategory n where n.user.userId =:user_id", map);
    }
}
