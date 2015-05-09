/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beliapalagi.restful.object;

/**
 *
 * @author chedoxtop@gmail.com
 */
public class WebServiceLDAP {

    private String retval;
    private String username;
    private String password;
    private String message;
   
    public WebServiceLDAP(){}
   
    public String getRetval() {
        return retval;
    }

    public void setRetval(String retval) {
        this.retval = retval;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WebServiceLDAP{" + "retval=" + retval + ", username=" + username + ", password=" + password + ", message=" + message + '}';
    }

    
}
