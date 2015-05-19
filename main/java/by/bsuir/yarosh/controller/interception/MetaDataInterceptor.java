package by.bsuir.yarosh.controller.interception;

import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.web.servlet.handler.*;

import javax.servlet.http.*;

public class MetaDataInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INotesService notesService;
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null && auth.isAuthenticated()) {
            User user = userService.getUser(auth.getName());

            long categoryAmount = categoryService.getCategoryAmountByUser(user);
            request.setAttribute("categoryAmount", categoryAmount);

            long notesAmount = notesService.getTotalNotesByUser(user);
            request.setAttribute("notesAmount", notesAmount);
        }

        return true;
    }
}
