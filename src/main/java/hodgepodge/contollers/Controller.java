package hodgepodge.contollers;

import hodgepodge.models.SheepValue;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class Controller {

    static int sheepCount = 0;

    @GetMapping("/name")
    public String myName() {
        return "Logan";
    }

    @GetMapping("/current/time")
    public LocalDateTime currentTime() {
        return LocalDateTime.now();
    }

    @GetMapping("/greet/{name}")
    public String getGreeting(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PutMapping("/addSheep")
    public void addSheep() {
        sheepCount++;
    }

    @PutMapping("/addSheep/{amount}")
    public void addSheep(@PathVariable int amount) {
        sheepCount += amount;
    }

    @GetMapping("/countSheep")
    public int countSheep() {
        return sheepCount;
    }

    @PostMapping("/sheep")
    public void getAmount(@RequestBody SheepValue amount) {
        sheepCount = sheepCount + amount.getAmount();
    }
}
