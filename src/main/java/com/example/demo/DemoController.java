package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    DemoRepository demoRepository;

    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @GetMapping("/get")
    public List<DemoEntity> getAll(){
        return demoRepository.findAll();
    }

    @PostMapping("/post")
    public void post(@RequestParam String value){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setDemoValue(value);

        demoRepository.save(demoEntity);
    }
}
