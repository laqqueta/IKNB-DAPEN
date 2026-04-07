package id.go.ojk.util.metadata.validation.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.base.IBaseMetadataValidation;

import java.util.EnumSet;

public interface ILbltMetadataValidation extends IBaseMetadataValidation {
    EnumSet<ProgramType> getProgramTypes();
}
