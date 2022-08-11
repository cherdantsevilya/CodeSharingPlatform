package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import platform.entity.Code;
import platform.service.CodeService;

import java.util.List;

@RestController
public class CodeViewController {

    private final CodeService codeService;

    @Autowired
    public CodeViewController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(path = "/code/{id}", produces = "text/html")
    public ModelAndView codeToHTML(@PathVariable String id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("code");
        Code code = codeService.findCode(id);
        model.addObject("code", code);
        return model;
    }

    @GetMapping(path = "/code/latest", produces = "text/html")
    public ModelAndView codesToHTML() {
        ModelAndView model = new ModelAndView();
        model.setViewName("latest");
        model.addObject("title", "Latest");
        List<Code> codes = codeService.findLastCodes();
        model.addObject("codes", codes);
        return model;
    }

    @GetMapping(value = "/code/new", produces = "text/html")
    public ModelAndView codeFromHTML() {
        ModelAndView model = new ModelAndView();
        model.setViewName("create");
        return model;
    }
}
