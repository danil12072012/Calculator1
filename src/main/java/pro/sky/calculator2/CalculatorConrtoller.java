package pro.sky.calculator2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorConrtoller {
    private final CalculatorServise calculatorService;
    public CalculatorConrtoller(CalculatorServise calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping(value = "/calculator")
    String hello () {
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping(value = "/calculator/plus")
    String plus (@RequestParam(value = "num1",required = false) Integer a,
                 @RequestParam(value = "num2",required = false) Integer b) {

        return buildView(a, b, calculatorService.plus(a, b), "+");
    }
    @GetMapping(value = "/calculator/minus")
    String minus (@RequestParam(value = "num1",required = false) Integer a,
                  @RequestParam(value = "num2",required = false) Integer b) {

        return buildView(a, b, calculatorService.minus(a, b), "-");
    }
    @GetMapping(value = "/calculator/multiply")
    String multiply (@RequestParam(value = "num1",required = false) Integer a,
                     @RequestParam(value = "num2",required = false) Integer b) {

        return buildView(a, b, calculatorService.multiply(a, b), "*");
    }
    @GetMapping(value = "/calculator/divide")
    String pdivide (@RequestParam(value = "num1",required = false) Integer a,
                    @RequestParam(value = "num2",required = false) Integer b) {

        return buildView(a, b, calculatorService.divide(a, b), "/");
    }

    private String buildView(Integer a, Integer b, Number result, String operation) {
        if (a == null || b == null) {
            return "не передан один из параметров";
        }
        if ("/".equals(operation) && b == 0) {
            return "на ноль делить нельзя";
        }
        return a + " " + operation + " " + b + " = " + result;
    }
}
