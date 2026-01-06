package id.go.ojk.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.argument.Arguments;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneratorProjectFile extends Arguments {
	private static final String RENAME = "rename *";
	private static final String PREVIOUS = "cd ..";
	private static final String NEXT = "cd .\\";
	private static final String LOG_TEMPLATE = "gen {}";
	private static final String EXT = ".bat";
	private static final String EXT_0 = ".ba_";
	private static final String FOLDER_SOURCE = "\\_installer\\source\\";
	private String projectName;
	private String projectFolder;
	private String projectClient;
	private String projectClientBuilder;
	private String applicationName;
	private String applicationCode;
	private String jarClientBuilder;

	public static void main(String[] args) {
		try {
			log.info("<Start>");
			GeneratorProjectFile generator = new GeneratorProjectFile(args);
			generator.genAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			log.info("<End>");
		}
	}

	public GeneratorProjectFile(String[] args) {
		super(GeneratorProjectFile.class.getSimpleName(), args, EArgumentGeneratorBatFile.getObjects());
		final String defaultProject = "OJK-PNJK";
		final String defaultFolder = "D:\\_workspace\\_other\\ojk\\IKNBClient\\OJK-PNJK";
		final String defaultApplication = "PNJK";
		final String defaultCode = "030403";
		projectName = getOptionValue(EArgumentGeneratorBatFile.PROJECT.name().toLowerCase(), defaultProject);
		projectFolder = getOptionValue(EArgumentGeneratorBatFile.FOLDER.name().toLowerCase(), defaultFolder);
		applicationName = getOptionValue(EArgumentGeneratorBatFile.APPLICATION.name().toLowerCase(), defaultApplication);
		applicationCode = getOptionValue(EArgumentGeneratorBatFile.CODE.name().toLowerCase(), defaultCode);
		projectClient = projectName + "-Client";
		projectClientBuilder = projectClient + "-Builder";
		jarClientBuilder = projectClientBuilder + "\\target\\" + projectClientBuilder + "-shaded.jar";
		if (!new File(projectFolder).exists()) {
			throw new NullPointerException(projectFolder);
		}
	}

	public void genAll() {
		copyInstallerSourceFolder();
		genSetJava();
		genToBat();
		genFromBat();
		genClean();
		genCompile();
		genConfigureEclipse();
		genBuild();
		genInstall();
		genDependencyCheck();
		genDependencyTree();
		genDependencyVulnerability();
		genBuildDat();
		genBuildExe();
		genBuildInstaller();
		genBuildDatInstaller();
		genClientClearResources();
		genClientPrepareResources();
		genVersionNew();
		genVersionClientNew();
		genVersionRevert();
		genSonarqubeAnalyze();
	}

	private void copyInstallerSourceFolder() {
		File folderSource = new File("..\\Note\\source");
		String folderNameDestination = projectFolder + FOLDER_SOURCE;
		File folderDestination = new File(folderNameDestination);
		if (!folderDestination.exists()) {
			folderDestination.mkdirs();
		}
		try {
			log.info("{}->{}", folderSource.getAbsolutePath(), folderDestination.getAbsolutePath());
			FileUtils.copyDirectory(folderSource, folderDestination);
			updateFileClientIss(folderNameDestination);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void updateFileClientIss(String folder) {
		File fileClientIss = new File(FilenameUtils.concat(folder, "Client.iss"));
		writeContent(fileClientIss, readContent(fileClientIss));
	}

	private String readContent(File fileClientIss) {
		StringBuilder res = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileClientIss))) {
			String line = reader.readLine();
			while (line != null) {
				line = reader.readLine();
				res.append(replaceString(line));
				if (line != null) {
					res.append(System.lineSeparator());
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return res.toString();
	}

	private void writeContent(File fileClientIss, String content) {
		try {
			FileUtils.writeStringToFile(fileClientIss, content);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private String replaceString(String string) {
		if (string == null) {
			return "";
		}
		if (string.contains("%NAME%")) {
			string = StringUtils.replace(string, "%NAME%", applicationName);
		}
		if (string.contains("%NAME1%")) {
			string = StringUtils.replace(string, "%NAME1%", StringUtils.capitalize(applicationName.toLowerCase()));
		}
		if (string.contains("%CODE%")) {
			string = StringUtils.replace(string, "%CODE%", applicationCode);
		}
		return string;
	}

	private void genSetJava() {
		StringBuilder builder = new StringBuilder();
		builder.append("SET JAVA_HOME=D:\\_dev_tool\\java\\jdk\\jdk1.8.0_202").append(System.lineSeparator());
		builder.append("SET PATH=%Path%;%JAVA_HOME%\\bin\\;").append(System.lineSeparator());
		builder.append("SET").append(System.lineSeparator());
		writeFile("_0-set-env", builder.toString());
	}

	private void genToBat() {
		StringBuilder builder = new StringBuilder();
		builder.append(RENAME).append(EXT_0).append(" *").append(EXT).append(System.lineSeparator());
		builder.append(NEXT).append(FOLDER_SOURCE).append(System.lineSeparator());
		builder.append(RENAME).append(EXT_0).append(" *").append(EXT).append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		writeFile("_1-to-bat", builder.toString());
	}

	private void genFromBat() {
		StringBuilder builder = new StringBuilder();
		builder.append(NEXT).append(FOLDER_SOURCE).append(System.lineSeparator());
		builder.append(RENAME).append(EXT).append(" *").append(EXT_0).append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		builder.append(RENAME).append(EXT).append(" *").append(EXT_0).append(System.lineSeparator());
		writeFile("_2-from-bat", builder.toString());
	}

	private void genBuild() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn clean package -am -DskipTests -pl !").append(projectClient).append(System.lineSeparator());
		writeFile("_build", builder.toString());
	}

	private void genBuildDat() {
		StringBuilder builder = new StringBuilder();
		builder.append("ECHO \"<<GENERATE DAT FILE>>\"").append(System.lineSeparator());
		builder.append("del /F .\\_installer\\ftp\\app\\*.dat").append(System.lineSeparator());
		builder.append("call java -jar -Dfile.encoding=UTF-8 ");
		builder.append(".\\").append(jarClientBuilder).append(" ");
		builder.append("\"--rootFolder=.\\_installer\" \"--enviType=DEVEL\" \"--ftpServer=FTP01\"")
				.append(System.lineSeparator());
		writeFile("_build-dat", builder.toString());
	}

	private void genBuildDatInstaller() {
		StringBuilder builder = new StringBuilder();
		builder.append("call _build.bat").append(System.lineSeparator());
		builder.append("call _build-dat.bat").append(System.lineSeparator());
		builder.append("call _build-installer.bat").append(System.lineSeparator());
		writeFile("_build-dat-installer", builder.toString());
	}

	private void genBuildExe() {
		StringBuilder builder = new StringBuilder();
		builder.append("ECHO \"<<PREPARE BUILD EXE>>\"").append(System.lineSeparator());
		builder.append("call _client-clear-resources.bat").append(System.lineSeparator());
		builder.append("ECHO \"<<BUILD & DEPLOY EXE>>\"").append(System.lineSeparator());
		builder.append("mkdir .\\_installer\\deploy\\resources\\").append(System.lineSeparator());
		builder.append("del /F /Q .\\_installer\\deploy\\resources\\*").append(System.lineSeparator());
		builder.append("call mvn clean package -am -DskipTests -pl ").append(projectClient)
				.append(System.lineSeparator());
		builder.append("copy .\\").append(projectClient)
				.append("\\target\\OjkClient.exe .\\_installer\\deploy\\OjkClient.exe").append(System.lineSeparator());
		builder.append("copy .\\_installer\\source\\Client.cfg .\\_installer\\deploy\\resources\\Client.cfg")
				.append(System.lineSeparator());
		writeFile("_build-exe", builder.toString());
	}

	private void genBuildInstaller() {
		StringBuilder builder = new StringBuilder();
		builder.append("call _build-exe.bat").append(System.lineSeparator());
		builder.append(NEXT).append(FOLDER_SOURCE).append(System.lineSeparator());
		builder.append("call _installer.bat").append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		builder.append("call java -cp \".\\").append(jarClientBuilder).append(";.\" id.go.ojk.")
				.append(applicationName.toLowerCase())
				.append(".client.builder.InstallerFtpSync \"--ftpServer=FTP01\" \"--ftpAppFolder=.\\_installer\\ftp\\app\" \"--enviType=DEVEL\"")
				.append(System.lineSeparator());
		writeFile("_build-installer", builder.toString());
	}

	private void genClean() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn clean").append(System.lineSeparator());
		writeFile("_clean", builder.toString());
	}

	private void genClientClearResources() {
		StringBuilder builder = new StringBuilder();
		builder.append(NEXT).append(projectClient).append(System.lineSeparator());
		builder.append("del /F /Q .\\resources\\help\\*").append(System.lineSeparator());
		builder.append("rmdir /Q .\\resources\\help").append(System.lineSeparator());
		builder.append("del /F /Q .\\resources\\*").append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		writeFile("_client-clear-resources", builder.toString());
	}

	private void genClientPrepareResources() {
		StringBuilder builder = new StringBuilder();
		builder.append("@ECHO OFF").append(System.lineSeparator());
		builder.append("IF \"%1\" == \"\" GOTO :ERROR").append(System.lineSeparator());
		builder.append("@ECHO ON").append(System.lineSeparator());
		builder.append("ECHO \"<<BUILD CONFIG GENERATOR>>\"").append(System.lineSeparator());
		builder.append("call mvn clean package -am -DskipTests -pl ").append(projectClientBuilder)
				.append(System.lineSeparator());
		builder.append("ECHO \"<<GENERATE DAT FILE>>\"").append(System.lineSeparator());
		builder.append("call java -jar -Dfile.encoding=UTF-8 .\\").append(jarClientBuilder)
				.append(" \"--rootFolder=.\\_installer\" \"--ljkCode=%1\"").append(System.lineSeparator());
		builder.append("call _client-clear-resources.bat").append(System.lineSeparator());
		builder.append(NEXT).append(projectClient).append(System.lineSeparator());
		builder.append("mkdir .\\resources > NUL").append(System.lineSeparator());
		builder.append("copy ..\\_installer\\entity\\%1\\data.dat .\\resources").append(System.lineSeparator());
		builder.append("copy ..\\_installer\\source\\Client.properties .\\resources").append(System.lineSeparator());
		builder.append("copy ..\\_installer\\source\\Client.cfg .\\resources").append(System.lineSeparator());
		builder.append(PREVIOUS).append(System.lineSeparator());
		builder.append("GOTO :DONE").append(System.lineSeparator());
		builder.append(":ERROR").append(System.lineSeparator());
		builder.append("ECHO \"LJK Code Undefined!!!\"").append(System.lineSeparator());
		builder.append(":DONE").append(System.lineSeparator());
		writeFile("_client-prepare-resources", builder.toString());
	}

	private void genCompile() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn clean compile -am -DskipTests -pl !").append(projectClient).append(System.lineSeparator());
		writeFile("_compile", builder.toString());
	}

	private void genConfigureEclipse() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn clean eclipse:eclipse").append(System.lineSeparator());
		writeFile("_configure-eclipse", builder.toString());
	}

	private void genInstall() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn clean install -am -DskipTests -pl !").append(projectClient).append(System.lineSeparator());
		writeFile("_install", builder.toString());
	}

	private void genVersionNew() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn versions:set -DnewVersion=3.3.3").append(System.lineSeparator());
		writeFile("_version-new", builder.toString());
	}

	private void genVersionClientNew() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn versions:set-property -Dproperty=version.").append(projectClient)
				.append(" -DnewVersion=1.1.0").append(System.lineSeparator());
		writeFile("_version-client-new", builder.toString());
	}

	private void genVersionRevert() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn versions:revert").append(System.lineSeparator());
		writeFile("_version-revert", builder.toString());
	}

	private void genDependencyCheck() {
		StringBuilder builder = new StringBuilder();
		builder.append(
				"mvn versions:display-dependency-updates versions:display-plugin-updates --log-file dependency.txt")
				.append(System.lineSeparator());
		writeFile("_dependency-check", builder.toString());
	}

	private void genDependencyTree() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn dependency:tree --log-file dependency-tree.txt").append(System.lineSeparator());
		writeFile("_dependency-tree", builder.toString());
	}

	private void genDependencyVulnerability() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn dependency-check:aggregate -DskipTests").append(System.lineSeparator());
		writeFile("_dependency-vulnerability", builder.toString());
	}

	private void genSonarqubeAnalyze() {
		StringBuilder builder = new StringBuilder();
		builder.append("mvn clean verify -DskipTests sonar:sonar -Dsonar.projectKey=").append(projectName.toLowerCase())
				.append(" -Dsonar.host.url=http://localhost:9000 -Dsonar.login=xxx").append(System.lineSeparator());
		writeFile("_sonarqube-analyze", builder.toString());
	}

	private String genFilename(String filename) {
		return FilenameUtils.concat(projectFolder, filename + EXT_0);
	}

	private void writeFile(String filename, String content) {
		try {
			filename = genFilename(filename);
			log.info(LOG_TEMPLATE, filename);
			FileUtils.writeByteArrayToFile(new File(filename), content.getBytes());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
