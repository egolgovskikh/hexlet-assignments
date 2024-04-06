package exercise;

// BEGIN
class ReversedSequence implements CharSequence {

    private String value;

    ReversedSequence(String str) {
        this.value = new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.substring(start, end);
    }

    @Override
    public String toString() {
        return value;
    }
}
// END
