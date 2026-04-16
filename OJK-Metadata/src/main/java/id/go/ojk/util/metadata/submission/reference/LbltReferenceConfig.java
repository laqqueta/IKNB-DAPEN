package id.go.ojk.util.metadata.submission.reference;

import id.go.ojk.util.constants.ProgramType;

public interface LbltReferenceConfig {
    default String savePosForm(ProgramType programType) {
        return null;
    }

    default String savePos(ProgramType programType) {
        return null;
    }

    default String saveFieldPos(ProgramType programType) {
        return null;
    }

    default String uniquePos(ProgramType programType) {
        return null;
    }

    default String requiredPos(ProgramType programType) {
        return null;
    }

}
