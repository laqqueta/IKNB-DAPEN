package id.go.ojk.bptk.client.builder.field.lpbptkjkp.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjkp;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpInfJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRkpiuJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRkpstJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLpbptkjkp {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LpRkpstJkk(EFormLpbptkjkp.RKPST).get(),
      new LpRpiuJkp(EFormLpbptkjkp.RPIU).get(),
      new LpRpmfJkp(EFormLpbptkjkp.RPMF).get(),
      new LpRkpiuJkk(EFormLpbptkjkp.RKPIU).get(),
      new LpRkpmfJkp(EFormLpbptkjkp.RKPMF).get(),
      new LpInfJkk(EFormLpbptkjkp.INF).get(),
      new LpSpJkk(EFormLpbptkjkp.SP).get()
  );
}
