package by.bsuir.yarosh.controller;

import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String routeCategory(ModelMap modelMap) {
        modelMap.put("categories")
        return "category";
    }
}
