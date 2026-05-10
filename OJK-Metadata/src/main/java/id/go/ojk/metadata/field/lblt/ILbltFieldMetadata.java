package id.go.ojk.metadata.field.lblt;

import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.field.base.IBaseFieldMetadata;

import java.util.EnumSet;

public interface ILbltFieldMetadata extends IBaseFieldMetadata {
    EnumSet<ProgramType> getProgramType();
}
