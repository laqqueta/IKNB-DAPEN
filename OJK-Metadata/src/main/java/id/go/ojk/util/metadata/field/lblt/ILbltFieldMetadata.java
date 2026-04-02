package id.go.ojk.util.metadata.field.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.field.base.IBaseFieldMetadata;

import java.util.EnumSet;

public interface ILbltFieldMetadata extends IBaseFieldMetadata {
    EnumSet<ProgramType> getProgramType();
}
