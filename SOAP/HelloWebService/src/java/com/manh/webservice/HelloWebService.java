/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.webservice;

import javax.jws.WebService;

/**
 *
 * @author Suryasnata
 */
@WebService
public class HelloWebService 
{
    public String getMessage(String name)
    {
        return "My Name is "+name;
    }
}
