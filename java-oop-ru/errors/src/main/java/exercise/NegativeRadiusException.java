package exercise;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// BEGIN
@AllArgsConstructor
@NoArgsConstructor
class NegativeRadiusException extends Exception {
    private String message;
}
// END
