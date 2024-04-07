package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class InputTag implements TagInterface {

    private String type;
    private String value;

    @Override
    public String render() {
        return "<input type=\"" + type + "\" value=\"" + value + "\">";
    }
}
// END
