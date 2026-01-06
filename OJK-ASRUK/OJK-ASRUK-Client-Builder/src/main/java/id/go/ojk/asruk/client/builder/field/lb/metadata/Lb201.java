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
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3031PosLbAsruk201;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb201 extends BaseMetadata {

	public Lb201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 23, 23, ER3031PosLbAsruk201.genFieldSave(), null, 
				ER3031PosLbAsruk201.getRequiredPos());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationJumlahPendapatanPremi());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationJumlahPremiBruto());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationJumlahPremiReasuransi());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationPremiNeto());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationJumlahPenurunanCadanganPremiCAPYBMPCadanganCatastrophic());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationPendapatanPremiNeto());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationPendapatanUnderwriting());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationJumlahBebanKlaimNeto());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationBebanUnderwriting());
		res.addSegmentValidations(ER3031PosLbAsruk201.genValidationTotalUnderwriting());
		res.addSegmentValidations(ER3031PosLbAsruk201.genFormValidationPremiPenutupanLangsung());
		res.addSegmentValidations(ER3031PosLbAsruk201.genFormValidationPremiPenutupanTidakLangsung());
		res.addSegmentValidations(ER3031PosLbAsruk201.genFormValidationPendapatanUnderwriting());
		res.addSegmentValidations(ER3031PosLbAsruk201.genFormValidationKlaimBruto());
		res.addSegmentValidations(ER3031PosLbAsruk201.genFormValidationBebanUnderwriting());
		res.addSegmentValidations(ER3031PosLbAsruk201.genFormValidationHasilUnderwriting());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3031_LB201.getObject())).confUnique(U));
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
				.addFieldValidations(ER3031PosLbAsruk201.genFieldValidation18()));
		return res;
	}
}
