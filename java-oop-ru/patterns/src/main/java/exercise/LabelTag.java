package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class LabelTag implements TagInterface {

    private String tagText;
    private TagInterface inputTag;

    @Override
    public String render() {
        return "<label>" + tagText + inputTag.render() + "</label>";
    }
}
// END
