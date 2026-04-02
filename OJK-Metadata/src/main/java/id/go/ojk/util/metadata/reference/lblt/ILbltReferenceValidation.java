package id.go.ojk.util.metadata.reference.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.reference.base.IBaseReferenceValidation;

import java.util.EnumSet;

public interface ILbltReferenceValidation extends IBaseReferenceValidation {
    EnumSet<ProgramType> getProgramTypes();
}
