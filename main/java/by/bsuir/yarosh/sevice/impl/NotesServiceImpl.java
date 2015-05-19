package by.bsuir.yarosh.sevice.impl;

import by.bsuir.yarosh.dao.*;
import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Transactional
@Service
public class NotesServiceImpl implements INotesService {
    @Autowired
    private BasicDAO<Notes, Integer> dao;

    @Override
    public Collection<Notes> getNotesByUser(User user, int amount, int skip) {
        String query = "from Notes n where n.category.user.userId =:user_id";

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", user.getUserId());

        return dao.read(query, amount, skip, map);
    }

    @Override
    public long getTotalNotesByUser(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", user.getUserId());
        return dao.getCount("select count(*) from Notes n where n.category.user.userId =:user_id", map);
    }
}
