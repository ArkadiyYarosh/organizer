package by.bsuir.yarosh.controller;

import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.settings.*;
import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotesController {
    @Autowired
    private IUserService userService;
    @Autowired
    private INotesService notesService;
    @Autowired
    private PagingUtil pagingUtil;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String routeNotes(@RequestParam(required = false) Integer amount,
                             @RequestParam(required = false) Integer skip,
                             @RequestParam(required = false) Integer pageNo,
                             ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null && auth.isAuthenticated()) {
            User user = userService.getUser(auth.getName());

            if (user == null) {
                return "login";
            }

            if(amount==null) amount=10;
            if(skip==null) skip=0;
            if(pageNo==null)pageNo=1;
            modelMap.put("notes", notesService.getNotesByUser(user, amount, skip));

            long totalAmount = notesService.getTotalNotesByUser(user);
            if(totalAmount > 10) {
                modelMap.put("pages", pagingUtil.getPages(totalAmount));
            }
            modelMap.put("currentPage", pageNo);
        }

        return "notes";
    }
}
