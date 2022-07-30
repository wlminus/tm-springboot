package com.techmaster.wlminus.springboot1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Controller
public class AgeController {

    @GetMapping("/level1/{time}")
    public ResponseEntity<String> level1(@PathVariable("time") Integer unixTimeAge) {
        try {
            this.validateInput(unixTimeAge);

            Date date = new Date(unixTimeAge * 1000L);
            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
            return ResponseEntity.ok(jdf.format(date));
        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }

    private boolean validateInput(Integer unixTimeInput) {
        if (unixTimeInput == 0) {
            throw new RuntimeException("Input time invalid: Zero");
        }

        if (unixTimeInput < 0) {
            throw new RuntimeException("Input time invalid: Negative");
        }

        return true;
    }

    @PatchMapping("/level2")
    public ResponseEntity<String> level2(@RequestParam("time") Integer unixTimeAge) {
        try {
            this.validateInput(unixTimeAge);

            long now = Instant.now().getEpochSecond();
            var different = now - unixTimeAge;
            var year = different / 31556926;
            var day = different / 86400;
            return ResponseEntity.ok("Year: " + year + " Day: " + day);
        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "World";
    }



//    private List<Integer> numberOfDayInMonth;
//    private static String convertUnixTimeToDate(Integer unixTime) {
//        Integer year = unixTime / 31556926;
//        Integer trueYear = year + 1970;
//
//        Integer numberOfDayFrom1970 = unixTime / 86400;
//        return trueYear.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(convertUnixTimeToDate(1659104458));
//    }
}
