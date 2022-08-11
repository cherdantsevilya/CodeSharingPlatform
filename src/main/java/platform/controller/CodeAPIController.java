package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.Code;
import platform.service.CodeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CodeAPIController {
    private final CodeService codeService;

    @Autowired
    public CodeAPIController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/code/{id}", produces = "application/json")
    public Code getCodeJSON(@PathVariable String id) {
        return codeService.findCode(id);
    }

    @GetMapping(value = "/code/latest", produces = "application/json")
    public List<Code> getCodeJSON() {
        return codeService.findLastCodes();
    }

    @PostMapping(value = "/code/new", consumes = "application/json")
    public String postCodeJSON(@RequestBody Code code) {
        codeService.saveCode(code);
        return "{\n    \"id\" : \"" + code.getId() + "\"\n}";
    }
}
