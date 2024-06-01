package pl.pjwstk.RentalService.RentalService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentalApp")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("movies/bool/{isAvailable}/{id}")
    public ResponseEntity<Void> setIsAvailable(@PathVariable("id") Integer id, @PathVariable("isAvailable") Boolean isAvailable) {
        rentalService.rentMovie(id, isAvailable);
        return ResponseEntity.ok().build();
    }


    @GetMapping("movies/{id}")
    public ResponseEntity<Movie> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getMovieByID(id));
    }
}
