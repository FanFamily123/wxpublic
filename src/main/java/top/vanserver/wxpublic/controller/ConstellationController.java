package top.vanserver.wxpublic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vanserver.wxpublic.service.ConstellationService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ConstellationController {
    @Autowired
    ConstellationService constellationService;

    @Autowired
    HttpServletRequest request;


    @RequestMapping(value = "constellation" )
    public String constellationSearch(){
        String consyeName = request.getParameter("consyeName");
        String consyellationMsg= null;
        try {
            consyellationMsg = constellationService.recode(consyeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consyellationMsg;
    }
}
