package by.bsuir.yarosh.sevice;

import by.bsuir.yarosh.domain.*;

import java.util.*;

public interface INotesService {
    Collection<Notes> getNotesByUser(User user, int amount, int skip);
    long getTotalNotesByUser(User user);
}
