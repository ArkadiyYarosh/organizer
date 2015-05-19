package by.bsuir.yarosh.settings;

import by.bsuir.yarosh.settings.domain.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@Scope(value = "prototype")
public class PagingUtil {
    public Collection<Page> getPages(long amount) {
        Collection<Page> pages = new ArrayList<>();

        long prevSkip=0;
        long prevAmount=10;
        long prevPage=1;

        while(amount > 0) {
            pages.add(new Page(prevPage, prevAmount, prevSkip));
            prevPage++;
            prevSkip += prevAmount;
            prevAmount += 10;

            amount -= 10;
        }

        return pages;
    }
}
