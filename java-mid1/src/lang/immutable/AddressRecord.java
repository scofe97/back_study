package lang.immutable;

public record AddressRecord(String street,
                            String city,
                            String state,
                            String zipCode)
        implements Comparable<AddressRecord> {

    @Override
    public int compareTo(AddressRecord other) {
        return this.zipCode.compareTo(other.zipCode);
    }
}
