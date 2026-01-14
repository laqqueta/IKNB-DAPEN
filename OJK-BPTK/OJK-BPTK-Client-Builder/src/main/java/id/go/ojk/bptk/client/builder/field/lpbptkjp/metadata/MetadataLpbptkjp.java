package id.go.ojk.bptk.client.builder.field.lpbptkjp.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpInfJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRpiuJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLpbptkjp {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LpRkpstJp(EFormLpbptkjp.RKPST).get(),
      new LpRpiuJkk(EFormLpbptkjp.RPIU).get(),
      new LpRdjp(EFormLpbptkjp.RDJP).get(),
      new LpRpmfJp(EFormLpbptkjp.RPMF).get(),
      new LpRkpiuJp(EFormLpbptkjp.RKPIU).get(),
      new LpRkpmfJp(EFormLpbptkjp.RKPMF).get(),
      new LpInfJkk(EFormLpbptkjp.INF).get(),
      new LpSpJkk(EFormLpbptkjp.SP).get()
  );
}
