package exercise;

import java.util.Map;

import static java.lang.String.format;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
    }

    @Override
    public String toString() {
        return format( "<%s%s>", getTagName(), getStringOfAttributes());
    }
}
// END
