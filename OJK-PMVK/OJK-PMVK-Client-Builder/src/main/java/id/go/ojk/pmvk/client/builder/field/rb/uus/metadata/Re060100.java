package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumericSpace;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2756PosRePmvu060100;
import id.go.ojk.pmvk.client.builder.field.reference.EHeaderMetadataShared;

public class Re060100 extends BaseMetadata {

	public Re060100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_060100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null, null, null, ER2756PosRePmvu060100.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2756_RE060100.getObject())));
		fs.add(sf(2, null, "Nama Pemegang Saham", sv(C, 1, 160, alfaNumericSpace)
				.confConditionalRequired(ER2756PosRePmvu060100.genValidationMustEmpty())));
		fs.add(sf(3, null, "Kategori Pemegang Saham",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER2756PosRePmvu060100.genValidationMustEmpty())));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Realisasi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2756PosRePmvu060100.genValidationField6()));
		return res;
	}
}
