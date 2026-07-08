package id.go.ojk.metadata.module.lblt.header;

import id.go.ojk.conf.client.field.reference.*;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataSharedLkbt implements IObject<ReferenceMetadata> {
//	R001 (ER1010PeriodeRealisasi.getRefNumber(), ER1010PeriodeRealisasi.getName(), ER1010PeriodeRealisasi.getObjects()),
	R002 (ER1011Program.getRefNumber(), ER1011Program.getName(), ER1011Program.getObjects()),
//	R003 (ER1012KualitasPendanaan.getRefNumber(), ER1012KualitasPendanaan.getName(), ER1012KualitasPendanaan.getObjects()),
	R004(ER1250Properti.getRefNumber(), ER1250Properti.getName(), ER1250Properti.getObjects()),
	R005(ER1251MetodePencatatan.getRefNumber(), ER1251MetodePencatatan.getName(), ER1251MetodePencatatan.getObjects()),
	R006(ER1252Pengelolaan.getRefNumber(), ER1252Pengelolaan.getName(), ER1252Pengelolaan.getObjects()),
	R007(ER1253SektorEkonomi.getRefNumber(), ER1253SektorEkonomi.getName(), ER1253SektorEkonomi.getObjects()),
	R008(ER1254Reksadana.getRefNumber(), ER1254Reksadana.getName(), ER1254Reksadana.getObjects()),
	R009(ER1255JenisManfaat.getRefNumber(), ER1255JenisManfaat.getName(), ER1255JenisManfaat.getObjects()),
	R010(ER1256JenisValuta.getRefNumber(), ER1256JenisValuta.getName(), ER1256JenisValuta.getObjects()),
	R011(ER1257SandiBank.getRefNumber(), ER1257SandiBank.getName(), ER1257SandiBank.getObjects()),
	R012(ER1258SandiCounterParty.getRefNumber(), ER1258SandiCounterParty.getName(), ER1258SandiCounterParty.getObjects()),
	R013(ER1259SandiCounterparty.getRefNumber(), ER1259SandiCounterparty.getName(), ER1259SandiCounterparty.getObjects()),
	R014(ER1260KategoriRepo.getRefNumber(), ER1260KategoriRepo.getName(), ER1260KategoriRepo.getObjects()),
	R015(ER1261JenisJaminan.getRefNumber(), ER1261JenisJaminan.getName(), ER1261JenisJaminan.getObjects()),
	R016(ER1262BuktiKepemilikan.getRefNumber(), ER1262BuktiKepemilikan.getName(), ER1262BuktiKepemilikan.getObjects()),
	R017(ER1263BebanInvestasi.getRefNumber(), ER1263BebanInvestasi.getName(), ER1263BebanInvestasi.getObjects()),
	R018(ER1264BebanOperasinal.getRefNumber(), ER1264BebanOperasinal.getName(), ER1264BebanOperasinal.getObjects()),
	R019(ER1265KategoriPenyertaan.getRefNumber(), ER1265KategoriPenyertaan.getName(), ER1265KategoriPenyertaan.getObjects()),
	R020(ER1266RincianManfaatLain.getRefNumber(), ER1266RincianManfaatLain.getName(), ER1266RincianManfaatLain.getObjects()),
	R021(ER1267RincianInvestasi.getRefNumber(), ER1267RincianInvestasi.getName(), ER1267RincianInvestasi.getObjects()),
	R022(ER1268JenisInvestasi.getRefNumber(), ER1268JenisInvestasi.getName(), ER1268JenisInvestasi.getObjects()),
	R023(ER1269MetodePendanaan.getRefNumber(), ER1269MetodePendanaan.getName(), ER1269MetodePendanaan.getObjects()),
	;

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
		for (EHeaderMetadataSharedLkbt eEnum : EHeaderMetadataSharedLkbt.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataSharedLkbt eEnum : EHeaderMetadataSharedLkbt.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}

}
