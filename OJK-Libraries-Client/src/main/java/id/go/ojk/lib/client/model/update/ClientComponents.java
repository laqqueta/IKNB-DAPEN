package id.go.ojk.lib.client.model.update;

import com.google.common.collect.ImmutableMap;

public class ClientComponents {
	
	public final static ClientComponent clApplication 	= new ClientComponent("clApplication", 	"application", 	"",	"OJK-ASRJ-Client-Launcher.jar",		""				);
	public final static ClientComponent clLibrary 		= new ClientComponent("clLibrary", 		"library", 		"",	"library.zip",						"libs"				);

	public final static ClientComponent clSetup 		= new ClientComponent("clSetup", 		"setup", 		"",	"setup.jar", 						"resources"			);
	public final static ClientComponent clSetupBranch 	= new ClientComponent("clSetupBranch", 	"setup Branch", "",	"setup.jar", 						"resources"			);

	public final static ClientComponent clMetadata 		= new ClientComponent("clMetadata", 	"metadata", 	"",	"metadata.jar", 					"resources"			);
	public final static ClientComponent clReferences 	= new ClientComponent("clReferences", 	"references", 	"",	"references.jar", 					"resources"			);
	public final static ClientComponent clExcutable 	= new ClientComponent("clExcutable", 	"excutable", 	"",	"slik-client.exe", 					""						);

	public final static ClientComponent clFaq 			= new ClientComponent("clFaq", 			"faq", 			"",	"faq.zip", 							"resources/help"	);
	public final static ClientComponent clManual 		= new ClientComponent("clManual", 		"manual", 		"",	"manual.pdf", 						"resources/help"	);
	
	public final static String installerCl				= "installerCl";

	public final static ImmutableMap<String, ClientComponent> componentMap = new ImmutableMap.Builder<String, ClientComponent>()
		.put(clApplication.getName(), 	clApplication)
		.put(clLibrary.getName(), 		clLibrary)
		.put(clSetup.getName(), 		clSetup)
		.put(clSetupBranch.getName(), 	clSetupBranch)
		.put(clMetadata.getName(), 		clMetadata)
		.put(clReferences.getName(), 	clReferences)
		.put(clExcutable.getName(), 	clExcutable)
		.build();

	public static ClientComponent valueOf(String name){
		return componentMap.get(name);
	}

}
