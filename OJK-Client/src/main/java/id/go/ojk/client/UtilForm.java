package id.go.ojk.client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.fx.FxmlLoaderUtil;
import id.go.ojk.client.util.fx.FxmlLoaderUtil.AfterInitFxml;
import id.go.ojk.client.util.fx.FxmlLoaderUtil.BeforeReShow;
import id.go.ojk.client.vc.BaseController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import javafx.scene.layout.Region;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilForm {
	private static final Logger logger = LoggerFactory.getLogger(UtilForm.class);

	public static <R extends Region, C extends BaseController> Tupple2<R, C> initAndShowPane(MainApplication mainApplication,
			String fxmlFile, Tupple2<R, C> cekUI, DisplayScene pDisplayScene, AfterInitFxml<R, C> afterInitFxml,
			BeforeReShow<R, C> beforeReShow) {
		try {
			if (cekUI == null) {
				cekUI = FxmlLoaderUtil.loadFxml(fxmlFile);
				if (afterInitFxml != null) {
					afterInitFxml.init(cekUI);
				}
				if (cekUI.getB().isReused()) {
					mainApplication.getReusedControllerList().add(cekUI.getB());
				}
			} else {
				if (beforeReShow != null) {
					beforeReShow.beforeReShow(cekUI);
				}
			}
			mainApplication.getRootBorderPane().setCenter(cekUI.getA());
			if (pDisplayScene != null)
				mainApplication.setDisplayScene(pDisplayScene);
		} catch (IOException e) {
			AlertUtil.showErrorSafe(logger, "", e);
		}
		return cekUI;
	}
}
