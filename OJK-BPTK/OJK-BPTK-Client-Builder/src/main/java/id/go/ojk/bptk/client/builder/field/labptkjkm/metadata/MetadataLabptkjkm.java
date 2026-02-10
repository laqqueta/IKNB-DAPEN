package id.go.ojk.bptk.client.builder.field.labptkjkm.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjkm;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaDtumJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaLampJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaRasJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLabptkjkm {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LaDtumJkk(EFormLabptkjkm.DTUM).get(),
      new LaRasJkk(EFormLabptkjkm.RAS).get(),
      new LaLampJkk(EFormLabptkjkm.LAMP).get(),
      new LaSpJkk(EFormLabptkjkm.SP).get()
  );
}
