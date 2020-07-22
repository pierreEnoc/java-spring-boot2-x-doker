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

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double  multipplication(@PathVariable("numberOne") String numberOne, @PathVariable( "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Unsuported("please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return  sum;

    }  @RequestMapping(value = "/substraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double  substraction(@PathVariable("numberOne") String numberOne, @PathVariable( "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Unsuported("please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return  sum;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double  division(@PathVariable("numberOne") String numberOne, @PathVariable( "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Unsuported("please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return  sum;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double  mean(@PathVariable("numberOne") String numberOne, @PathVariable( "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Unsuported("please set a numeric value");
        }
        Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
        return  sum;
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double  squareRoot(@PathVariable("number") String number) throws Exception {
        if(!isNumeric(number)) {
            throw new Unsuported("please set a numeric value");
        }
        Double sum = (Double) Math.sqrt(convertToDouble(number));
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