package br.com.pierre.restspringboot;

import br.com.pierre.restspringboot.exception.Unsuported;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

@RestController
public class MatController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double  sum(@PathVariable("numberOne") String numberOne, @PathVariable( "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Unsuported("please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return  sum;
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null ) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null ) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}