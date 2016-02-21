/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellowebserviceclient;

import com.manh.ws.currencyconver.Currency;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Suryasnata
 */
public class HelloWebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            getMessage("Siddhanta");
       // System.out.println(conversionRate(Currency.USD, Currency.INR));
    }

    private static String getMessage(java.lang.String arg0) {
        com.manh.wsclient.HelloWebServiceService service = new com.manh.wsclient.HelloWebServiceService();
        com.manh.wsclient.HelloWebService port = service.getHelloWebServicePort();
         // Change the destination port to 4040
        BindingProvider bp = (BindingProvider) port;
        String address = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        address = address.replaceFirst("8080", "4040");
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        //
        return port.getMessage(arg0);
    }

    private static double conversionRate(com.manh.ws.currencyconver.Currency fromCurrency, com.manh.ws.currencyconver.Currency toCurrency) {
        com.manh.ws.currencyconver.CurrencyConvertor service = new com.manh.ws.currencyconver.CurrencyConvertor();
        com.manh.ws.currencyconver.CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();
        return port.conversionRate(fromCurrency, toCurrency);
    }
    
}
