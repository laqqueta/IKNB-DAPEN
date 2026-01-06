package id.go.ojk.util;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.argument.DtoArgument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EArgumentGeneratorBatFile implements IObject<DtoArgument> {
	PROJECT(1, "Project name"),
	FOLDER(1, "Project folder"),
	APPLICATION(1, "Application name"),
	CODE(1, "Application code"),
	;

	private int countArg;
	private String desc;

	@Override
	public DtoArgument getObject() {
		DtoArgument res = new DtoArgument();
		res.setId(name().toLowerCase());
		res.setCountArg(countArg);
		res.setDesc(desc);
		return res;
	}

	public static List<DtoArgument> getObjects() {
		List<DtoArgument> res = new ArrayList<>();
		for (EArgumentGeneratorBatFile eEnum : EArgumentGeneratorBatFile.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
