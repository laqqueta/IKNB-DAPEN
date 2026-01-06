package id.go.ojk.dppkk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.ER2108PosRbDppu0703;

public class Rb0703 extends BaseMetadata {

	public Rb0703(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_0703;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 21, 21, ER2108PosRbDppu0703.genFieldSave(), null, ER2108PosRbDppu0703.getRequiredPos());
		res.addSegmentValidations(ER2108PosRbDppu0703.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2108_RB0703.getObject())).confUnique(U));
		fs.add(sf(2, null, "Hasil Investasi Real Aktual Per 30 Sept 20XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Hasil Investasi Unreal Aktual Per 30 Sept 20XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Beban Investasi Aktual Per 30 Sept 20XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "Hasil Investasi Bersih Aktual Per 30 Sept 20XX-1", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2108PosRbDppu0703.genValidation5()));
		fs.add(sf(6, null, "Hasil Investasi Real Proyeksi Per 31 Des 20XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(7, null, "Hasil Investasi Unreal Proyeksi Per 31 Des 20XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(8, null, "Beban Investasi Proyeksi Per 31 Des 20XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(9, null, "Hasil Investasi Bersih Proyeksi Per 31 Des 20XX-1", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2108PosRbDppu0703.genValidation9()));
		fs.add(sf(10, null, "Hasil Investasi Real Proyeksi Per 30 Jun 20XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(11, null, "Hasil Investasi Unreal Proyeksi Per 30 Jun 20XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(12, null, "Beban Investasi Proyeksi Per 30 Jun 20XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(13, null, "Hasil Investasi Bersih Proyeksi Per 30 Jun 20XX", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2108PosRbDppu0703.genValidation13()));
		fs.add(sf(14, null, "Hasil Investasi Real Proyeksi Per 31 Des 20XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(15, null, "Hasil Investasi Unreal Proyeksi Per 31 Des 20XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(16, null, "Beban Investasi Proyeksi Per 31 Des 20XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(17, null, "Hasil Investasi Bersih Proyeksi Per 31 Des 20XX", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2108PosRbDppu0703.genValidation17()));
		return res;
	}
}
