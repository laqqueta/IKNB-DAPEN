package id.go.ojk.pmvk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.DataType.yearMonth;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2009PosRbPmvk080000;
import id.go.ojk.pmvk.client.builder.field.reference.EHeaderMetadataShared;

public class Rb080000 extends BaseMetadata {

	public Rb080000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_080000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2009_RB080000.getObject())));
		fs.add(sf(2, null, "Rencana Pengembangan/Perubahan",
				sv(O, 0, 14, refTable).confReference(EHeaderMetadataShared.R005.getObject())));
		fs.add(sf(3, null, "Jenis Kantor",
				sv(C, 0, 10, refTable).confReference(EHeaderMetadataShared.R006.getObject())
						.confConditionalRequired(ER2009PosRbPmvk080000.genConditionalField3()))
				.addFieldValidations(ER2009PosRbPmvk080000.genValidationField3()));
		fs.add(sf(4, null, "Waktu Pelaksanaan",
				sv(C, 0, 6, yearMonth).confConditionalRequired(ER2009PosRbPmvk080000.genConditionalField4())));
		fs.add(sf(5, null, "Perkiraan Investasi/Biaya",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2009PosRbPmvk080000.genConditionalField5())));
		fs.add(sf(6, null, "Lokasi",
				sv(C, 0, 8, refTable).confConditionalRequired(ER2009PosRbPmvk080000.genConditionalField6())
						.confReference(EHeaderMetadataShared.R002.getObject())));
		fs.add(sf(7, null, "Keterangan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2009PosRbPmvk080000.genConditionalField7())));
		return res;
	}
}
