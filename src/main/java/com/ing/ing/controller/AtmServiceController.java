package com.ing.ing.controller;

import com.ing.ing.models.ATM;
import com.ing.ing.models.Task;
import com.ing.ing.view.AtmView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/atms")
public final class AtmServiceController {
    private final AtmView atmView = new AtmView();

    @PostMapping("/calculateOrder")
    public List<ATM> CalculateOrder(@RequestBody Task[] tasks) {
        if(tasks.length == 0) throw new ArrayIndexOutOfBoundsException("Tasks are empty");
        return atmView.calculateOrder(tasks);
    }
}
