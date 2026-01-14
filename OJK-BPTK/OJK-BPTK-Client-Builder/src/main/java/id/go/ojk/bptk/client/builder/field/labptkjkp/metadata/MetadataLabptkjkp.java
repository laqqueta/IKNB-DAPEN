package id.go.ojk.bptk.client.builder.field.labptkjkp.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjkp;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaDtumJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaLampJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaRasJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLabptkjkp {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LaDtumJkk(EFormLabptkjkp.DTUM).get(),
      new LaRasJkk(EFormLabptkjkp.RAS).get(),
      new LaLampJkk(EFormLabptkjkp.LAMP).get(),
      new LaSpJkk(EFormLabptkjkp.SP).get()
  );
}
