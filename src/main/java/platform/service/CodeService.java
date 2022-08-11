package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.entity.Code;
import platform.exception.CodeNotFoundException;
import platform.repository.CodeRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public void saveCode(Code code) {
        code.setDate(LocalDateTime.now());
        code.setTimeRestriction(code.getTime() > 0);
        code.setViewsRestriction(code.getViews() > 0);
        codeRepository.save(code);
    }

    public Code findCode(String id) {
        Optional<Code> code = codeRepository.findById(id);
        if (code.isEmpty())
            throw new CodeNotFoundException();
        updateCode(code.get());
        return code.get();
    }

    public List<Code> findLastCodes() {
        List<Code> unfinishedList = codeRepository.findAll();
        Collections.reverse(unfinishedList);
        List<Code> finishedList = new ArrayList<>();
        for (Code code : unfinishedList) {
            if (code.getTime() == 0 && code.getViews() == 0)
                finishedList.add(code);
        }
        return finishedList.stream().limit(10).collect(Collectors.toList());
    }

    public void updateCode(Code code) {
        if (code.getTimeRestriction()) {
            Duration difference = Duration.between(code.getLocalDateTime(), LocalDateTime.now());
            if (code.getTime() - difference.getSeconds() <= 0) {
                deleteCode(code);
                throw new CodeNotFoundException();
            }
            code.setTime(code.getTime() - difference.getSeconds());
        }
        if (code.getViewsRestriction()) {
            if (code.getViews() == 0) {
                deleteCode(code);
                throw new CodeNotFoundException();
            }
            code.setViews(code.getViews() - 1);
            codeRepository.save(code);
        }
    }

    public void deleteCode(Code code) {
        codeRepository.deleteById(code.getId());
    }
}
