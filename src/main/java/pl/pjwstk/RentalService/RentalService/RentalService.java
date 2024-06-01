package pl.pjwstk.RentalService.RentalService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RentalService {

    private String urlBool = "http://localhost:8080/moviesApp/movies/bool/{isAvailable}/{id}";

    private String urlSingle = "http://localhost:8080/moviesApp/movies/{id}";


    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovieByID(Integer id) {
       Movie movie = restTemplate.getForObject(urlSingle, Movie.class, id);
       return movie;

    }

    public void rentMovie(Integer id, Boolean isAvailable) {
        restTemplate.put(urlBool, Movie.class, isAvailable, id);
    }

}
