package id.go.ojk.metadata.validation.lblt;

import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.base.IBaseMetadataValidation;

import java.util.EnumSet;

public interface ILbltMetadataValidation extends IBaseMetadataValidation {
    EnumSet<ProgramType> getProgramTypes();
}
