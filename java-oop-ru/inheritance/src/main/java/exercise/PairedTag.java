package exercise;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> tagAttributes,
                     String body, List<Tag> children) {
        super(tagName, tagAttributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder childAttributes = new StringBuilder();
        children.forEach(c -> childAttributes.append(c.toString()));
        return format("<%s%s>%s%s</%s>", getTagName(), getStringOfAttributes(),
                childAttributes, body, getTagName());
    }
}
// END
