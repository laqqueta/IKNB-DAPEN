package id.go.ojk.client.service;

public interface ReferenceConfig {

    default String savePosForm() {
        return null;
    }

    default String savePos() {
        return null;
    }

    default String saveFieldPos() {
        return null;
    }

    default String uniquePos() {
        return null;
    }

    default String requiredPos() {
        return null;
    }

    default Integer segmentRequireColumnLink() {
        return null;
    }

    default String segmentColumnValue() {
        return null;
    }

    default String segmentReqiurePosCode() {
        return null;
    }

    default String segmentUniquePos() { return null; }

}
