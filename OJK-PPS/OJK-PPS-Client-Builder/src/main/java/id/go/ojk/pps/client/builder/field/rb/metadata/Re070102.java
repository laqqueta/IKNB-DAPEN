package id.go.ojk.pps.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2260PosRePps070102;

public class Re070102 extends BaseMetadata {

	public Re070102(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_070102;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 18, 18, ER2260PosRePps070102.genFieldSave(), ER2260PosRePps070102.genFieldSave(),
				ER2260PosRePps070102.getRequiredPos());
		res.addSegmentValidations(ER2260PosRePps070102.genValidationTotalPenerimaanPendanaanBaru());
		res.addSegmentValidations(ER2260PosRePps070102.genValidationTotalSaldoPenerimaanPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2260_RE070101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2260PosRePps070102.genValidationSum()));
		return res;
	}
}
