package exercise;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static java.lang.String.format;

// BEGIN
@Getter
@Setter
class Tag {
    private String tagName;
    private Map<String, String> tagAttributes;

    protected String getStringOfAttributes() {
        StringBuilder stringBuilder = new StringBuilder();
        tagAttributes.forEach((k, v) ->
                stringBuilder.append(format("%s=\"%s\" ", k, v))
        );
        if (stringBuilder.isEmpty()) {
            return "";
        }
        return stringBuilder.insert(0, " ")
                .substring(0, stringBuilder.lastIndexOf(" "));
    }
}
// END
