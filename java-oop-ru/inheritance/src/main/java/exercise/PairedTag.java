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
        super.setTagName(tagName);
        super.setTagAttributes(tagAttributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        children.forEach(c -> stringBuilder.append(c.getTagAttributes()));
        return format("<%s %s>%s</%s>", getTagName(), getStringOfAttributes(),
                stringBuilder, getTagName());
    }
}
// END
