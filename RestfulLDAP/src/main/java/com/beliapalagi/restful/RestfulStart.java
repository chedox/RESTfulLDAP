package com.beliapalagi.restful;

import com.beliapalagi.restful.object.WebServiceLDAP;
import com.beliapalagi.restful.util.ADAuthenticator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author chedoxtop@gmail.com
 */
@Controller
@RequestMapping("/services")
public class RestfulStart {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestfulStart.class);
   
    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    @ResponseBody
    public List<WebServiceLDAP> getAuthLDAP(@RequestParam("userid") String userid, @RequestParam("password") String password) {
        List<WebServiceLDAP> wsLDAPs = new ArrayList<>();
        WebServiceLDAP wsLDAP = new WebServiceLDAP();
        try {
            if ((((userid != null) && (!userid.equalsIgnoreCase(""))) && (password != null)) && (!password.equalsIgnoreCase(""))) {
                ADAuthenticator adAuthenticator = new ADAuthenticator();
                System.out.println("Try to connect LDAP");
                Map<String, Object> attrs = adAuthenticator.authenticate(userid, password);
                if (attrs != null) {
                    for (String attrKey : attrs.keySet()) {
                        if (attrs.get(attrKey) instanceof String) {
                            System.out.println("@attrKeyname_:"+attrs.get("name"));
                            System.out.println(attrKey + ": " + attrs.get(attrKey));
                            wsLDAP.setUsername(attrs.get("name").toString());
                            wsLDAP.setPassword(password);
                            wsLDAP.setRetval("0");
                            wsLDAP.setMessage("Successfull to validate LDAP");
                        } else {
                            System.out.println(attrKey + ": (Multiple Values)");
                            for (Object o : (HashSet) attrs.get(attrKey)) {
                                System.out.println("\t value: " + o);
                            }
                        }
                    }
                } else {
                    System.out.println("Connection failed or attributes LDAP are null!");
                }
                wsLDAPs.add(wsLDAP);
            } else {
                wsLDAP.setRetval("-1");
                wsLDAP.setUsername(userid);
                wsLDAP.setPassword(password);
                wsLDAP.setMessage("invalid url type or credentials");
                wsLDAPs.add(wsLDAP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wsLDAPs;
    }

}
