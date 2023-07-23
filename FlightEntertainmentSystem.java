import java.util.ArrayList;
import java.util.List;

public class FlightEntertainmentSystem {

    public static void main(String[] args) {
        // Sample data: movie durations and flight duration in minutes
        List<Integer> movieDurations = new ArrayList<>();
        movieDurations.add(90);
        movieDurations.add(120);
        movieDurations.add(80);
        movieDurations.add(110);
        movieDurations.add(200);
        int flightDuration = 350;

        // Find the pair of movies
        List<Integer> selectedMovies = findPairOfMovies(movieDurations, flightDuration);

        // Check if a pair of movies was found and display the result
        if (selectedMovies != null) {
            System.out.println("Selected Movies Duration: " + selectedMovies.get(0) + ", " + selectedMovies.get(1));
        } else {
            System.out.println("No pair of movies found within the given flight duration.");
        }
    }

    // Algorithm to find a pair of movies within the given flight duration
    public static List<Integer> findPairOfMovies(List<Integer> movieDurations, int flightDuration) {
        // Initialize variables to keep track of the result and the longest total runtime found
        List<Integer> result = null;
        int maxRuntime = -1;

        // Loop through all pairs of movies to find the ones with the longest total runtime
        for (int i = 0; i < movieDurations.size(); i++) {
            for (int j = i + 1; j < movieDurations.size(); j++) {
                // Calculate the total runtime of the current pair of movies
                int totalRuntime = movieDurations.get(i) + movieDurations.get(j);
                
                // Check if the total runtime is within the flight duration constraint
                // (less or equal to flightDuration - 30 minutes) and greater than the current maxRuntime
                if (totalRuntime <= flightDuration - 30 && totalRuntime > maxRuntime) {
                    // If the condition is met, update the result with the current pair of movies
                    // and update the maxRuntime with the new longest total runtime
                    maxRuntime = totalRuntime;
                    result = List.of(movieDurations.get(i), movieDurations.get(j));
                }
            }
        }
        // Return the pair of movies with the longest total runtime that meets the flight duration constraint
        return result;
    }
}