package id.go.ojk.bptk.client.builder.field.labptkjp.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjp;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaDtumJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaLampJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLabptkjp {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LaDtumJkk(EFormLabptkjp.DTUM).get(),
      new LaRasJp(EFormLabptkjp.RAS).get(),
      new LaLampJkk(EFormLabptkjp.LAMP).get(),
      new LaSpJkk(EFormLabptkjp.SP).get()
  );
}
