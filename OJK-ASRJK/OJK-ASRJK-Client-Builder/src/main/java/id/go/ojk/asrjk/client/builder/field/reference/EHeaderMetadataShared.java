package id.go.ojk.asrjk.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1000JenisInvestasi;
import id.go.ojk.conf.client.field.reference.ER1001KategoriJenisInvestasi;
import id.go.ojk.conf.client.field.reference.ER1002JenisInvestasiPaydi;
import id.go.ojk.conf.client.field.reference.ER1003JenisIndustri;
import id.go.ojk.conf.client.field.reference.ER1013JenisInvestasiSyariah;
import id.go.ojk.conf.client.field.reference.ER1014PeriodeLaporan;
import id.go.ojk.conf.client.field.reference.ER1015Dati1;
import id.go.ojk.conf.client.field.reference.ER1016Dati2;
import id.go.ojk.conf.client.field.reference.ER1017DireksiKomisaris;
import id.go.ojk.conf.client.field.reference.ER1018DalamLuarNegeri;
import id.go.ojk.conf.client.field.reference.ER1019PeringkatKlaster;
import id.go.ojk.conf.client.field.reference.ER1020JenisJaminan;
import id.go.ojk.conf.client.field.reference.ER1021SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1022JenisNonInvestasi;
import id.go.ojk.conf.client.field.reference.ER1023KategoriJenisNonInvestasi;
import id.go.ojk.conf.client.field.reference.ER1024SumberAsetReasuransi;
import id.go.ojk.conf.client.field.reference.ER1025JenisLiabilitas;
import id.go.ojk.conf.client.field.reference.ER1026KategoriUtang;
import id.go.ojk.conf.client.field.reference.ER1027JenisPendapatan;
import id.go.ojk.conf.client.field.reference.ER1028DanaJaminan;
import id.go.ojk.conf.client.field.reference.ER1029MataUang;
import id.go.ojk.conf.client.field.reference.ER1030JenisPertanggungan;
import id.go.ojk.conf.client.field.reference.ER1031MataUangIdrAtauUsd;
import id.go.ojk.conf.client.field.reference.ER1032CaraBayar;
import id.go.ojk.conf.client.field.reference.ER1033CabangAsuransi;
import id.go.ojk.conf.client.field.reference.ER1034JenisImbalan;
import id.go.ojk.conf.client.field.reference.ER1035CabangAsuransi;
import id.go.ojk.conf.client.field.reference.ER1036TradisionalAtauPaydi;
import id.go.ojk.conf.client.field.reference.ER1037Negara;
import id.go.ojk.conf.client.field.reference.ER1038StatusProduk;
import id.go.ojk.conf.client.field.reference.ER1039KanalDistribusi;
import id.go.ojk.conf.client.field.reference.ER1040EstimasiProfitLoss;
import id.go.ojk.conf.client.field.reference.ER1041MetodePerhitunganEstimasi;
import id.go.ojk.conf.client.field.reference.ER1045CabangAsuransiUmum;
import id.go.ojk.conf.client.field.reference.ER1048Dati2VsDati1Lapbul;
import id.go.ojk.conf.client.field.reference.ER1049KodeBank;
import id.go.ojk.conf.client.field.reference.ER1050JenisInvestasiVsKategori;
import id.go.ojk.conf.client.field.reference.ER1051JenisInvestasiPaydiVsKategori;
import id.go.ojk.conf.client.field.reference.ER1052JenisNonInvestasiVsKategori;
import id.go.ojk.conf.client.field.reference.ER1062JenisInvestasiVsSektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1063JenisLiabilitasVsKategoriUtang;
import id.go.ojk.conf.client.field.reference.ER1093JenisInvestasiPaydiVsSektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1096StatusAset;
import id.go.ojk.conf.client.field.reference.ER1097JenisInvestasiVsSektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1098JenisPemegangSaham;
import id.go.ojk.conf.client.field.reference.ER1100Penilaian;
import id.go.ojk.conf.client.field.reference.ER1101Kepemilikan;
import id.go.ojk.conf.client.field.reference.ER1196JenisPolis;
import id.go.ojk.conf.client.field.reference.ER1197JenisKelamin;
import id.go.ojk.conf.client.field.reference.ER1198LokasiPemegangPolis;
import id.go.ojk.conf.client.field.reference.ER1199LiniUsahaAsuransiJiwa;
import id.go.ojk.conf.client.field.reference.ER1200LiniUsahaAsuransiUmum;
import id.go.ojk.conf.client.field.reference.ER1201CaraBayar;
import id.go.ojk.conf.client.field.reference.ER1202StatusPertanggungan;
import id.go.ojk.conf.client.field.reference.ER1203JenisKlaimAsuransiJiwa;
import id.go.ojk.conf.client.field.reference.ER1204JenisKlaimAsuransiUmum;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R000(ER1000JenisInvestasi.getRefNumber(), ER1000JenisInvestasi.getName(), ER1000JenisInvestasi.getObjects()),
	R001(ER1001KategoriJenisInvestasi.getRefNumber(), ER1001KategoriJenisInvestasi.getName(),
			ER1001KategoriJenisInvestasi.getObjects()),
	R002(ER1002JenisInvestasiPaydi.getRefNumber(), ER1002JenisInvestasiPaydi.getName(),
			ER1002JenisInvestasiPaydi.getObjects()),
	R003(ER1003JenisIndustri.getRefNumber(), ER1003JenisIndustri.getName(), ER1003JenisIndustri.getObjects()),
	R004(ER1014PeriodeLaporan.getRefNumber(), ER1014PeriodeLaporan.getName(), ER1014PeriodeLaporan.getObjects()),
	R005(ER1015Dati1.getRefNumber(), ER1015Dati1.getName(), ER1015Dati1.getObjects()),
	R006(ER1016Dati2.getRefNumber(), ER1016Dati2.getName(), ER1016Dati2.getObjects()),
	R007(ER1017DireksiKomisaris.getRefNumber(), ER1017DireksiKomisaris.getName(), ER1017DireksiKomisaris.getObjects()),
	R008(ER1018DalamLuarNegeri.getRefNumber(), ER1018DalamLuarNegeri.getName(), ER1018DalamLuarNegeri.getObjects()),
	R009(ER1019PeringkatKlaster.getRefNumber(), ER1019PeringkatKlaster.getName(), ER1019PeringkatKlaster.getObjects()),
	R010(ER1020JenisJaminan.getRefNumber(), ER1020JenisJaminan.getName(), ER1020JenisJaminan.getObjects()),
	R011(ER1021SektorEkonomi.getRefNumber(), ER1021SektorEkonomi.getName(), ER1021SektorEkonomi.getObjects()),
	R012(ER1022JenisNonInvestasi.getRefNumber(), ER1022JenisNonInvestasi.getName(),
			ER1022JenisNonInvestasi.getObjects()),
	R013(ER1023KategoriJenisNonInvestasi.getRefNumber(), ER1023KategoriJenisNonInvestasi.getName(),
			ER1023KategoriJenisNonInvestasi.getObjects()),
	R014(ER1024SumberAsetReasuransi.getRefNumber(), ER1024SumberAsetReasuransi.getName(),
			ER1024SumberAsetReasuransi.getObjects()),
	R015(ER1025JenisLiabilitas.getRefNumber(), ER1025JenisLiabilitas.getName(), ER1025JenisLiabilitas.getObjects()),
	R016(ER1026KategoriUtang.getRefNumber(), ER1026KategoriUtang.getName(), ER1026KategoriUtang.getObjects()),
	R017(ER1027JenisPendapatan.getRefNumber(), ER1027JenisPendapatan.getName(), ER1027JenisPendapatan.getObjects()),
	R018(ER1028DanaJaminan.getRefNumber(), ER1028DanaJaminan.getName(), ER1028DanaJaminan.getObjects()),
	R019(ER1029MataUang.getRefNumber(), ER1029MataUang.getName(), ER1029MataUang.getObjects()),
	R020(ER1030JenisPertanggungan.getRefNumber(), ER1030JenisPertanggungan.getName(),
			ER1030JenisPertanggungan.getObjects()),
	R021(ER1031MataUangIdrAtauUsd.getRefNumber(), ER1031MataUangIdrAtauUsd.getName(),
			ER1031MataUangIdrAtauUsd.getObjects()),
	R022(ER1032CaraBayar.getRefNumber(), ER1032CaraBayar.getName(), ER1032CaraBayar.getObjects()),
	R023(ER1033CabangAsuransi.getRefNumber(), ER1033CabangAsuransi.getName(), ER1033CabangAsuransi.getObjects()),
	R024(ER1034JenisImbalan.getRefNumber(), ER1034JenisImbalan.getName(), ER1034JenisImbalan.getObjects()),
	R025(ER1035CabangAsuransi.getRefNumber(), ER1035CabangAsuransi.getName(), ER1035CabangAsuransi.getObjects()),
	R026(ER1036TradisionalAtauPaydi.getRefNumber(), ER1036TradisionalAtauPaydi.getName(),
			ER1036TradisionalAtauPaydi.getObjects()),
	R027(ER1037Negara.getRefNumber(), ER1037Negara.getName(), ER1037Negara.getObjects()),
	R028(ER1038StatusProduk.getRefNumber(), ER1038StatusProduk.getName(), ER1038StatusProduk.getObjects()),
	R029(ER1039KanalDistribusi.getRefNumber(), ER1039KanalDistribusi.getName(), ER1039KanalDistribusi.getObjects()),
	R030(ER1040EstimasiProfitLoss.getRefNumber(), ER1040EstimasiProfitLoss.getName(),
			ER1040EstimasiProfitLoss.getObjects()),
	R031(ER1041MetodePerhitunganEstimasi.getRefNumber(), ER1041MetodePerhitunganEstimasi.getName(),
			ER1041MetodePerhitunganEstimasi.getObjects()),
	R032(ER1045CabangAsuransiUmum.getRefNumber(), ER1045CabangAsuransiUmum.getName(),
			ER1045CabangAsuransiUmum.getObjects()),
	R033(ER1048Dati2VsDati1Lapbul.getRefNumber(), ER1048Dati2VsDati1Lapbul.getName(),
			ER1048Dati2VsDati1Lapbul.getObjects()),
	R034(ER1049KodeBank.getRefNumber(), ER1049KodeBank.getName(), ER1049KodeBank.getObjects()),
	R035(ER1050JenisInvestasiVsKategori.getRefNumber(), ER1050JenisInvestasiVsKategori.getName(),
			ER1050JenisInvestasiVsKategori.getObjects()),
	R036(ER1051JenisInvestasiPaydiVsKategori.getRefNumber(), ER1051JenisInvestasiPaydiVsKategori.getName(),
			ER1051JenisInvestasiPaydiVsKategori.getObjects()),
	R037(ER1052JenisNonInvestasiVsKategori.getRefNumber(), ER1052JenisNonInvestasiVsKategori.getName(),
			ER1052JenisNonInvestasiVsKategori.getObjects()),
	R038(ER1062JenisInvestasiVsSektorEkonomi.getRefNumber(), ER1062JenisInvestasiVsSektorEkonomi.getName(),
			ER1062JenisInvestasiVsSektorEkonomi.getObjects()),
	R039(ER1063JenisLiabilitasVsKategoriUtang.getRefNumber(), ER1063JenisLiabilitasVsKategoriUtang.getName(),
			ER1063JenisLiabilitasVsKategoriUtang.getObjects()),
	R040(ER1093JenisInvestasiPaydiVsSektorEkonomi.getRefNumber(), ER1093JenisInvestasiPaydiVsSektorEkonomi.getName(),
			ER1093JenisInvestasiPaydiVsSektorEkonomi.getObjects()),
	R041(ER1096StatusAset.getRefNumber(), ER1096StatusAset.getName(), ER1096StatusAset.getObjects()),
	R042(ER1097JenisInvestasiVsSektorEkonomi.getRefNumber(), ER1097JenisInvestasiVsSektorEkonomi.getName(),
			ER1097JenisInvestasiVsSektorEkonomi.getObjects()),
	R043(ER1098JenisPemegangSaham.getRefNumber(), ER1098JenisPemegangSaham.getName(),
			ER1098JenisPemegangSaham.getObjects()),
	R044(ER1100Penilaian.getRefNumber(), ER1100Penilaian.getName(), ER1100Penilaian.getObjects()),
	R045(ER1101Kepemilikan.getRefNumber(), ER1101Kepemilikan.getName(), ER1101Kepemilikan.getObjects()),
	R046(ER1013JenisInvestasiSyariah.getRefNumber(), ER1013JenisInvestasiSyariah.getName(),
			ER1013JenisInvestasiSyariah.getObjects()),
	R047(ER1196JenisPolis.getRefNumber(), ER1196JenisPolis.getName(), ER1196JenisPolis.getObjects()),
	R048(ER1197JenisKelamin.getRefNumber(), ER1197JenisKelamin.getName(), ER1197JenisKelamin.getObjects()),
	R049(ER1198LokasiPemegangPolis.getRefNumber(), ER1198LokasiPemegangPolis.getName(),
			ER1198LokasiPemegangPolis.getObjects()),
	R050(ER1199LiniUsahaAsuransiJiwa.getRefNumber(), ER1199LiniUsahaAsuransiJiwa.getName(),
			ER1199LiniUsahaAsuransiJiwa.getObjects()),
	R051(ER1200LiniUsahaAsuransiUmum.getRefNumber(), ER1200LiniUsahaAsuransiUmum.getName(),
			ER1200LiniUsahaAsuransiUmum.getObjects()),
	R052(ER1201CaraBayar.getRefNumber(), ER1201CaraBayar.getName(), ER1201CaraBayar.getObjects()),
	R053(ER1202StatusPertanggungan.getRefNumber(), ER1202StatusPertanggungan.getName(),
			ER1202StatusPertanggungan.getObjects()),
	R054(ER1203JenisKlaimAsuransiJiwa.getRefNumber(), ER1203JenisKlaimAsuransiJiwa.getName(),
			ER1203JenisKlaimAsuransiJiwa.getObjects()),
	R055(ER1204JenisKlaimAsuransiUmum.getRefNumber(), ER1204JenisKlaimAsuransiUmum.getName(),
			ER1204JenisKlaimAsuransiUmum.getObjects()),	;

	@Getter
	private int number;
	private String name;
	private List<KeyValueString> references;

	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}

	public String getDescription() {
		return "R" + number + name;
	}

	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, ReferenceType.keyValue, getDescription(), "");
		res.setPerSegment(false);
		res.setLabel1Map(null);
		return res;
	}

	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataShared eEnum : EHeaderMetadataShared.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataShared eEnum : EHeaderMetadataShared.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
