package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3035PosLbAsruk204;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb204 extends BaseMetadata {

	public Lb204(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_204;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 24, 24, ER3035PosLbAsruk204.genFieldSave(), null,
				ER3035PosLbAsruk204.getRequiredPos());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCadanganPremiGross());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanAsetReasuransiAtasCadanganKlaim());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCadanganPremi());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCAPYBMPGross());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanAsetReasuransiAtasCAPYBMP());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCAPYBMP());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCadanganatasRisikoBencanaNetto());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCadanganKlaimGross());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanAsetReasuransiAtasCadanganPremi());
		res.addSegmentValidations(ER3035PosLbAsruk204.genValidationJumlahPenurunanCadanganKlaim());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3035_LB204.getObject())).confUnique(U));
		fs.add(sf(2, null, "Harta Benda (Property)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Pengangkutan (Marine Cargo)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Rangka Kapal (Marine Hull)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Rangka Pesawat (Aviation Hull)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Satelit", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Energi Onshore (Oil and Gas)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Energi Offshore (Oil and Gas)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Rekayasa (Engineering)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Tanggung Gugat (Liability)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Kecelakaan Diri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Kesehatan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Kredit (Credit) ", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Suretyship", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "Aneka", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Jiwa*)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3035PosLbAsruk204.genFieldValidation5()));
		return res;
	}
}
