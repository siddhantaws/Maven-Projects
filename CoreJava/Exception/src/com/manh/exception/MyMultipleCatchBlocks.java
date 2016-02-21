package com.manh.exception;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MyMultipleCatchBlocks 
{
	public void execute(int i){
        try{
            if(i == 1){
                getIntValue("7u");
            } else {
                getUrlObj("www.junksite.com");
            }
        } catch (NumberFormatException nfe)
        {
            System.out.println("Inside NumberFormatException... "+nfe.getMessage());
        } catch (MalformedURLException mue)
        {
            System.out.println("Inside MalformedURLException... "+mue.getMessage());
        }
        catch (ArithmeticException ex){
            System.out.println("Inside Exception... "+ex.getMessage());
        }
        catch (IOException ex){
            System.out.println("Inside Exception... "+ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Inside Exception... "+ex.getMessage());
        }
    }
    public int getIntValue(String num){
        return Integer.parseInt(num);
    }
     
    public URL getUrlObj(String urlStr) throws MalformedURLException{
        return new URL(urlStr);
    }

}
